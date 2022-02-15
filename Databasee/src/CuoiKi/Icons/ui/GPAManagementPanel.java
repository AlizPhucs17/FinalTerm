package CuoiKi.Icons.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import CuoiKi.Icons.dao.BangDiemDao;
import CuoiKi.Icons.dao.SinhVienDao;
import CuoiKi.Icons.helper.DataValidators;
import CuoiKi.Icons.helper.ImageHelper;
import CuoiKi.Icons.helper.MessageDialogHelper;
import CuoiKi.Icons.model.BangDiem;
import CuoiKi.Icons.model.SinhVien;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class GPAManagementPanel extends JPanel {
	private JTextField txtStudentIdSearch;
	private JTextField txtStudentId;
	private JTextField txtName;
	private JTextField txtJava;
	private JTextField txtTin;
	private JTextField txtCSDL;
	private JTable tblGPA;
	private DefaultTableModel tblModel;

	/**
	 * Create the panel.
	 */
	public GPAManagementPanel() {
		setBackground(Color.WHITE);
		
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 31, 782, 2);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 48, 577, 58);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ma SV:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 31, 45, 13);
		panel.add(lblNewLabel_1);
		
		txtStudentIdSearch = new JTextField();
		txtStudentIdSearch.setBackground(UIManager.getColor("Button.background"));
		txtStudentIdSearch.setBounds(74, 28, 254, 19);
		panel.add(txtStudentIdSearch);
		txtStudentIdSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Tim Kiem");
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		
		btnSearch.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/CuoiKi/Icons/png-transparent-computer-icons-find-out-magnifier-circle-project-thumbnail.png")));
		btnSearch.setBounds(338, 27, 114, 21);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 116, 742, 195);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(338, 10, 284, 175);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ma SV:");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_2.setBounds(10, 10, 45, 13);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ho Ten:");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_3.setBounds(10, 33, 45, 13);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Java:");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_4.setBounds(10, 56, 45, 13);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tin DC:");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_5.setBounds(10, 79, 45, 13);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CSDL:");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_6.setBounds(10, 102, 45, 13);
		panel_2.add(lblNewLabel_6);
		
		txtStudentId = new JTextField();
		txtStudentId.setBackground(UIManager.getColor("Button.background"));
		txtStudentId.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		
		txtStudentId.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				try {
					SinhVienDao dao = new SinhVienDao();
					SinhVien sv=dao.findById(txtStudentId.getText());
					if(sv!=null) {
						txtName.setText(sv.getHoTen());
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
				}
				
				
				
				
			}
		});
		txtStudentId.setBounds(65, 7, 195, 19);
		panel_2.add(txtStudentId);
		txtStudentId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBackground(UIManager.getColor("Button.background"));
		txtName.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		txtName.setBounds(65, 30, 195, 19);
		panel_2.add(txtName);
		txtName.setColumns(10);
		
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(620, 10, 112, 175);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Diem TB:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 27, 95, 13);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblGPA = new JLabel("0.0");
		lblGPA.setForeground(Color.RED);
		lblGPA.setHorizontalAlignment(SwingConstants.CENTER);
		lblGPA.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblGPA.setBounds(10, 50, 95, 41);
		panel_3.add(lblGPA);
		txtJava = new JTextField();
		txtJava.setBackground(UIManager.getColor("Button.background"));
		txtJava.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		txtJava.setText("0.0");
		txtJava.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				float java=0; 
				java = Float.parseFloat(txtJava.getText());
				float tindc = 0;
				tindc = Float.parseFloat(txtTin.getText());
				float csdl =0;
				csdl=Float.parseFloat(txtCSDL.getText());
				float avg = (java + tindc + csdl)/3;
				String st = String.format("%.2f", avg);
				lblGPA.setText(st);
			}
		});
		txtJava.setBounds(65, 53, 195, 19);
		panel_2.add(txtJava);
		txtJava.setColumns(10);
		
		txtTin = new JTextField();
		txtTin.setBackground(UIManager.getColor("Button.background"));
		txtTin.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		txtTin.setText("0.0");
		txtTin.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				float java=0; 
				java = Float.parseFloat(txtJava.getText());
				float tindc = 0;
				tindc = Float.parseFloat(txtTin.getText());
				float csdl =0;
				csdl=Float.parseFloat(txtCSDL.getText());
				
				float avg = (java + tindc + csdl)/3;
				String st = String.format("%.2f", avg);
				lblGPA.setText(st);
			}
		});
		txtTin.setBounds(65, 76, 195, 19);
		panel_2.add(txtTin);
		txtTin.setColumns(10);
		
		txtCSDL = new JTextField();
		txtCSDL.setBackground(UIManager.getColor("Button.background"));
		txtCSDL.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		txtCSDL.setText("0.0");
		txtCSDL.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				float java=0; 
				java = Float.parseFloat(txtJava.getText());
				float tindc = 0;
				tindc = Float.parseFloat(txtTin.getText());
				float csdl =0;
				csdl=Float.parseFloat(txtCSDL.getText());
		
				float avg = (java + tindc + csdl)/3;
				String st = String.format("%.2f", avg);
				lblGPA.setText(st);
			}
		});
		txtCSDL.setBounds(65, 99, 195, 19);
		panel_2.add(txtCSDL);
		txtCSDL.setColumns(10);		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 10, 318, 175);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNew = new JButton("Nhap Moi");
		btnNew.setBackground(Color.WHITE);
		btnNew.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnNew.setBounds(135, 71, 115, 37);
		panel_4.add(btnNew);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStudentId.setText("");
				txtName.setText("");
				txtJava.setText("");
				txtTin.setText("");
				txtCSDL.setText("");
				lblGPA.setText("");
				loadBangDiem();
			}
		});
		btnNew.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/CuoiKi/Icons/new+releases+24px-131985190616836545_16.png")));
		
		JButton btnUpdate = new JButton("Cap Nhat");
		btnUpdate.setBackground(Color.ORANGE);
		btnUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnUpdate.setBounds(10, 47, 115, 37);
		panel_4.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb=new StringBuilder();
				DataValidators.validateEmpty(txtStudentId, sb, "Ma Sinh Vien Can Phai Nhap");
				DataValidators.validateEmpty(txtJava, sb, "Diem Java Can Phai Nhap");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(sb.toString(), "Loi");
					return;
					
				}
				try {
					BangDiem bd= new BangDiem();
					bd.setMaSV(txtStudentId.getText());
					bd.setJava(Float.parseFloat(txtJava.getText()));
					bd.setTinDC(Float.parseFloat(txtTin.getText()));
					bd.setCSDL(Float.parseFloat(txtCSDL.getText()));
					
					BangDiemDao dao = new BangDiemDao();
					if(dao.findByMaSV(txtStudentId.getText()) != null) {
						if(MessageDialogHelper.showComfirmDialog("Ban Co Muon Cap Nhat Diem Khong","Hoi")==JOptionPane.NO_OPTION) {
							return;
						}
						if(dao.update(bd)) {
							MessageDialogHelper.showMessageDialog("Bang Diem Da Duoc Cap Nhat", "Thong Bao");
						}else {
							MessageDialogHelper.showMessageDialog("Khong The Cap Nhat Bang Diem", "Thong Bao");
						}
						}else {
					if(dao.insert(bd)) {
						MessageDialogHelper.showMessageDialog("Bang Diem Da Duoc Luu", "Thong Bao");
					}else {
						MessageDialogHelper.showMessageDialog("Khong The Luu Bang Diem", "Thong Bao");
					}
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					MessageDialogHelper.showErrorDialog(e2.getMessage(), "Loi");
				}
			
			}
		});
		btnUpdate.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/CuoiKi/Icons/update+48px-131985194340414160_16.png")));
		
		JButton btnSave = new JButton("Luu");
		btnSave.setBackground(Color.RED);
		btnSave.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnSave.setBounds(10, 0, 115, 37);
		panel_4.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb=new StringBuilder();
				DataValidators.validateEmpty(txtStudentId, sb, "Ma Sinh Vien Can Phai Nhap");
				DataValidators.validateEmpty(txtJava, sb, "Diem Java Can Phai Nhap");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(sb.toString(), "Loi");
					return;
					
				}
				try {
					BangDiem bd= new BangDiem();
					bd.setMaSV(txtStudentId.getText());
					bd.setJava(Float.parseFloat(txtJava.getText()));
					bd.setTinDC(Float.parseFloat(txtTin.getText()));
					bd.setCSDL(Float.parseFloat(txtCSDL.getText()));
					
					BangDiemDao dao = new BangDiemDao();
					if(dao.findByMaSV(txtStudentId.getText()) != null) {
						if(MessageDialogHelper.showComfirmDialog("Ban Co Muon Cap Nhat Diem Khong","Hoi")==JOptionPane.NO_OPTION) {
							return;
						}
						if(dao.update(bd)) {
							MessageDialogHelper.showMessageDialog("Bang Diem Da Duoc Cap Nhat", "Thong Bao");
						}else {
							MessageDialogHelper.showMessageDialog("Khong The Cap Nhat Bang Diem", "Thong Bao");
						}
						}else {
					if(dao.insert(bd)) {
						MessageDialogHelper.showMessageDialog("Bang Diem Da Duoc Luu", "Thong Bao");
					}else {
						MessageDialogHelper.showMessageDialog("Khong The Luu Bang Diem", "Thong Bao");
					}
					}
					
					loadBangDiem();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					MessageDialogHelper.showErrorDialog(e2.getMessage(), "Loi");
				}
			}
		});
		btnSave.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/CuoiKi/Icons/save-1321215625037841495_16.png")));
		
		JButton btnDelete = new JButton("Xoa");
		btnDelete.setBackground(Color.BLUE);
		btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnDelete.setBounds(10, 94, 115, 37);
		panel_4.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtStudentId.getText().equals("")) {
						MessageDialogHelper.showMessageDialog("Ma Sinh Vien Can Phai Nhap", "Loi");
						return;
					}
					BangDiemDao dao= new BangDiemDao();
					BangDiem bd =dao.findByMaSV(txtStudentId.getText());
					if(bd==null) {
						MessageDialogHelper.showMessageDialog("Ma Sinh Vien Khong Ton Tai Trong Bang Diem", "Loi");
						return;
					}
					if(MessageDialogHelper.showComfirmDialog("Ban co muon xoa diem cua sinh vien khong","Hoi")==JOptionPane.NO_OPTION) {
						return;
					}
					if(dao.deleteByMaSV(txtStudentId.getText())) {
						MessageDialogHelper.showMessageDialog("Diem Sinh Vien Da Duoc Xoa", "Thong Bao");
					}else {
						MessageDialogHelper.showMessageDialog("Diem Sinh Vien Khong The Xoa", "Thong Bao");
					}
						loadBangDiem();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					MessageDialogHelper.showErrorDialog(e2.getMessage(), "Loi");
				}
			}
		});
		btnDelete.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/CuoiKi/Icons/delete+remove+stop+icon-1320085969624362047_16.png")));
		
		JButton btnRfre = new JButton("Refresh");
		btnRfre.setBackground(Color.WHITE);
		btnRfre.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnRfre.setBounds(135, 21, 115, 37);
		panel_4.add(btnRfre);
		btnRfre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBangDiem();
			}
		});
		btnRfre.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/CuoiKi/Icons/reload-131979013351159611 (2).png")));
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BangDiemDao dao= new BangDiemDao();
					BangDiem bd= dao.findByMaSV(txtStudentIdSearch.getText());
					if(bd !=null) {
						txtStudentId.setText(bd.getMaSV());
						txtJava.setText(String.format(Locale.US,"%.2f", bd.getJava()));
						txtTin.setText(String.format(Locale.US,"%.2f", bd.getTinDC()));
						txtCSDL.setText(String.format(Locale.US,"%.2f", bd.getCSDL()));
						
						try {
							SinhVienDao dao1 = new SinhVienDao();
							SinhVien sv=dao1.findById(txtStudentId.getText());
							if(sv!=null) {
								txtName.setText(sv.getHoTen());
							}
						} catch (Exception e2) {
							// TODO: handle exception
							e2.getStackTrace();
						}
						float java = Float.parseFloat(txtJava.getText());
						float tindc = Float.parseFloat(txtTin.getText());
						float csdl = Float.parseFloat(txtCSDL.getText());
				
						float avg = (java + tindc + csdl)/3;
						String st = String.format("%.2f", avg);
						lblGPA.setText(st);
					}else 
						MessageDialogHelper.showErrorDialog("Sinh vien chua duoc cap nhat diem", "Thong bao");
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
					MessageDialogHelper.showErrorDialog(e2.getMessage(), "Loi");
					
				}
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 321, 782, 2);
		add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 333, 742, 236);
		add(scrollPane);
		
		tblGPA = new JTable();
		tblGPA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=tblGPA.getSelectedRow();
					if(row>=0) {
						String id=(String) tblGPA.getValueAt(row, 0);
						BangDiemDao dao1= new BangDiemDao();
						BangDiem bd1= dao1.findByMaSV(id);
						SinhVienDao dao2= new SinhVienDao();
						SinhVien sv1 = dao2.findById(id);
						if(bd1!=null) {
							txtStudentId.setText(bd1.getMaSV());
							txtName.setText(sv1.getHoTen());
							txtJava.setText(Float.toString(bd1.getJava()));
							txtTin.setText(Float.toString(bd1.getTinDC()));;
							txtCSDL.setText(Float.toString(bd1.getCSDL()));
							
							float avg1= (bd1.getJava()+bd1.getCSDL()+bd1.getTinDC())/3;
							String st1 = String.format("%.2f", avg1);
							lblGPA.setText(st1);
							
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					MessageDialogHelper.showErrorDialog(e2.getMessage(), "Loi");
				}
			}
		});
		
		scrollPane.setViewportView(tblGPA);
		
		JLabel lblNewLabel = new JLabel("Quan Ly Diem");
		lblNewLabel.setBounds(10, 0, 742, 33);
		add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		initTable();
		loadBangDiem();
	}

	private void initTable() {
		tblModel = new DefaultTableModel();
		tblModel.setColumnIdentifiers(new String[] {
				"Ma Sinh Vien","Java","Tin DC","CSDL","DTB"
		});
		tblGPA.setModel(tblModel);
	}
	public void loadBangDiem() {
		try {
			BangDiemDao dao = new BangDiemDao();
			ArrayList<BangDiem> list= dao.findTop(5);
			tblModel.setRowCount(0);
			for(BangDiem bd : list) {
				tblModel.addRow(new Object[] {
						bd.getMaSV(),bd.getJava(),bd.getTinDC(),bd.getCSDL(),
						(bd.getJava()+bd.getTinDC()+bd.getCSDL())/3
				});
			}
			tblModel.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MessageDialogHelper.showErrorDialog(e.getMessage(), "Loi");
		}
	}
}
