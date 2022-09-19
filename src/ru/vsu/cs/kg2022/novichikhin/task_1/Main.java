package ru.vsu.cs.kg2022.novichikhin.task_1;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Main {
    public static void main(String[] args) {
       MainWindow window = new MainWindow();
       window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
       Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
       window.setSize(size);
       window.setVisible(true);
    }
}