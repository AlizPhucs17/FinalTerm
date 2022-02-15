package CuoiKi.Icons.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CuoiKi.Icons.dao.NguoiDungDao;
import CuoiKi.Icons.helper.DataValidators;
import CuoiKi.Icons.helper.MessageDialogHelper;
import CuoiKi.Icons.helper.Share;
import CuoiKi.Icons.model.NguoiDung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setForeground(new Color(0, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/CuoiKi/Icons/account+circle+24px-131985189042594487_16.png")));
		setLocationRelativeTo(null);;
		setTitle("Dang Nhap");
		setBounds(100, 100, 563, 232);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(201, 22, 331, 173);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ten Dang Nhap:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 35, 91, 13);
		contentPanel.add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(UIManager.getColor("Button.background"));
		txtUsername.setBounds(111, 32, 175, 19);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mat Khau:");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lblNewLabel_2.setBounds(10, 77, 91, 13);
		contentPanel.add(lblNewLabel_2);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(UIManager.getColor("Button.background"));
		txtPassword.setBounds(111, 74, 175, 19);
		contentPanel.add(txtPassword);
		
		JButton btnClose = new JButton("Thoat");
		btnClose.setBackground(SystemColor.menu);
		btnClose.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setIcon(new ImageIcon(Login.class.getResource("/CuoiKi/Icons/delete+exit+remove+icon-1320186209536162845_16.png")));
		btnClose.setBounds(178, 132, 143, 21);
		contentPanel.add(btnClose);
		
		JButton btnLogin = new JButton("Dang Nhap");
		btnLogin.setBackground(SystemColor.menu);
		btnLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				DataValidators.validateEmpty(txtUsername, sb, "Ten dang nhap khong the de trong");
				DataValidators.validateEmpty(txtPassword, sb, "Mat khau khong the de trong");
				if(sb.length()>0) {
					MessageDialogHelper.showErrorDialog(sb.toString(), "Loi");
					return;
				}
				NguoiDungDao dao = new NguoiDungDao();
				try{
					NguoiDung nd= dao.checkLogin(txtUsername.getText(), new String(txtPassword.getPassword()));
					if(nd==null) {
						MessageDialogHelper.showErrorDialog("Ten dang nhap sai hoac mat khau sai", "Loi");
					}else {
						Share.nguoiDangNhap=nd;
						MainForm mf= new MainForm();
						mf.setVisible(true);
						
						dispose();}
				}catch(Exception e1) {
					e1.printStackTrace();
					MessageDialogHelper.showErrorDialog(e1.getMessage(), "Loi");
				}
				
			}
		});
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/CuoiKi/Icons/login+protection+secure+icon-1320196421034327455_16.png")));
		btnLogin.setBounds(10, 132, 143, 21);
		contentPanel.add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 120, 331, 2);
		contentPanel.add(separator);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/CuoiKi/Icons/t\u1EA3i_xu\u1ED1ng-removebg-preview.png")));
		lblLogo.setBounds(10, 0, 181, 195);
		getContentPane().add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 0, 529, 31);
		getContentPane().add(lblNewLabel);
	}
}
