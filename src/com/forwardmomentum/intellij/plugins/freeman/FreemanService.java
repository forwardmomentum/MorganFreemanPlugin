package com.forwardmomentum.intellij.plugins.freeman;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

/**
 * Created by forwardmomentum on 11.05.17.
 */
@Storage("freeman.xml")
public class FreemanService implements PersistentStateComponent<FreemanService> {

    public String stateValue;

    public FreemanService getState() {
        return this;
    }

    public void loadState(FreemanService state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}
