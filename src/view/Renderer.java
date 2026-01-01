package view;

import math.Calculator;
import math.Expression;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer {
    private int width, height;
    private Calculator calculator;

    public Renderer(int width, int height, Calculator calculator) {
        this.width = width;
        this.height = height;
        this.calculator = calculator;
    }

    public BufferedImage render() {
        ArrayList<Expression> expressions = calculator.getExpressions();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //for (SubExpression expression : expressions) {
            int yStart, yEnd = 0;

            for (int i = 0; i < width; i++) {
                yStart = yEnd;
                yEnd = (int) (Math.pow(i + 1, 2) / 100);

                for (int j = yStart; j <= yEnd; j++) {

                    if (j >= 0 && j < bufferedImage.getHeight())
                        bufferedImage.setRGB(i, j, Color.RED.getRGB());

                }
            }
        //}

        return bufferedImage;
    }
}
