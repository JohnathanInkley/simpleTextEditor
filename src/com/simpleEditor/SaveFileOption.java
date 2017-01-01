package com.simpleEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileOption extends AbstractAction {
    private TextEditor myEditor;

    public SaveFileOption(TextEditor _myEditor) {
        super("Save file");
        myEditor = _myEditor;
        return;
    }

    public void actionPerformed(ActionEvent e) {
        if (myEditor.fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
            saveFile(myEditor.fileChooser.getSelectedFile().getAbsolutePath());
        return;
    }

    private void saveFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            myEditor.editorText.write(writer);
            writer.close();
            myEditor.currentFile = filename;
            myEditor.setTitle(filename);
            myEditor.modifiedFlag = false;
        } catch (IOException e) {
        }
    }

}
