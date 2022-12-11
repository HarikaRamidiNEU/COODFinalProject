/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.views;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.csye6200.controller.TeacherController;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.service.factory.ClassroomFactory;

@Component
public class TeachersjPanel extends javax.swing.JPanel {

	/**
	 * Creates new form StudentsjPanel
	 */

	@Autowired
	TeacherController teacherController;

	public TeachersjPanel() {
		initComponents();
	}

	@PostConstruct
	public void init() {
		try {
			populateBodyTeacher();
		} catch (Exception c) {
			c.printStackTrace();
			System.out.println("Something Went Wrong!");
		}
	}

	private void populateBodyTeacher() {
		List<Teacher> teachers = teacherController.getAllTeachers();

		if (teachers.size() > 0) {
			teacherController.addTestData();

			// Add teachers to classroom
			List<Teacher> newTeachers = teacherController.getAllTeachers();
			List<Classroom> allClassRooms = ClassroomFactory.getAllClassRooms();
			int counter = 0;
			try {
				for (Classroom classroom : allClassRooms) {
					int tempCounter = 0;
					while (tempCounter < classroom.getMaxGroups()) {
						classroom.addTeacherId(newTeachers.get(counter + tempCounter).getId());
						tempCounter++;
					}
					counter += tempCounter;
				}
				DefaultTableModel model = (DefaultTableModel) tableTeachers.getModel();

				if (model.getRowCount() == 0) {
					teachers.forEach(t -> {
						model.addRow(new Object[] { t.getId(), t.getName(), t.getAge(), t.getCredits() });
					});
				}
			} catch (Exception ex) {
				System.out.println("****** Not Enough Teachers. Please Add at least 16 teachers ****");
				System.exit(1);
			}

		}

	}

	private int generateID() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MMddhmmss");
		String datetime = ft.format(dNow);
		return Integer.parseInt(datetime);
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
		jPanel4 = new javax.swing.JPanel();
		jLabel11 = new javax.swing.JLabel();
		tfName1 = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		btnAdd1 = new javax.swing.JButton();
		btnClear1 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		tableTeachers = new javax.swing.JTable();
		tfAge1 = new javax.swing.JTextField();
		tfCredits = new javax.swing.JTextField();
		btnDelete1 = new javax.swing.JButton();

		setBackground(new java.awt.Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(900, 720));

