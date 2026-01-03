package view;

import math.Element;
import math.Expression;
import math.Function;
import math.Number;
import math.Parser;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpressionListPanel extends JPanel implements ActionListener {
    private JPanel topBar;
    private JButton addButton, removeButton;
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

        removeButton = new JButton("-");
        removeButton.addActionListener(this);
        topBar.add(removeButton, BorderLayout.WEST);

        tableModel = new DefaultTableModel(0, 1);
        Object[] headers = {"Expressions"};
        tableModel.setColumnIdentifiers(headers);
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                if (e.getType() == TableModelEvent.UPDATE) {
                    TableModel model = (TableModel) e.getSource();
                    Object newData = model.getValueAt(row, column);
                    MainView.functionViewportPanel.renderer.calculator.setExpression(row, Parser.getInstance().parse((String) newData));
                }

                MainView.functionViewportPanel.repaint();
            }
        });

        expressionList = new JTable(tableModel);
        scrollPane = new JScrollPane(expressionList);


        add(topBar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            tableModel.addRow(new Object[] {""});
            MainView.functionViewportPanel.renderer.calculator.addExpression(new Expression(new Element[] {new Number(0), new Number(0)}, Function.getFunctionBehaviour("+")));
        }
        else if (e.getSource() == removeButton) {
            int selectedRowIndex = expressionList.getSelectedRow();

            if (selectedRowIndex != -1) {
                tableModel.removeRow(selectedRowIndex);
                MainView.functionViewportPanel.renderer.calculator.removeExpression(selectedRowIndex);
                MainView.functionViewportPanel.repaint();
            }
        }
    }
}