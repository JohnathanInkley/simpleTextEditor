package com.simpleEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CutTextOption extends AbstractAction {
    private TextEditor myEditor;

    public CutTextOption(TextEditor _myEditor) {
        super("Cut");
        myEditor = _myEditor;
        return;
    }

    public void actionPerformed(ActionEvent e) {
        myEditor.editorText.cut();
        return;
    }
}

