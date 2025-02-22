package view;

import javax.swing.JFrame;
import java.awt.*;

public class MainView extends JFrame {
    private ExpressionListPanel expressionListPanel;
    private FunctionViewportPanel functionViewportPanel;

    public MainView() {
        setTitle("Graphing Calculator");
        setSize(1440,810);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        expressionListPanel = new ExpressionListPanel();
        add(expressionListPanel, BorderLayout.WEST);


        functionViewportPanel = new FunctionViewportPanel();
        add(functionViewportPanel, BorderLayout.CENTER);
    }
}
