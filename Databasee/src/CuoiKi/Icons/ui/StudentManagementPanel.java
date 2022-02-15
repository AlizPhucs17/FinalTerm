package CuoiKi.Icons.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import CuoiKi.Icons.dao.BangDiemDao;
import CuoiKi.Icons.dao.SinhVienDao;
import CuoiKi.Icons.helper.DataValidators;
import CuoiKi.Icons.helper.ImageHelper;
import CuoiKi.Icons.helper.MessageDialogHelper;
import CuoiKi.Icons.model.BangDiem;
import CuoiKi.Icons.model.SinhVien;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Color;
import java.awt.*;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.UIManager;

public class StudentManagementPanel extends JPanel {
	private JTextField txtStudentId;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTable tblStudents;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private MainForm parentForm;
	private DefaultTableModel tblModel;
	private byte[] personalImage;
	private GPAManagementPanel ld;
	/**
	 * Create the panel.
	 */
	public StudentManagementPanel() {
		setBackground(Color.WHITE);
		setForeground(Color.RED);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quan Ly Sinh Vien");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 0, 749, 43);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 33, 759, 10);
		add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Ma Sinh Vien:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_1.setBounds(187, 53, 108, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ho Ten:");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_2.setBounds(187, 86, 108, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_3.setBounds(187, 115, 108, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("So Dien Thoai:");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_4.setBounds(187, 144, 108, 13);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gioi Tinh:");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_5.setBounds(187, 167, 108, 27);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Dia Chi:");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_6.setBounds(187, 204, 108, 13);
		add(lblNewLabel_6);
		
		txtStudentId = new JTextField();
		txtStudentId.setBackground(UIManager.getColor("Button.background"));
		txtStudentId.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		txtStudentId.setBounds(305, 53, 265, 19);
		add(txtStudentId);
		txtStudentId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBackground(UIManager.getColor("Button.background"));
		txtName.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		txtName.setBounds(305, 83, 265, 19);
		add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(UIManager.getColor("Button.background"));
		txtEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		txtEmail.setBounds(305, 112, 265, 19);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBackground(UIManager.getColor("Button.background"));
		txtPhone.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		txtPhone.setBounds(305, 141, 265, 19);
		add(txtPhone);
		txtPhone.setColumns(10);
		
		JRadioButton rdbMale = new JRadioButton("Nam");
		rdbMale.setBackground(Color.WHITE);
		rdbMale.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		buttonGroup.add(rdbMale);
		rdbMale.setBounds(343, 167, 52, 27);
		add(rdbMale);
		
		JRadioButton rdbFemale = new JRadioButton("Nu");
		rdbFemale.setBackground(Color.WHITE);
		rdbFemale.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		rdbFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(rdbFemale);
		rdbFemale.setBounds(459, 163, 52, 31);
		add(rdbFemale);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setBackground(UIManager.getColor("Button.background"));
		txtAddress.setWrapStyleWord(true);
		txtAddress.setLineWrap(true);
		txtAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		txtAddress.setBounds(305, 198, 265, 80);
		add(txtAddress);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(580, 53, 168, 225);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/CuoiKi/Icons/avatar+circle+male+profile+user+icon-1320196703471638282_64.png")));
		lblImage.setBounds(10, 10, 148, 167);
		panel.add(lblImage);
		
		JButton btnBrowse = new JButton("Mo Hinh");
		btnBrowse.setBackground(Color.WHITE);
		btnBrowse.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnBrowse.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/CuoiKi/Icons/open+in+browser+24px-131985192861635311_16.png")));
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser=new JFileChooser();
				chooser.setFileFilter(new FileFilter() {
					
					@Override
					public String getDescription() {
						// TODO Auto-generated method stub
						
						return "Image File (*.jpg)";
					}
					
					@Override
					public boolean accept(File f) {
						// TODO Auto-generated method stub
						if(f.isDirectory()) {
							return true;
						}else {
							return f.getName().toLowerCase().endsWith(".jpg");
						}
					}
				});
				if(chooser.showOpenDialog(null)== JFileChooser.CANCEL_OPTION){
					
				return;
				}
				File file =chooser.getSelectedFile();
				try {
					ImageIcon icon = new ImageIcon(file.getPath());
					Image img=ImageHelper.resize(icon.getImage(), 140, 160);
					ImageIcon resizedIcon= new ImageIcon(img);
					lblImage.setIcon(resizedIcon);
					personalImage = ImageHelper.toByteArray(img, "jpg");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					MessageDialogHelper.showErrorDialog(e2.getMessage(), "Loi");
				}
			}
		});
		btnBrowse.setBounds(37, 194, 101, 21);
		panel.add(btnBrowse);
		
		JButton btnNew = new JButton("Tao Moi");
		btnNew.setBackground(Color.WHITE);
		btnNew.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnNew.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/CuoiKi/Icons/new+releases+24px-131985190616836545_16.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmail.setText("");
				txtName.setText("");
				txtPhone.setText("");
				txtStudentId.setText("");
				txtAddress.setText("");
				personalImage=null;
				ImageIcon icon = new ImageIcon(getClass().getResource("/CuoiKi/Icons/avatar+circle+male+profile+user+icon-1320196703471638282_64.png"));
				lblImage.setIcon(icon);
			}
		});
		btnNew.setBounds(10, 241, 115, 37);
		add(btnNew);
		
		JButton btnUpdate = new JButton("Cap Nhat");
		btnUpdate.setBackground(Color.ORANGE);
		btnUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb= new StringBuilder();
				DataValidators.validateEmpty(txtStudentId, sb, "Ma sinh vien khong duoc de trong");
				DataValidators.validateEmpty(txtName, sb, "Ten sinh vien khong duoc de trong");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(sb.toString(), "Loi");
					return ;
				}
				if(MessageDialogHelper.showComfirmDialog("Ban co muon cap nhat sinh vien khong","Hoi") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					SinhVien sv=new SinhVien();
					sv.setMaSV(txtStudentId.getText());
					sv.setHoTen(txtName.getText());
					sv.setEmail(txtEmail.getText());
					sv.setSoDT(txtPhone.getText());
					sv.setDiaChi(txtAddress.getText());
					sv.setGioiTinh(rdbMale.isSelected()?1: 0);
					sv.setHinh(personalImage);
					
					SinhVienDao dao = new SinhVienDao();
					if(dao.update(sv)) {
						MessageDialogHelper.showMessageDialog("Sinh vien da duoc cap nhat ", "Thong bao");
						loadDataToTable();
					}else {
						MessageDialogHelper.showMessageDialog("Sinh vien khong duoc cap nhat do loi", "Canh bao");
					}
					
					}
				
				catch(Exception s) {
					s.printStackTrace();
					MessageDialogHelper.showErrorDialog(s.getMessage(),"Loi");
				}
			}
				
		});
		btnUpdate.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/CuoiKi/Icons/update+48px-131985194340414160_16.png")));
		btnUpdate.setBounds(10, 120, 115, 37);
		add(btnUpdate);
		
		JButton btnSave = new JButton("Luu");
		btnSave.setBackground(Color.RED);
		btnSave.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb= new StringBuilder();
				DataValidators.validateEmpty(txtStudentId, sb, "Ma sinh vien khong duoc de trong");
				DataValidators.validateEmpty(txtName, sb, "Ten sinh vien khong duoc de trong");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(sb.toString(), "Loi");
					return ;
				}
				try {
					SinhVien sv=new SinhVien();
					sv.setMaSV(txtStudentId.getText());
					sv.setHoTen(txtName.getText());
					sv.setEmail(txtEmail.getText());
					sv.setSoDT(txtPhone.getText());
					sv.setDiaChi(txtAddress.getText());
					sv.setGioiTinh(rdbMale.isSelected()?1: 0);
					sv.setHinh(personalImage);
					
					SinhVienDao dao = new SinhVienDao();
					if(dao.insert(sv)) {
						MessageDialogHelper.showMessageDialog("Sinh vien da duoc luu", "Thong bao");
						loadDataToTable();
					}else {
						MessageDialogHelper.showMessageDialog("Sinh vien khong duoc luu do loi", "Canh bao");
					}
					
					}
				
				catch(Exception s) {
					s.printStackTrace();
					MessageDialogHelper.showErrorDialog(s.getMessage(),"Loi");
				}
			}
		});
		btnSave.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/CuoiKi/Icons/save-1321215625037841495_16.png")));
		btnSave.setBounds(10, 53, 115, 38);
		add(btnSave);
		
		JButton btnDelete = new JButton("Xoa");
		btnDelete.setBackground(Color.BLUE);
		btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb= new StringBuilder();
				DataValidators.validateEmpty(txtStudentId, sb, "Ma sinh vien khong duoc de trong");
				DataValidators.validateEmpty(txtName, sb, "Ten sinh vien khong duoc de trong");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(sb.toString(), "Loi");
					return ;
				}
				if(MessageDialogHelper.showComfirmDialog("Ban co muon xoa sinh vien khong","Hoi") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					
					SinhVienDao dao = new SinhVienDao();
					BangDiemDao dao1 =new BangDiemDao();
					BangDiem bd =dao1.findByMaSV(txtStudentId.getText());
					if(bd==null)
					{
						
					}
					dao1.deleteByMaSV(txtStudentId.getText());
				
					if(dao.delete(txtStudentId.getText())) {
						MessageDialogHelper.showMessageDialog("Sinh vien da duoc xoa ", "Thong bao");
						loadDataToTable();
					}else {
						MessageDialogHelper.showMessageDialog("Sinh vien khong duoc xoa do loi", "Canh bao");
					}
					
					}
				
				catch(Exception s) {
					s.printStackTrace();
					MessageDialogHelper.showErrorDialog(s.getMessage(),"Loi");
				}
			}
		});
		btnDelete.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/CuoiKi/Icons/delete+remove+stop+icon-1320085969624362047_16.png")));
		btnDelete.setBounds(10, 180, 115, 37);
		add(btnDelete);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 345, 759, 2);
		add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 357, 737, 208);
		add(scrollPane);
		
		tblStudents = new JTable();
		tblStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int rows=tblStudents.getSelectedRow();
					if(rows>=0) {
						String id=(String) tblStudents.getValueAt(rows, 0);
						SinhVienDao dao= new SinhVienDao();
						SinhVien sv= dao.findById(id);
						if(sv!=null) {
							txtStudentId.setText(sv.getMaSV());
							txtName.setText(sv.getHoTen());
							txtEmail.setText(sv.getEmail());
							txtPhone.setText(sv.getSoDT());
							rdbMale.setSelected(sv.getGioiTinh()==1? true: false);
							txtAddress.setText(sv.getDiaChi());
							if(sv.getHinh()!=null) {
								Image img= ImageHelper.createImagerFromByteArray(sv.getHinh(), "jpg");
								lblImage.setIcon(new ImageIcon(img));
								personalImage=sv.getHinh();
							}else {
								personalImage= sv.getHinh();
								ImageIcon icon = new ImageIcon(getClass().getResource("/CuoiKi/Icons/avatar+circle+male+profile+user+icon-1320196703471638282_64.png"));
								lblImage.setIcon(icon);
							}
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					MessageDialogHelper.showErrorDialog(e2.getMessage(), "Loi");
				}
			}
		});
		scrollPane.setViewportView(tblStudents);
		
		initTable();
		loadDataToTable();
		
		
	}
	

private void initTable() {
	tblModel= new DefaultTableModel();
	tblModel.setColumnIdentifiers(new String[]{"Ma sinh vien","Ho ten","Email","SDT","Gioi tinh","Dia Chi"});
	tblStudents.setModel(tblModel);
}
private void loadDataToTable() {
	try {
		SinhVienDao dao= new SinhVienDao();
		List<SinhVien> list = dao.findAll();
		tblModel.setRowCount(0);
		for(SinhVien it: list) {
			tblModel.addRow(new Object[] {
				it.getMaSV(), it.getHoTen(),it.getEmail(),it.getSoDT(),it.getGioiTinh()==1? "Nam": "Nu",it.getDiaChi()	
			});
		}
		tblModel.fireTableDataChanged();
	}
	catch(Exception s) {
		s.printStackTrace();
		MessageDialogHelper.showErrorDialog(s.getMessage(), "Loi");
	}
}

}
	
