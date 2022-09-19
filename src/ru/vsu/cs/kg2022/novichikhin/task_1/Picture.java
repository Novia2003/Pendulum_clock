package ru.vsu.cs.kg2022.novichikhin.task_1;

import java.awt.*;

public class Picture {
    int x, y, wight, height;

    public Picture(int x, int y, int wight, int height) {
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.height = height;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(0xF69433));
        graphics2D.fillRect(x, y, wight, height);

        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(1));

        graphics2D.drawLine(x, y, x + 5, y + 5);
        graphics2D.drawLine(x + wight, y, x + wight - 5, y + 5);
        graphics2D.drawLine(x, y + height, x + 5, y + height - 5);
        graphics2D.drawLine(x + wight, y + height, x + wight - 5, y + height - 5);

        int currentX = x;
        int currentY = y;
        int currentWeight = wight;
        int currentHeight = height;
        boolean isFirstColor = true;

        while (currentWeight > 0 && currentHeight > 0) {
            if (isFirstColor) {
                graphics2D.setColor(Color.WHITE);
                isFirstColor = false;
            } else {
                graphics2D.setColor(Color.BLACK);
                isFirstColor = true;
            }

            currentX += 5;
            currentY += 5;
            currentWeight -= 10;
            currentHeight -= 10;

            graphics2D.fillRect(currentX, currentY, currentWeight, currentHeight);
        }
    }
}
