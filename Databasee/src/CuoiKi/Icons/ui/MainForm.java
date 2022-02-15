package CuoiKi.Icons.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CuoiKi.Icons.dao.SinhVienDao;
import CuoiKi.Icons.helper.Share;
import CuoiKi.Icons.helper.databaseHelper;
import CuoiKi.Icons.model.SinhVien;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Window;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class MainForm extends JFrame {
	private StudentManagementPanel mStudentPanel;
	private GPAManagementPanel mGPAPanel;
	private JPanel contentPane;
	private final Action action = new SwingAction();
	private databaseHelper dbH;
	private JButton mnuGPAMangement;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public MainForm() {
		setForeground(Color.CYAN);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/CuoiKi/Icons/t\u1EA3i xu\u1ED1ng.png")));
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//				Login dialog= new Login();
//				dialog.setLocationRelativeTo(null);
//				dialog.setVisible(true);
//			}
//		});
		setTitle("Quan Ly Sinh Vien");
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.WHITE);
		toolBar.setBounds(0, 20, 784, 59);
		contentPane.add(toolBar);
		
		JButton tbrLogout = new JButton("Dang Xuat");
		tbrLogout.setBackground(Color.WHITE);
		tbrLogout.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		tbrLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginDialog =new Login();
				dispose();
				loginDialog.setVisible(true);
				
			}
		});
		tbrLogout.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/logout-1321215610608760076_32.png")));
		toolBar.add(tbrLogout);
		
		JButton mnuStudentManagement = new JButton("Quan Ly Sinh Vien");
		mnuStudentManagement.setBackground(Color.WHITE);
		mnuStudentManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		
		mnuStudentManagement.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/learn+school+student+study+icon-1320166054921985662_32.png")));
		toolBar.add(mnuStudentManagement);
		
		mnuGPAMangement = new JButton("Quan Ly Diem");
		mnuGPAMangement.setBackground(Color.WHITE);
		mnuGPAMangement.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		
		
		mnuGPAMangement.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/Bill-1320043514824061876_32.png")));
		toolBar.add(mnuGPAMangement);
		
		JButton tbrAboutUs = new JButton("Gioi Thieu");
		tbrAboutUs.setBackground(Color.WHITE);
		tbrAboutUs.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		
		tbrAboutUs.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/information+text+icon-1320186616843105642_32.png")));
		
		toolBar.add(tbrAboutUs);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		toolBar.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/273243963_476273887546661_4366883328496469493_n (1).png")));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 301, 57);
		panel.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 784, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("He Thong");
		mnNewMenu.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Dang Xuat");
		mntmNewMenuItem.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginDialog =new Login();
				dispose();
				loginDialog.setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/217-2179519_exit-png-font-awesome-logout-icon.png")));
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mnuFile_Exit = new JMenuItem("Thoat");
		mnuFile_Exit.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		mnuFile_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile_Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnuFile_Exit.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/delete+exit+remove+icon-1320186209536162845_16.png")));
		mnNewMenu.add(mnuFile_Exit);
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu.add(separator_3);
		
		JMenu mnNewMenu_1 = new JMenu("Quan Ly");
		mnNewMenu_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		JTabbedPane tplMainBoard = new JTabbedPane(JTabbedPane.TOP);
		tplMainBoard.setBackground(Color.WHITE);
		tplMainBoard.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		tplMainBoard.setBounds(10, 89, 764, 624);
		contentPane.add(tplMainBoard);
		
		JMenuItem mnuManageStudent = new JMenuItem("Quan Ly Sinh Vien");
		mnuManageStudent.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		mnuManageStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mStudentPanel==null) {
				mStudentPanel= new StudentManagementPanel();
				ImageIcon icon = new ImageIcon(getClass().getResource("/CuoiKi/Icons/learn+school+student+study+icon-1320166054921985662_16.png"));
				
				tplMainBoard.addTab("Quan Ly Sinh Vien",icon, mStudentPanel, "Quan Ly Sinh Vien");
				}
				tplMainBoard.setSelectedComponent(mStudentPanel);
				
			}
		});
		mnuStudentManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mStudentPanel==null) {
					mStudentPanel= new StudentManagementPanel();
					ImageIcon icon = new ImageIcon(getClass().getResource("/CuoiKi/Icons/learn+school+student+study+icon-1320166054921985662_16.png"));
					
					tplMainBoard.addTab("Quan Ly Sinh Vien",icon, mStudentPanel, "Quan Ly Sinh Vien");
					}
					tplMainBoard.setSelectedComponent(mStudentPanel);
			}
		});
		mnuGPAMangement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mGPAPanel==null) {
					mGPAPanel= new GPAManagementPanel();
					ImageIcon icon = new ImageIcon(getClass().getResource("/CuoiKi/Icons/Bill-1320043514824061876_16.png"));
					
					tplMainBoard.addTab("Quan Ly Diem",icon, mGPAPanel, "Quan Ly Diem");
					}
					tplMainBoard.setSelectedComponent(mGPAPanel);
			}
		});
		mnuManageStudent.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/kisspng-computer-icons-student-icon-design-research-vector-5b4b09038cd8a6.7156677815316441635769.jpg")));
		mnuManageStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnuManageStudent);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
		JMenuItem mnuManageGPA = new JMenuItem("Quan Ly Diem");
		mnuManageGPA.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		mnuManageGPA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mGPAPanel==null) {
					mGPAPanel= new GPAManagementPanel();
					ImageIcon icon = new ImageIcon(getClass().getResource("/CuoiKi/Icons/Bill-1320043514824061876_16.png"));
					
					tplMainBoard.addTab("Quan Ly Diem",icon, mGPAPanel, "Quan Ly Diem");
					}
					tplMainBoard.setSelectedComponent(mGPAPanel);
			}
		});
		mnuManageGPA.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/png-transparent-computer-icons-scoreboard-score-miscellaneous-text-sport.png")));
		mnNewMenu_1.add(mnuManageGPA);
		
		JMenu mnNewMenu_2 = new JMenu("Tro Giup");
		mnNewMenu_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mnuAboutUs = new JMenuItem("Gioi Thieu");
		mnuAboutUs.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		mnuAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsDialog aboutUsDialog= new AboutUsDialog();
				
				aboutUsDialog.setVisible(true);
				
			}
		});
		tbrAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsDialog aboutUsDialog= new AboutUsDialog();
				
				aboutUsDialog.setVisible(true);
			}
		});
		mnuAboutUs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		mnuAboutUs.setIcon(new ImageIcon(MainForm.class.getResource("/CuoiKi/Icons/416-4160887_png-file-svg-intro-icon-png-transparent-png.png")));
		mnNewMenu_2.add(mnuAboutUs);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 760);
		setLocationRelativeTo(null);
		
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
