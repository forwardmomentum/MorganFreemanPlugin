package com.forwardmomentum.intellij.plugins.freeman;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Model stores all project-level data for Morgan Freeman plugin
 * Created by forwardmomentum on 12.05.17.
 */
public class FreemanModel {

    @Expose
    private String path = "default";

    private Project project;

    public FreemanModel(Project pr) {
        this.project = pr;
        this.load();
    }

    /**
     * Reads model's data from file
     */
    public void load() {
        try {
            String strModel = Files.readAllLines(Paths.get(project.getBaseDir().getPath() + "/freeman.json")).get(0);
            this.loadFromString(strModel);
        } catch (IllegalStateException ise) {
            System.out.println("There is not parsable file!");
            // todo make normal error report for user
//            this.save();
        } catch (IOException ioe) {
            System.out.println("There is no freeman file, and it will be created!");
            this.save();
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("File is empty!");
            this.save();
        }
    }

    /**
     * Deserializes string to FreemanModel data
     *
     * @param serStr - string json with model (from file)
     */
    private void loadFromString(String serStr) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        FreemanModel fm = gson.fromJson(serStr, this.getClass());
        this.path = fm.path;
    }

    /**
     * Serializes model data to json file
     */
    public void save() {
        String modelString = this.toJsonString();
        ApplicationManager.getApplication().runWriteAction(() -> {
            try {
                File modelFile = new File(project.getBaseDir().getPath() + "/freeman.json");
                if(!modelFile.exists()) modelFile.createNewFile();
                VirtualFile freemanVF = LocalFileSystem.getInstance()
                        .refreshAndFindFileByIoFile(modelFile);
                freemanVF.setBinaryContent(modelString.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException npe) {
                System.out.println("Null pointer in save");
            }
        });
    }

    /**
     * Serializes model to json string
     *
     * @return json string
     */
    private String toJsonString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Modelka{" +
                "gaugePath='" + path;
    }
}
