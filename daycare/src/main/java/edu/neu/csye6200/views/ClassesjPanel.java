/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.views;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.service.factory.ClassroomFactory;

@Component
public class ClassesjPanel extends javax.swing.JPanel {

	/**
	 * Creates new form StudentsjPanel
	 */
	public ClassesjPanel() {
		initComponents();
		populateClassesInfo();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel3 = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		tableClassroom = new javax.swing.JTable();

		setBackground(new java.awt.Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(900, 720));

		jLabel3.setBackground(new java.awt.Color(153, 255, 153));
		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		tableClassroom.setBackground(new java.awt.Color(153, 204, 255));
		tableClassroom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		tableClassroom.setForeground(new java.awt.Color(0, 51, 204));
		tableClassroom.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Class Id", "Age Group", "Teacher Ids", "Student Ids" }));
		jScrollPane4.setViewportView(tableClassroom);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(117, Short.MAX_VALUE).addComponent(jScrollPane4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(91, 91, 91)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(46, 46, 46)
						.addComponent(jLabel3).addGap(77, 77, 77).addComponent(jScrollPane4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	public void populateClassesInfo() {
		List<Classroom> classrooms = ClassroomFactory.getAllClassRooms();
		DefaultTableModel model = (DefaultTableModel) tableClassroom.getModel();
		model.setRowCount(0);
		// if (model.getRowCount() == 0) {
		classrooms.forEach(t -> {
			model.addRow(new Object[] { t.getClassId(), t.getMin_age() + "-" + t.getMax_age(),
					Arrays.toString(t.getTeacherIdList().toArray()), Arrays.toString(t.getStudentIdList().toArray()) });
		});
		// }
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTable tableClassroom;
	// End of variables declaration//GEN-END:variables
}
