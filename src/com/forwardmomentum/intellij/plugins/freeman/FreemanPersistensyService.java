package com.forwardmomentum.intellij.plugins.freeman;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.intellij.openapi.components.RoamingType.DISABLED;

/**
 * Created by forwardmomentum on 11.05.17.
 */
public class FreemanPersistensyService {

    private static FreemanPersistensyService instance;
    private static FreemanModel model;

    private FreemanPersistensyService() {
        model = this.getModel();
    }

    public static FreemanPersistensyService getInstance(Project project) {
        if (instance == null) {
            instance = new FreemanPersistensyService();
        }
        if(model == null) {
            model = new FreemanModel(project);
        }
        return instance;
    }

    public FreemanModel getModel() {
        return model;
    }


}
