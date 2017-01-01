package com.simpleEditor;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextEditor extends JFrame {
    public JTextArea editorText = new JTextArea(40,80);
    public String currentFile = "Untitled document";
    public boolean modifiedFlag =  false;
    public JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

    public TextEditor() {
        setFontSize(12);
        addScrollFeature();
        addMenuBar();
        setTitle(currentFile);
        pack();
        setVisible(true);
        return;
    }

    private void attachComponents() {
        add(fileChooser);
        add(editorText);
        return;
    }

    private void setFontSize(int fontSize) {
        editorText.setFont(new Font("Monospace", Font.PLAIN, fontSize));
        return;
    }

    private void addScrollFeature() {
        JScrollPane scrollFeature = new JScrollPane(editorText);
        add(editorText, BorderLayout.CENTER);
        return;
    }

    private void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        addFileDropdown(menuBar);
        addEditDropdown(menuBar);
        setJMenuBar(menuBar);
        return;
    }

    private void addFileDropdown(JMenuBar menuBar) {
        JMenu fileDropdown = new JMenu("File");
        addSaveFileOptionToMenu(fileDropdown);
        addOpenFileOptionToMenu(fileDropdown);
        addNewFileOptionToMenu(fileDropdown);
        menuBar.add(fileDropdown);
        return;
    }

    private void addEditDropdown(JMenuBar menuBar) {
        JMenu editDropdown = new JMenu("Edit");
        addCutTextOptionToMenu(editDropdown);
        addCopyTextOptionToMenu(editDropdown);
        addPasteTextOptionToMenu(editDropdown);
        menuBar.add(editDropdown);
        return;
    }

    private void addSaveFileOptionToMenu(JMenu dropdown) {
        JMenuItem saveFileOption = new JMenuItem(new SaveFileOption(this));
        dropdown.add(saveFileOption);
        return;
    }

    private void addOpenFileOptionToMenu(JMenu dropdown) {
        JMenuItem openFileOption = new JMenuItem(new OpenFileOption(this));
        dropdown.add(openFileOption);
        return;
    }

    private void addNewFileOptionToMenu(JMenu dropdown) {
        JMenuItem newFileOption = new JMenuItem(new NewFileOption(this));
        dropdown.add(newFileOption);
        return;
    }

    private void addCutTextOptionToMenu(JMenu dropdown) {
        JMenuItem cutTextOption = new JMenuItem(new CutTextOption(this));
        dropdown.add(cutTextOption);
        return;
    }

    private void addCopyTextOptionToMenu(JMenu dropdown) {
        JMenuItem copyTextOption = new JMenuItem(new CopyTextOption(this));
        dropdown.add(copyTextOption);
        return;
    }

    private void addPasteTextOptionToMenu(JMenu dropdown) {
        JMenuItem pasteTextOption = new JMenuItem(new PasteTextOption(this));
        dropdown.add(pasteTextOption);
        return;
    }

    public static void main(String[] args) {
        new TextEditor();
        return;
    }
}
