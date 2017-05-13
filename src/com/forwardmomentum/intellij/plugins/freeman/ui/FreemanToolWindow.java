package com.forwardmomentum.intellij.plugins.freeman.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Created by forwardmomentum on 13.05.17.
 */
public class FreemanToolWindow implements ToolWindowFactory {

    private JPanel mfPanel;
    private JButton callMorganFreemanButton;
    private ToolWindow myToolWindow;


    public FreemanToolWindow() {
    }

    // Create the tool window content.
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        myToolWindow = toolWindow;
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(mfPanel, "", false);
        toolWindow.getContentManager().addContent(content);
    }

}