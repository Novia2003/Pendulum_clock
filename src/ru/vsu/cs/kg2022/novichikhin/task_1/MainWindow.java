package ru.vsu.cs.kg2022.novichikhin.task_1;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        DrawPanel drawPanel = new DrawPanel();
        add(drawPanel);
    }
}
