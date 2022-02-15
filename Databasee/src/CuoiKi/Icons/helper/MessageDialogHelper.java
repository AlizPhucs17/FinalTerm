package CuoiKi.Icons.helper;

import javax.swing.JOptionPane;

public class MessageDialogHelper {
	public static void showMessageDialog(String content, String tittle) {
		JOptionPane.showMessageDialog(null, content,tittle,  JOptionPane.INFORMATION_MESSAGE);
	}
	public static void showErrorDialog(String content, String tittle) {
		JOptionPane.showMessageDialog(null,  content, tittle,JOptionPane.ERROR_MESSAGE);
	}
	public static int showComfirmDialog(String content, String tittle) {
		int choose= JOptionPane.showConfirmDialog(null,  content,tittle,JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		return choose;
	}
}
