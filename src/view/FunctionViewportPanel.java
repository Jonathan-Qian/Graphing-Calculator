package view;

import math.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FunctionViewportPanel extends JPanel {
    Renderer renderer;

    public FunctionViewportPanel() {
         renderer = new Renderer(800, 800, new Calculator());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(renderer.render(), 0, 0, this);
    }
}