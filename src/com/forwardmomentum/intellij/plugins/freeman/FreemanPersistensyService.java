package com.forwardmomentum.intellij.plugins.freeman;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

import static com.intellij.openapi.components.RoamingType.DISABLED;

/**
 * Created by forwardmomentum on 11.05.17.
 */
public class FreemanPersistensyService {

    private static FreemanPersistensyService instance;
    private FreemanModel model;

    private FreemanPersistensyService() {
        this.model = this.getModel();
    }

    public static FreemanPersistensyService getInstance() {
        if (instance == null) {
            instance = new FreemanPersistensyService();
        }
        return instance;
    }

    public FreemanModel getModel() {
        this.model = this.readModel();  //todo every get reads file, mb should be fixed
        return model;
    }

    public void save() {
        this.writeModel();
    }

    private FreemanModel readModel() {
        // todo read file with freeman project model
        return null;
    }

    private void writeModel() {
        //todo write file with model
    }

}
