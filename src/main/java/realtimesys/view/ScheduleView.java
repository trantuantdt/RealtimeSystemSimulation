/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author namng
 */
public class ScheduleView extends javax.swing.JPanel {

    @Override
    protected void paintComponent(Graphics g)
    {
        ruler.setSize(this.getWidth(), this.getHeight());
    }

    ArrayList<BarChart> schedules = new ArrayList<>();
    RulerView ruler = new RulerView();
    /**
     * Creates new form ScheduleView
     */
    public ScheduleView() {
        
        ruler.setMax(20);
        ruler.setMin(1);
        ruler.setInterval(5);
        this.add(ruler);
        initComponents();
    }
    
    public static void main(String[] args){
        ScheduleView view = new ScheduleView();
        
        JFrame frame = new JFrame("Bar Chart");	
        BarChart b = new BarChart();
        BlockInfo b1 = new BlockInfo(0, 2, Color.BLUE, Color.BLACK);
        BlockInfo b2 = new BlockInfo(4, 2, Color.RED, Color.BLACK);
        BlockInfo b3 = new BlockInfo(7, 3, Color.YELLOW, Color.BLACK);
        
        b1.setLabel("task1");
        b2.setLabel("task2");
        b3.setLabel("task3");
        
        b.setSize(500, 20);
        b.frameSize = 20;
        frame.setLayout(new BorderLayout());
        //frame.getContentPane().add(b, BorderLayout.CENTER);
        frame.getContentPane().add(view, BorderLayout.CENTER);
        b.addBlock(b1);
        b.addBlock(b2);
        b.addBlock(b3);
        b.repaint();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
