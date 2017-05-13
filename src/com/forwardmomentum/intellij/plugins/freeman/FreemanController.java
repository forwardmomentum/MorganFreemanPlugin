package com.forwardmomentum.intellij.plugins.freeman;

import com.forwardmomentum.intellij.plugins.freeman.model.FreemanModel;
import com.intellij.openapi.project.Project;

/**
 * Created by forwardmomentum on 11.05.17.
 */
public class FreemanController {

    private static FreemanController instance;
    private static FreemanModel model;

    private FreemanController() {
        model = this.getModel();
    }

    public static FreemanController getInstance(Project project) {
        if (instance == null) {
            instance = new FreemanController();
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
