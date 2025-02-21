package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpressionListPanel extends JPanel implements ActionListener {
    private JPanel topBar;
    private JButton addButton;
    private JTable expressionList;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public ExpressionListPanel() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        topBar = new JPanel(new BorderLayout());
        addButton = new JButton("+");
        addButton.addActionListener(this);
        topBar.add(addButton, BorderLayout.EAST);

        tableModel = new DefaultTableModel(1, 1);
        expressionList = new JTable(tableModel);
        scrollPane = new JScrollPane(expressionList);

        add(topBar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            tableModel.addRow(new Object[] {""});
        }
    }
}