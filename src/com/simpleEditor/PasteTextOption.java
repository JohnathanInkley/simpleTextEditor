package com.simpleEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PasteTextOption extends AbstractAction {
    private TextEditor myEditor;

    public PasteTextOption(TextEditor _myEditor) {
        super("Paste");
        myEditor = _myEditor;
        return;
    }

    public void actionPerformed(ActionEvent e) {
        myEditor.editorText.paste();
        return;
    }
}

