package CuoiKi.Icons.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class AboutUsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutUsDialog dialog = new AboutUsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutUsDialog() {
		setForeground(Color.CYAN);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutUsDialog.class.getResource("/CuoiKi/Icons/416-4160887_png-file-svg-intro-icon-png-transparent-png.png")));
		setTitle("Gioi Thieu");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(AboutUsDialog.class.getResource("/CuoiKi/Icons/tablet+user-1319964824643495182_64.png")));
		lblNewLabel.setBounds(10, 44, 136, 151);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quan Ly Sinh Vien");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(168, 10, 258, 29);
		contentPanel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(156, 40, 270, 2);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 205, 416, 9);
		contentPanel.add(separator_1);
		
		JButton btnNewButton = new JButton("Dong");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(AboutUsDialog.class.getResource("/CuoiKi/Icons/delete+exit+remove+icon-1320186209536162845_16.png")));
		btnNewButton.setBounds(327, 224, 85, 21);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Truong: VKU");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_2.setBounds(168, 73, 258, 21);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sinh Vien: Ha Canh Hong Phuc");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_3.setBounds(168, 104, 258, 30);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Ma Sinh Vien: 21IT038");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_5.setBounds(168, 144, 246, 30);
		contentPanel.add(lblNewLabel_5);
	}
}
