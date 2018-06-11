package main;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.awt.Color;
public class TableExample extends JFrame
{
    public TableExample(String[] columns , String[][] data)
    {
        //create table with data
        JTable table = new JTable(data, columns);
         
        //add the table to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(Color.WHITE);
        getContentPane().add(scrollPane);
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableExample(null, null);
            }
        });
    }   
}