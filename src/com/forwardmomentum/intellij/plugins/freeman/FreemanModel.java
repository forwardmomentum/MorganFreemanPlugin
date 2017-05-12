package com.forwardmomentum.intellij.plugins.freeman;

/**
 * Created by forwardmomentum on 12.05.17.
 */
public class FreemanModel {

    public String path;

    public FreemanModel(String path) {
        this.path = path;
    }

    public FreemanModel() {
        this("default_path");
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
