import java.awt.Component;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomaPage extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomaPage frame = new HomaPage();
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
	public HomaPage() {
		setTitle("Efor Hesaplama");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);

		JComboBox<String> comboBox = new JComboBox<String>();
		JPanel panel = new JPanel();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cost_calculation", "root", "");
			st = con.createStatement();
			String s = "select * from cost_calculation"; // Tablo adını burada belirtin
			rs = st.executeQuery(s);
			while (rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		} finally {
			try {
				st.close();
				rs.close();
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}

		panel.add(comboBox);
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
}
