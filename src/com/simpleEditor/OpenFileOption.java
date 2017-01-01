package com.simpleEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.IOException;



public class OpenFileOption extends AbstractAction {
    private TextEditor myEditor;

    public OpenFileOption(TextEditor _myEditor) {
        super("Open file");
        myEditor = _myEditor;
        return;
    }

    public void actionPerformed(ActionEvent e) {
        if (myEditor.fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            openFile(myEditor.fileChooser.getSelectedFile().getAbsolutePath());
        return;
    }

    private void openFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            myEditor.editorText.read(reader,null);
            reader.close();
            myEditor.currentFile = filename;
            myEditor.setTitle(filename);
            myEditor.modifiedFlag = false;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(myEditor.editorText, "Cannot find file " + filename);
        }
        return;
    }

}
