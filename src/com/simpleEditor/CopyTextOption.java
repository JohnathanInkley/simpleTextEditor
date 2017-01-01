package com.simpleEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyTextOption extends AbstractAction {
    private TextEditor myEditor;

    public CopyTextOption(TextEditor _myEditor) {
        super("Copy");
        myEditor = _myEditor;
        return;
    }

    public void actionPerformed(ActionEvent e) {
        myEditor.editorText.copy();
        return;
    }
}