		jLabel3.setBackground(new java.awt.Color(153, 255, 153));
		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(51, 51, 51));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Teacher Registration");

		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Teacher",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 14))); // NOI18N
		jPanel4.setForeground(java.awt.Color.gray);
		jPanel4.setOpaque(false);

		jLabel11.setBackground(new java.awt.Color(0, 153, 255));
		jLabel11.setForeground(new java.awt.Color(0, 51, 204));
		jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel11.setText("Name");

		tfName1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		tfName1.setToolTipText("");
		tfName1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tfName1ActionPerformed(evt);
			}
		});

		jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel12.setBackground(new java.awt.Color(0, 153, 255));
		jLabel12.setForeground(new java.awt.Color(0, 51, 204));
		jLabel12.setText("Age");

		jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel13.setBackground(new java.awt.Color(0, 153, 255));
		jLabel13.setForeground(new java.awt.Color(0, 51, 204));
		jLabel13.setText("Ratings");

		btnAdd1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btnAdd1.setForeground(new java.awt.Color(0, 51, 204));
		btnAdd1.setText("Add");
		btnAdd1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAdd1ActionPerformed(evt);
			}
		});

		btnClear1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btnClear1.setForeground(new java.awt.Color(0, 51, 204));
		btnClear1.setText("Clear");
		btnClear1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClear1ActionPerformed(evt);
			}
		});

		tableTeachers.setBackground(new java.awt.Color(153, 204, 255));
		tableTeachers.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		tableTeachers.setForeground(new java.awt.Color(0, 51, 204));
		tableTeachers.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Id", "Name", "Age", "Ratings" }));
		jScrollPane2.setViewportView(tableTeachers);
		if (tableTeachers.getColumnModel().getColumnCount() > 0) {
			tableTeachers.getColumnModel().getColumn(0).setResizable(false);
			tableTeachers.getColumnModel().getColumn(1).setResizable(false);
			tableTeachers.getColumnModel().getColumn(2).setResizable(false);
		}

		tfAge1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		tfAge1.setToolTipText("");
		tfAge1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tfAge1ActionPerformed(evt);
			}
		});

		tfCredits.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		tfCredits.setToolTipText("");
		tfCredits.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tfCreditsActionPerformed(evt);
			}
		});

		btnDelete1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		btnDelete1.setText("Delete");
		btnDelete1.setForeground(new java.awt.Color(0, 51, 204));
		btnDelete1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDelete1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 171,
										Short.MAX_VALUE)
								.addGap(612, 612, 612))
						.addGroup(jPanel4Layout.createSequentialGroup().addGap(47, 47, 47)
								.addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(73, 73, 73)
								.addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(42, 42, 42)
								.addComponent(
										btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 118,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
												.addGroup(jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(jPanel4Layout.createSequentialGroup()
																.addComponent(jLabel13,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 115,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0, 0, Short.MAX_VALUE)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(tfAge1, javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(tfName1).addComponent(tfCredits))))
								.addGap(269, 269, 269)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(26, 26, 26)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel11).addComponent(tfName1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(30, 30, 30)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel12).addComponent(tfAge1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(32, 32, 32)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel13).addComponent(tfCredits, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(btnAdd1, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
								.addComponent(btnClear1, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnDelete1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(28, 28, 28).addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(167, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(340, 340, 340))
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel3,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(277, 277, 277)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>//GEN-END:initComponents

	private void tfName1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfName1ActionPerformed
	}// GEN-LAST:event_tfName1ActionPerformed

	private void tfAge1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfAge1ActionPerformed
	}// GEN-LAST:event_tfAge1ActionPerformed

	private void tfCreditsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfCreditsActionPerformed
	}// GEN-LAST:event_tfCreditsActionPerformed

	private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAdd1ActionPerformed
		String id = String.valueOf(generateID());
		String age = tfAge1.getText();
		String name = tfName1.getText();
		String credit = tfCredits.getText();

		if (id.isEmpty() || age.isEmpty() || name.isEmpty() || credit.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please Enter All Fields", "Try Again", JOptionPane.ERROR_MESSAGE);
		} else {
			DefaultTableModel model = (DefaultTableModel) tableTeachers.getModel();
			model.addRow(new Object[] { id, name, age, credit });
		}

//		tfId1.setText("");
		tfAge1.setText("");
		tfName1.setText("");
		tfCredits.setText("");
		String csv = id + "," + name + "," + age + "," + credit;
		System.err.println(csv + "is added to teache db");
		teacherController.addTeacher(csv);
		ClassroomFactory.getAllClassRooms().get(ClassroomFactory.getAllClassRooms().size() - 1)
				.addTeacherId(Integer.parseInt(id));
	}// GEN-LAST:event_btnAdd1ActionPerformed

	private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClear1ActionPerformed
//		tfId1.setText("");
		tfAge1.setText("");
		tfName1.setText("");
		tfCredits.setText("");
	}// GEN-LAST:event_btnClear1ActionPerformed

	private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDelete1ActionPerformed
		int row = tableTeachers.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "No Row is Selected", "Please Select Row", JOptionPane.ERROR_MESSAGE);
		} else {
			DefaultTableModel model = (DefaultTableModel) tableTeachers.getModel();
			int pkid = Integer.parseInt(model.getValueAt(row, 0).toString());
			model.removeRow(row);

			System.err.println(pkid + " is deleted : " + row);
			teacherController.removeTeacherById(pkid);
		}
	}// GEN-LAST:event_btnDelete1ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAdd1;
	private javax.swing.JButton btnClear1;
	private javax.swing.JButton btnDelete1;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tableTeachers;
	private javax.swing.JTextField tfAge1;
	private javax.swing.JTextField tfCredits;
	private javax.swing.JTextField tfName1;
	// End of variables declaration//GEN-END:variables
}