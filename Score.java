import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame {
	public Score() {
		JFrame frame = new JFrame("성적 관리 프로그램");
		setSize(500, 400);
		
		String header[] = {"학번","이름","JAVA","Python","C++"};
		String contents[][] = {};
		
		DefaultTableModel model = new DefaultTableModel(contents,header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JTextField studentID = new JTextField(5);
		JTextField nameField = new JTextField(5);
		JTextField subject1 = new JTextField(3);
		JTextField subject2 = new JTextField(3);
		JTextField subject3 = new JTextField(3);
		
		panel.add(studentID);
		panel.add(nameField);
		panel.add(subject1);
		panel.add(subject2);
		panel.add(subject3);
		
		JButton addBtn = new JButton("추가");
		addBtn.setBackground(Color.YELLOW);
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String inputStr[] = new String[5];
				
				inputStr[0] = studentID.getText();
				inputStr[1] = nameField.getText();
				inputStr[2] = subject1.getText();
				inputStr[3] = subject2.getText();
				inputStr[4] = subject3.getText();
				model.addRow(inputStr);
				
				studentID.setText("");
				nameField.setText("");
				subject1.setText("");
				subject2.setText("");
				subject3.setText("");
			}
		});
		JButton cancelBtn = new JButton("삭제");
		cancelBtn.setBackground(Color.PINK);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1)
				{
					return;
				}
				else
				{
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		panel.add(addBtn);
		panel.add(cancelBtn);
		
		frame.add(scrollpane, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Score();
	}
}



