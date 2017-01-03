package com.simpleEditor;

import java.awt.*;
import javax.swing.*;

public class TextEditor extends JFrame {
    JTextArea editorText = new JTextArea(40,80);
    String currentFile = "Untitled document";
    boolean modifiedFlag =  false;
    JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

    public TextEditor() {
        setFontSize(12);
        addScrollFeature();
        addMenuBar();
        setTitle(currentFile);
        pack();
        setVisible(true);
    }

    private void attachComponents() {
        add(fileChooser);
        add(editorText);
    }

    private void setFontSize(int fontSize) {
        editorText.setFont(new Font("Monospace", Font.PLAIN, fontSize));
    }

    private void addScrollFeature() {
        JScrollPane scrollFeature = new JScrollPane(editorText);
        add(editorText, BorderLayout.CENTER);
    }

    private void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        addFileDropdown(menuBar);
        addEditDropdown(menuBar);
        setJMenuBar(menuBar);
    }

    private void addFileDropdown(JMenuBar menuBar) {
        JMenu fileDropdown = new JMenu("File");
        addSaveFileOptionToMenu(fileDropdown);
        addOpenFileOptionToMenu(fileDropdown);
        addNewFileOptionToMenu(fileDropdown);
        menuBar.add(fileDropdown);
    }

    private void addEditDropdown(JMenuBar menuBar) {
        JMenu editDropdown = new JMenu("Edit");
        addCutTextOptionToMenu(editDropdown);
        addCopyTextOptionToMenu(editDropdown);
        addPasteTextOptionToMenu(editDropdown);
        menuBar.add(editDropdown);
    }

    private void addSaveFileOptionToMenu(JMenu dropdown) {
        JMenuItem saveFileOption = new JMenuItem(new SaveFileOption(this));
        dropdown.add(saveFileOption);
    }

    private void addOpenFileOptionToMenu(JMenu dropdown) {
        JMenuItem openFileOption = new JMenuItem(new OpenFileOption(this));
        dropdown.add(openFileOption);
    }

    private void addNewFileOptionToMenu(JMenu dropdown) {
        JMenuItem newFileOption = new JMenuItem(new NewFileOption(this));
        dropdown.add(newFileOption);
    }

    private void addCutTextOptionToMenu(JMenu dropdown) {
        JMenuItem cutTextOption = new JMenuItem(new CutTextOption(this));
        dropdown.add(cutTextOption);
    }

    private void addCopyTextOptionToMenu(JMenu dropdown) {
        JMenuItem copyTextOption = new JMenuItem(new CopyTextOption(this));
        dropdown.add(copyTextOption);
    }

    private void addPasteTextOptionToMenu(JMenu dropdown) {
        JMenuItem pasteTextOption = new JMenuItem(new PasteTextOption(this));
        dropdown.add(pasteTextOption);
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
