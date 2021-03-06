/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.view;

import realtimesys.model.PeriodicTask;

/**
 *
 * @author namng
 */
public class TaskInfoShortView extends javax.swing.JPanel {

    /**
     * Creates new form TaskInfoShortView
     */
    public TaskInfoShortView() {
        initComponents();
    }

    private PeriodicTask taskInfo;

    /**
     * Get the value of taskInfo
     *
     * @return the value of taskInfo
     */
    public PeriodicTask getTaskInfo() {
        return taskInfo;
    }

    /**
     * Set the value of taskInfo
     *
     * @param taskInfo new value of taskInfo
     */
    public void setTaskInfo(PeriodicTask taskInfo) {
        this.taskInfo = taskInfo;
        if(taskInfo != null){
            taskIdLabel.setText(String.valueOf(taskInfo.getId()));
            taskNameLabel.setText(taskInfo.getName());
            taskInfoLabel.setText(taskInfo.getShortInfo());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        taskIdLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        taskNameLabel = new javax.swing.JLabel();
        taskInfoLabel = new javax.swing.JLabel();

        jLabel1.setText("Task#");

        taskIdLabel.setText("0");

        jLabel3.setText("Name:");

        taskNameLabel.setText("Task name");

        taskInfoLabel.setText("(0,0,0,0)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(taskIdLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(taskNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(taskInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(taskIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(taskNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskInfoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel taskIdLabel;
    private javax.swing.JLabel taskInfoLabel;
    private javax.swing.JLabel taskNameLabel;
    // End of variables declaration//GEN-END:variables
}
