package view;

import math.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class FunctionViewportPanel extends JPanel {
    //placeholder - will be replaced when renderer and parser is done.
    BufferedImage image;

    public FunctionViewportPanel() {
        Renderer renderer = new Renderer(800, 800, new Calculator());

        image = renderer.render();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}