package ru.vsu.cs.kg2022.novichikhin.task_1;

import java.awt.*;

public class Wallpaper {
    private final int weight, height, quantityStars;

    public Wallpaper(int weight, int height, int quantityPatterns) {
        this.weight = weight;
        this.height = height;
        this.quantityStars = quantityPatterns;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setPaint(new Color(0x5BF58C));
        graphics2D.fillRect(0, 0, weight, height);

        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(5));

        int shift = weight / quantityStars;
        int currentX = -shift / 2;

        for (int j = 0; j < quantityStars; j++) {
            currentX += shift;

            int[] firstXArray = new int[height];
            int[] secondXArray = new int[height];
            int[] yArray = new int[height];
            int number = 1;

            for (int i = 0; i < height; i++) {
                yArray[i] = i;

                int indentX = (int) (15 * Math.sin(i * 0.05));
                firstXArray[i] = currentX - indentX;
                secondXArray[i] = currentX + indentX;

                if (yArray[i] == (int) (Math.PI * 10 * number)) {
                    int indentRelativeToFirstX = (firstXArray[i] > currentX) ? -20 : 10;
                    graphics2D.fillOval(firstXArray[i] + indentRelativeToFirstX, yArray[i] - 3, 10, 10);
                    number += 2;
                }
            }

            graphics2D.drawPolyline(firstXArray, yArray, height);
            graphics2D.drawPolyline(secondXArray, yArray, height);
        }
    }
}
