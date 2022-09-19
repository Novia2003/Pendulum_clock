package ru.vsu.cs.kg2022.novichikhin.task_1;

import java.awt.*;

public class ShelfWithBooks {
    private final int x, y, shelfLength;
    private final String[] bookTitles;
    private final Color[] bookColors;

    public ShelfWithBooks(int x, int y, int shelfLength, String[] bookTitles, Color[] bookColors) {
        this.x = x;
        this.y = y;
        this.shelfLength = shelfLength;
        this.bookTitles = bookTitles;
        this.bookColors = bookColors;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(0xEF9B66));
        graphics2D.fillRoundRect(x, y, shelfLength, (int) (shelfLength * 0.1), 5, 5);

        Color titleColor = new Color(0xDADA7F);
        graphics2D.setFont(new Font("Times", Font.PLAIN, 15));
        int indentX = x - 20;
        int quantityBooks = bookTitles.length;

        for (int i = 0; i < quantityBooks - 1; i++) {
            int bookHeight = bookTitles[i].length() * 11;
            indentX += 20;
            int indentY = y - bookHeight;


            graphics2D.setColor(bookColors[i]);
            graphics2D.fillRoundRect(indentX, indentY, 18, bookHeight, 2, 2);
            graphics2D.rotate(Math.PI / 2, indentX, indentY);
            graphics2D.setColor(titleColor);
            graphics2D.drawString(bookTitles[i], indentX, indentY - 3);
            graphics2D.rotate(-Math.PI / 2, indentX, indentY);
        }

        int bookHeight = bookTitles[quantityBooks - 1].length() * 30;
        indentX += 18;
        int indentY = (int) (y - bookHeight * Math.cos(Math.PI / 12));

        graphics2D.rotate(Math.PI / 12 * 5, indentX, indentY);
        graphics2D.setColor(bookColors[quantityBooks - 1]);
        graphics2D.fillRoundRect(indentX, indentY - 18, bookHeight, 18, 2, 2);
        graphics2D.setColor(titleColor);
        graphics2D.drawString(bookTitles[quantityBooks - 1], indentX + 35, indentY);
        graphics2D.rotate(-Math.PI / 12 * 5, indentX, indentY);
    }
}
