package com.forwardmomentum.intellij.plugins.freeman;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.IconLoader;

import java.util.Random;

/**
 * Created by forwardmomentum on 11.05.17.
 */
public class AddFreemanPointAction extends AnAction {

    public AddFreemanPointAction() {
        super("Add Freeman's Point", "Adds Freeman's Point", IconLoader.getIcon("/icons/mf.png"));
    }

    public void actionPerformed(AnActionEvent event) {

//        Project project = event.getData(CommonDataKeys.PROJECT);
//        String txt= Messages.showInputDialog(project, FreemanService.getSettings().getPath(), "Input your name", Messages.getQuestionIcon());
//        Messages.showMessageDialog(project, "Hello, " + txt + "!\n I am glad to see you.", "Information", Messages.getInformationIcon());

        System.out.println(FreemanPersistensyService.getInstance().getModel().getPath());

        FreemanPersistensyService.getInstance().getModel().setPath("Olala");
        FreemanPersistensyService.getInstance().save();

        //        event.getData(LangDataKeys.PSI_FILE);

//        final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
//        final Project project = event.getRequiredData(CommonDataKeys.PROJECT);
//        final Document document = editor.getDocument();
//        final SelectionModel selectionModel = editor.getSelectionModel();
//
//        final int start = selectionModel.getSelectionStart();
//        final int end = selectionModel.getSelectionEnd();
//
////        editor.getGutter().
//        //New instance of Runnable to make a replacement
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                document.replaceString(start, end, "Replacement");
//
//
//            }
//        };
//        //Making the replacement
//        WriteCommandAction.runWriteCommandAction(project, runnable);
//        selectionModel.removeSelection();

//        CaretModel caretModel = editor.getCaretModel();
//        LogicalPosition logicalPosition = caretModel.getLogicalPosition();
//        VisualPosition visualPosition = caretModel.getVisualPosition();
//        int offset = caretModel.getOffset();
    }

    @Override
    public void update(final AnActionEvent e) {
        //Get required data keys
        final Project project = e.getData(CommonDataKeys.PROJECT);
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        //Set visibility only in case of existing project and editor
        e.getPresentation().setVisible((project != null && editor != null));
    }

}