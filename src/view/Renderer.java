package view;

import math.Calculator;
import math.Expression;
import math.Variable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer {
    private int width, height;
    Calculator calculator;

    public Renderer(int width, int height, Calculator calculator) {
        this.width = width;
        this.height = height;
        this.calculator = calculator;
    }

    public BufferedImage render() {
        ArrayList<Expression> expressions = calculator.getExpressions();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (Expression expression : expressions) {
            Variable x = Variable.getVariable('x');

            x.setValue(0);

            int yStart = (int) expression.simplify(), yEnd;

            for (int i = 1; i < width; i++) {
                x.setValue(i);

                yEnd = (int) expression.simplify();

                for (int j = yStart; j <= yEnd; j++) {
                    int invert = bufferedImage.getHeight() - j;

                    if (invert >= 0 && invert < bufferedImage.getHeight()) {
                        bufferedImage.setRGB(i, invert, Color.RED.getRGB());
                    }
                }

                yStart = yEnd;
            }
        }

        return bufferedImage;
    }
}
