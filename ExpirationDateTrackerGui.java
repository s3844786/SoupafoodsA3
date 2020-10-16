import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;





public class ExpirationDateTrackerGui {

	private JFrame frame;
	private JTable table;
	private JButton AddItemButton;
	private JTextField ItemName;
	private JTextField ItemQty;
	private JTextField ItemDate;
	private JTextField CurrentDate;
	private JLabel lblNewLabel_3;
	private JButton AddDay;
	private JButton CheckDate;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpirationDateTrackerGui window = new ExpirationDateTrackerGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExpirationDateTrackerGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 427);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "Qty", "Expiry Date", "State"
			}
		));
		scrollPane.setViewportView(table);
		
		AddItemButton = new JButton("Add Item");
		AddItemButton.setBounds(471, 183, 216, 23);
		frame.getContentPane().add(AddItemButton);
		
		ItemName = new JTextField();
		ItemName.setBounds(472, 25, 215, 33);
		frame.getContentPane().add(ItemName);
		ItemName.setColumns(10);
		
		ItemQty = new JTextField();
		ItemQty.setColumns(10);
		ItemQty.setBounds(472, 91, 215, 33);
		frame.getContentPane().add(ItemQty);
		
		ItemDate = new JTextField();
		ItemDate.setColumns(10);
		ItemDate.setBounds(472, 147, 215, 33);
		frame.getContentPane().add(ItemDate);
		
		JButton ChangeDate = new JButton("Set Date");
		ChangeDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				CurrentDate.setText(date);
				ItemDate.setText(date);
				//CurrentDate
				
			}
		});
		ChangeDate.setBounds(472, 267, 216, 23);
		frame.getContentPane().add(ChangeDate);
		
		CurrentDate = new JTextField();
		CurrentDate.setColumns(10);
		CurrentDate.setBounds(472, 223, 215, 33);
		frame.getContentPane().add(CurrentDate);
		
		JLabel lblNewLabel = new JLabel("Item");
		lblNewLabel.setBounds(472, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Qty");
		lblNewLabel_1.setBounds(472, 69, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setBounds(472, 132, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date");
		lblNewLabel_2_1.setBounds(472, 209, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		lblNewLabel_3 = new JLabel("Testing Buttons");
		lblNewLabel_3.setBounds(472, 301, 98, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		AddDay = new JButton("Add Day");
		AddDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String date = CurrentDate.getText().toString();
				String[] parts = date.split("-");
				String part1 = parts[0];
				String part2 = parts[1];
				String part3 = parts[2];
				int date123 = Integer.parseInt(part1);
				date123++;
				int part2int = Integer.parseInt(part2);
				int length = 0;
					 if(part2int == 1) {
				length = 31;	
				}
				else if(part2int == 2) {
					length = 28;
				}else if(part2int == 3) {
					length = 31;
				}else if(part2int == 4) {
					length = 30;
				}else if(part2int == 5) {
					length = 31;
				}else if(part2int == 6) {
					length = 30;
				}else if(part2int == 7) {
					length = 31;
				}else if(part2int == 8) {
					length = 31;
				}else if(part2int == 9) {
					length = 30;
				}else if(part2int == 10) {
					length = 31;
				}else if(part2int == 11) {
					length = 30;
				}else if(part2int == 12) {
					length = 31;
				}
					 int date12345 =0;
					if(date123 > length) {
						date123 = 1;
						date12345 = Integer.parseInt(part2);
						date12345++;
						String newdate = (Integer.toString(date123) + "-" + Integer.toString(date12345) + "-" + part3);
						CurrentDate.setText(newdate);
					}
					else {	
					String newdate = (Integer.toString(date123) + "-" + part2 + "-" + part3);
						CurrentDate.setText(newdate);
					}
			}
		});
		AddDay.setBounds(472, 326, 215, 23);
		frame.getContentPane().add(AddDay);
		
		CheckDate = new JButton("Check Date");
		CheckDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x =-1;
				int j = table.getRowCount();
				String enteredDate;
				String SavedDate;
				for(int i=0; j > i; i++) {
					
					
					SavedDate = (String) table.getModel().getValueAt(i, 2);
					enteredDate = CurrentDate.getText().toString();
					String[] parts = SavedDate.split("-");
					String[] SavedParts = enteredDate.split("-");
					String parts1 = parts[0];
					String parts2 = parts[1];
					String SavedParts1 = SavedParts[0];
					String SavedParts2 = SavedParts[1];
					int parts1int = Integer.parseInt(parts1);
					int parts2int = Integer.parseInt(parts2);
					int parts1intSaved = Integer.parseInt(SavedParts1);
					int parts2intSaved = Integer.parseInt(SavedParts2);
					if(parts1intSaved == parts1int  && parts2intSaved >= parts2int)
					{
						table.getModel().setValueAt("<html><font color=\"orange\">Use Soon</font></html>", i, 3);
					}
					if(parts1intSaved > parts1int && parts2intSaved >= parts2int) {
						Color myRED = new Color(255, 0, 0); // Color white
						String Expired = "Expired";
						table.getModel().setValueAt("<html><font color=\"red\">Expired</font></html>", i, 3);
						
					}
				
					
				}
				
				
				
				
			}
		});
		CheckDate.setBounds(472, 378, 215, 23);
		frame.getContentPane().add(CheckDate);
		AddItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String data1 = ItemName.getText().toString();
				    String data2 = ItemQty.getText().toString();
				    String data3 = ItemDate.getText().toString();
				    String data4 = "OK";
				    Object[] row = { data1, data2, data3,"<html><font color=\"green\">Ok</font></html>" };

				    DefaultTableModel model = (DefaultTableModel) table.getModel();

				    model.addRow(row);
			}
		});
	}
	
}
