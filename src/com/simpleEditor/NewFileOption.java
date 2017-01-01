package com.simpleEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class NewFileOption extends AbstractAction {
    private TextEditor myEditor;

    public NewFileOption(TextEditor _myEditor) {
        super("New file");
        myEditor = _myEditor;
        return;
    }

    public void actionPerformed(ActionEvent e) {
        int userWantsToSaveFile = JOptionPane.showConfirmDialog(null, "Do you want to" +
                " save the current file?");
        if (userWantsToSaveFile == JOptionPane.YES_OPTION) {
            SaveFileOption saveCurrentResult = new SaveFileOption(myEditor);
            saveCurrentResult.actionPerformed(e);
        }
        newFile();
        return;
    }

    private void newFile() {
        myEditor.editorText.setText(null);
        myEditor.currentFile = "Untitled document";
        myEditor.setTitle(myEditor.currentFile);
        return;
    }
}
