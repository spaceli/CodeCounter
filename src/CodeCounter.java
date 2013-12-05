import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  __USER__
 */
public class CodeCounter extends javax.swing.JFrame {
	DefaultListModel listModel = new DefaultListModel();
	CounterAction counter = new CounterAction();
	public static DefaultTableModel singleTableModel = new DefaultTableModel();
	public static DefaultTableModel totalTableModel = new DefaultTableModel();
	File[] files = null;

	/** Creates new form CodeCounter */
	public CodeCounter() {
		initComponents();
		setLocation(200, 200);
		filesJList.setModel(listModel);

		singleTable.setModel(singleTableModel);
		singleTableModel.addColumn("文件名");
		singleTableModel.addColumn("文件大小");
		singleTableModel.addColumn("代码行");
		singleTableModel.addColumn("注释行");
		singleTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		singleTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		singleTable.getColumnModel().getColumn(2).setPreferredWidth(20);
		singleTable.getColumnModel().getColumn(3).setPreferredWidth(20);

		totalTable.setModel(totalTableModel);
		totalTableModel.addColumn("类型");
		totalTableModel.addColumn("文件数");
		totalTableModel.addColumn("总大小");
		totalTableModel.addColumn("代码行");
		totalTableModel.addColumn("注释行");
		totalTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		totalTable.getColumnModel().getColumn(1).setPreferredWidth(30);
		totalTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		totalTable.getColumnModel().getColumn(3).setPreferredWidth(30);
		totalTable.getColumnModel().getColumn(4).setPreferredWidth(30);
		
		cCheckBox.setSelected(true);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		filesJList = new javax.swing.JList();
		cCheckBox = new javax.swing.JCheckBox();
		javaCheckBox = new javax.swing.JCheckBox();
		ocCheckBox = new javax.swing.JCheckBox();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		singleTable = new javax.swing.JTable();
		jScrollPane3 = new javax.swing.JScrollPane();
		totalTable = new javax.swing.JTable();
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		helpMenu = new javax.swing.JMenu();
		aboutMenuItem = new javax.swing.JMenuItem();
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		helpMenu = new javax.swing.JMenu();
		aboutMenuItem = new javax.swing.JMenuItem();
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		helpMenu = new javax.swing.JMenu();
		aboutMenuItem = new javax.swing.JMenuItem();

		setTitle("\u4ee3\u7801\u7edf\u8ba1\u5668");
		setDefaultCloseOperation(3);
		setResizable(false);

		jScrollPane1.setViewportView(filesJList);

		cCheckBox.setText("C/C++");

		javaCheckBox.setText("java");

		ocCheckBox.setText("Objective-C");

		jButton1.setFocusable(false);
		jButton1.setHorizontalTextPosition(0);
		jButton1.setText("\u9009\u62e9\u76ee\u5f55");
		jButton1.setVerticalTextPosition(3);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFocusable(false);
		jButton2.setHorizontalTextPosition(0);
		jButton2.setText("\u7b5b\u9009\u6587\u4ef6");
		jButton2.setVerticalTextPosition(3);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		singleTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { {}, {}, {}, {} }, new String[] {

				}));
		jScrollPane2.setViewportView(singleTable);

		totalTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { {}, {}, {}, {} }, new String[] {

				}));
		jScrollPane3.setViewportView(totalTable);

		
		fileMenu.setText("\u6587\u4ef6");

		openMenuItem.setText("\u9009\u62e9\u76ee\u5f55");
		openMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(openMenuItem);

		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		helpMenu.setText("\u5e2e\u52a9");

		aboutMenuItem.setText("About");
		aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aboutMenuItemActionPerformed(evt);
			}
		});
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		setJMenuBar(menuBar);

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				layout.createSequentialGroup().addContainerGap().add(cCheckBox)
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED).add(
								javaCheckBox).addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED).add(
								ocCheckBox).addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED, 218,
								Short.MAX_VALUE).add(jButton1).add(18, 18, 18)
						.add(jButton2).add(96, 96, 96)).add(
				org.jdesktop.layout.GroupLayout.TRAILING,
				layout.createSequentialGroup().add(jScrollPane2,
						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 354,
						Short.MAX_VALUE).addPreferredGap(
						org.jdesktop.layout.LayoutStyle.RELATED).add(
						jScrollPane3,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 281,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)).add(
				org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1,
				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 641,
				Short.MAX_VALUE));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(cCheckBox).add(
																javaCheckBox)
														.add(ocCheckBox).add(
																jButton2).add(
																jButton1))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												243,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(
																jScrollPane3,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																185,
																Short.MAX_VALUE)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																jScrollPane2,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																185,
																Short.MAX_VALUE))));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * 筛选文件
	 */
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (files.length == 0)
			return;

		List<File> fileList = new ArrayList<File>();

		listModel.clear();
		for (int i = singleTableModel.getRowCount(); i > 0; i--) {
			singleTableModel.removeRow(0);
		}
		for (int i = totalTableModel.getRowCount(); i > 0; i--) {
			totalTableModel.removeRow(0);
		}

		if (cCheckBox.isSelected())
			fileList.addAll(counter.getFiles(files, ".*\\.[hc][pP]{0,2}"));
		if (javaCheckBox.isSelected())
			fileList.addAll(counter.getFiles(files, ".*\\.java"));
		if (ocCheckBox.isSelected())
			fileList.addAll(counter.getFiles(files, ".*\\.[mh]"));

		for (Iterator<File> it = fileList.iterator(); it.hasNext();) {
			listModel.addElement(it.next().getAbsolutePath());
		}

		counter.count(fileList, singleTableModel, totalTableModel);
	}

	/**
	 * 选择文件夹
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		openMenuItemActionPerformed(null);
	}

	/**
	 * 关于
	 */
	private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showConfirmDialog(null, "本软件用于统计你的代码工作量\n作者：spacelis", "关于", JOptionPane.OK_OPTION);
	}

	/**
	 * 选择文件夹
	 */
	private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("请选择代码路径");
		fc.setCurrentDirectory(new File("/"));
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setMultiSelectionEnabled(true);
		fc.setLocation(300, 200);
		fc.showOpenDialog(this);
		files = fc.getSelectedFiles();
		if (files.length == 0)
			return;

		List<File> fileList = new ArrayList<File>();

		listModel.clear();
		for (int i = singleTableModel.getRowCount(); i > 0; i--) {
			singleTableModel.removeRow(0);
		}
		for (int i = totalTableModel.getRowCount(); i > 0; i--) {
			totalTableModel.removeRow(0);
		}

		if (cCheckBox.isSelected())
			fileList.addAll(counter.getFiles(files, ".*\\.[hc][pP]{0,2}"));
		if (javaCheckBox.isSelected())
			fileList.addAll(counter.getFiles(files, ".*\\.java"));
		if (ocCheckBox.isSelected())
			fileList.addAll(counter.getFiles(files, ".*\\.[mh]"));

		for (Iterator<File> it = fileList.iterator(); it.hasNext();) {
			listModel.addElement(it.next().getAbsolutePath());
		}

		counter.count(fileList, singleTableModel, totalTableModel);

	}

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
		System.exit(0);
	}//GEN-LAST:event_exitMenuItemActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CodeCounter().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JCheckBox cCheckBox;
	private javax.swing.JCheckBox ocCheckBox;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JList filesJList;
	private javax.swing.JMenu helpMenu;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JCheckBox javaCheckBox;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem openMenuItem;
	private javax.swing.JTable singleTable;
	private javax.swing.JTable totalTable;
	// End of variables declaration//GEN-END:variables

}