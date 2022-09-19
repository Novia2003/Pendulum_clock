package ru.vsu.cs.kg2022.novichikhin.task_1;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class PendulumClock {
    private final int x;
    private final int y;
    private final int radius;
    private int seconds;

    public PendulumClock(int x, int y, int radius, int minutes) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.seconds = minutes;
    }

    public void addSecond() {
        seconds++;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(224, 96, 12));
        graphics2D.fillRoundRect((int) (x - radius * 1.5), (int) (y - radius * 1.5), 3 * radius, 3 * radius,
                10, 10);

        drawClockFace(graphics2D);
        drawRoof(graphics2D);
        drawPendulum(graphics2D);
    }

    private void drawClockFace(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

        drawHandsClock(graphics2D);

        double angleRotation = Math.PI / 30;
        int hour = 4;

        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font("Times", Font.PLAIN, 15));

        for (int i = 1; i <= 60; i++) {
            boolean isNumberMultiplyFive = i % 5 == 0;
            double ratio = (isNumberMultiplyFive) ? 0.85 : 0.9;

            double currentAngle = i * angleRotation;

            double x1 = ratio * radius * Math.cos(currentAngle) + x;
            double x2 = 0.95 * radius * Math.cos(currentAngle) + x;
            double y1 = ratio * radius * Math.sin(currentAngle) + y;
            double y2 = 0.95 * radius * Math.sin(currentAngle) + y;

            graphics2D.drawLine((int) x1, (int) y1, (int) x2, (int) y2);

            if (i % 5 == 0) {
                if (hour > 12) {
                    hour = 1;
                }

                int indent = (hour > 9) ? 10 : 5;
                graphics2D.drawString(Integer.toString(hour), (int) (0.75 * radius * Math.cos(currentAngle) + x - indent),
                        (int) (0.75 * radius * Math.sin(currentAngle) + y + 5));
                hour++;
            }
        }
    }

    private void drawHandsClock(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);

        graphics2D.fillOval(x - 3, y - 3, 6, 6);

        double angleRotation = Math.PI / 30 * ((int) (seconds / 20) % 60);

        graphics2D.rotate(angleRotation, x, y);
        graphics2D.fillPolygon(new int[]{x - 3, x + 3, x},
                new int[]{y, y, (int) (y - radius * 0.65)}, 3);
        graphics2D.rotate(-angleRotation, x, y);

        angleRotation = Math.PI / 6 * ((int) (seconds / 1200));
        graphics2D.rotate(angleRotation, x, y);
        graphics2D.fillPolygon(new int[]{x - 3, x + 3, x},
                new int[]{y, y, (int) (y - radius * 0.5)}, 3);
        graphics2D.rotate(-angleRotation, x, y);

        graphics2D.setStroke(new BasicStroke(2));
    }

    private void drawRoof(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(117, 48, 2));
        graphics2D.fillPolygon(new int[]{x, (int) (x - 2.5 * radius), (int) (x + 2.5 * radius)},
                new int[]{y - 3 * radius, (int) (y - 1.5 * radius), (int) (y - 1.5 * radius)}, 3);

        graphics2D.setColor(new Color(0xEFEF78));
        graphics2D.setStroke(new BasicStroke(2));

        GeneralPath leftPartWindow = new GeneralPath();
        leftPartWindow.moveTo(x - 1, y - 2 * radius);
        leftPartWindow.lineTo(x - radius * 0.2, y - 2 * radius);
        leftPartWindow.curveTo(x - radius * 0.2, y - 2 * radius, x - 0.17 * radius, y - 2.25 * radius,
                x - 1, y - 2.3 * radius);
        leftPartWindow.lineTo(x - 1, y - 2 * radius);
        graphics2D.fill(leftPartWindow);

        GeneralPath rightPartWindow = new GeneralPath();
        rightPartWindow.moveTo(x + 1, y - 2 * radius);
        rightPartWindow.lineTo(x + radius * 0.2, y - 2 * radius);
        rightPartWindow.curveTo(x + radius * 0.2, y - 2 * radius, x + 0.17 * radius, y - 2.25 * radius,
                x + 1, y - 2.3 * radius);
        rightPartWindow.lineTo(x + 1, y - 2 * radius);
        graphics2D.fill(rightPartWindow);
    }

    private void drawPendulum(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(117, 48, 2));
        graphics2D.setStroke(new BasicStroke(10));

        graphics2D.fillOval((int) (x - 0.1 * radius), (int) (y + 1.4 * radius),
                (int) (0.2 * radius), (int) (0.2 * radius));

        double angleRotation;

        if (seconds % 20 > 9) {
            angleRotation = Math.PI / 20 * (seconds % 10) + Math.PI / 4;
        } else {
            angleRotation = 3 * Math.PI / 4 - Math.PI / 20 * (seconds % 10);
        }

        graphics2D.rotate(angleRotation, x, y + radius * 1.5);
        graphics2D.drawLine(x, (int) (y + 1.5 * radius), x + radius, (int) (y + 1.5 * radius));
        graphics2D.fillOval((int) (x + 0.75 * radius), (int) (y + 1.25 * radius),
                (int) (0.5 * radius), (int) (0.5 * radius));
        graphics2D.rotate(-angleRotation, x, y + radius * 1.5);
    }
}
