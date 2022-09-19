package ru.vsu.cs.kg2022.novichikhin.task_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrawPanel extends JPanel {
    private Timer timer;

    public DrawPanel() {
        timer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.addSecond();
                repaint();
            }
        });
        timer.start();
    }

    Wallpaper wallpaper = new Wallpaper(1522, 827, 15);
    PendulumClock clock = new PendulumClock(750, 400, 100, 3000);
    ShelfWithBooks shelfWithBooks = new ShelfWithBooks(100, 450, 300,
            new String[]{"ТИХИЙ ДОН (ТОМ 1)", "ТИХИЙ ДОН (ТОМ 2)", "ПРЕСТУПЛЕНИЕ И НАКАЗАНИЕ", "ВОЙНА И МИР (ТОМ 1)",
                    "ВОЙНА И МИР (ТОМ 2)", "ВОЙНА И МИР (ТОМ 3)", "ВОЙНА И МИР (ТОМ 4)", "АНЕКДОТЫ", " ИДИОТ",
                    "ОБЖ 5 КЛАСС", "ДЕМИДОВИЧ", "МАСТЕР И МАРГАРИТА", "БЕСЫ"},
            new Color[]{new Color(0x4356D0), new Color(0x4356D0), new Color(0x030934), new Color(0x822EEA),
                    new Color(0x822EEA), new Color(0x822EEA), new Color(0x822EEA),
                    new Color(0xF34C05), new Color(0x860D0D), new Color(0xD5142A),
                    new Color(0x0B0B10), new Color(0x2A2633), new Color(0x565645)});
    Picture picture = new Picture(1100, 275, 300, 200);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        wallpaper.draw(graphics2D);
        clock.draw(graphics2D);
        shelfWithBooks.draw(graphics2D);
        picture.draw(graphics2D);
    }
}