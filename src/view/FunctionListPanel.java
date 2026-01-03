package view;

import math.Function;
import math.FunctionBehaviour;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class FunctionListPanel extends JPanel {
    private JTable functionList;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public FunctionListPanel() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        tableModel = new DefaultTableModel(0, 3) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] newHeaders = {"Symbol/Name", "Priority", "Number of Arguments"};
        tableModel.setColumnIdentifiers(newHeaders);
        populateTable();
        functionList = new JTable(tableModel);
        scrollPane = new JScrollPane(functionList);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void populateTable() {
        for (Map.Entry<String, FunctionBehaviour> entry : Function.getFunctionMap().entrySet()) {
            int min = entry.getValue().getMinNumArguments(), max = entry.getValue().getMaxNumArguments();
            String numArguments;

            if (min == max) {
                numArguments = String.valueOf(min);
            }
            else if (max < 0) {
                numArguments = min + "+";
            }
            else {
                numArguments = min + " - " + max;
            }

            tableModel.addRow(new Object[] {entry.getKey(), entry.getValue().getPriority(), numArguments});
        }
    }


}
