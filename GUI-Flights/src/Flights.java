import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class Flights extends JFrame {
	
	public static ArrayList<String[]> getData(){
		String path = "C:\\Users\\jhena\\OneDrive\\Documents\\CS Year 1\\CS1701\\Group Project\\Design\\Flights2024.csv";
		String line = "";
		ArrayList<String[]> values = new ArrayList<String[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				String [] x = line.split(",");
				values.add(x);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return (values);
		}
		catch (IOException e) {
			e.printStackTrace();
			return (values);
		}
		return (values);
	}
	
	public static ArrayList<String[]> filterFlights(String[] c) {
		int i;
		ArrayList <String[]> a = getData();
		ArrayList<String[]> availableF = new ArrayList<String[]>();
		ArrayList<String[]> availableD = new ArrayList<String[]>();
		ArrayList<String[]> availableR = new ArrayList<String[]>();
		for (i = 0; i < 176800 ; ++i) {
			String [] b = a.get(i);
			if ((b[7].equals(c[0])) && (b[9].equals(c[1])) && (b[0].equals(c[2]))) {
				availableD.add(b);
			}
			else if ((b[9].equals(c[0])) && (b[7].equals(c[1])) && (b[0].equals( c[3]))) {
				availableR.add(b);
			}
		}
		availableF.addAll(availableD);
		availableF.addAll(availableR);
		return (availableF);
	}

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flights frame = new Flights();
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
	public Flights() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] flights = new String[4];
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				String dCity = (String)cb.getSelectedItem();
				flights[0] = dCity;
			}
		});
		comboBox.setBounds(110, 65, 210, 22);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				String aCity = (String)cb.getSelectedItem();
				flights[1] = aCity;
			}
		});
		comboBox_1.setBounds(110, 127, 210, 22);
		
		ArrayList <String[]> a = getData();
		ArrayList<String> cities = new ArrayList<String>();
		String c;
		
		int i = 0;
		String [] b = a.get(i);
		c = b[7];
		for (i = 1; i < 176800; ++i) {
			b = a.get(i);
			if (c.compareTo(b[7]) == 0) {
				
			}
			else if (c.compareTo(b[7]) != 0){ 
				cities.add(c);
				c = b[7];
			}
		}
		
		Set<String> set = new HashSet<>(cities);
		cities.clear();
		cities.addAll(set);

		comboBox.addItem("");
		comboBox_1.addItem("");
		
		for (i = 0; i < cities.size(); ++i) {
			comboBox.addItem(cities.get(i));
			comboBox_1.addItem(cities.get(i));
		}
		contentPane.add(comboBox);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("FROM:");
		lblNewLabel.setBounds(112, 32, 68, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("TO:");
		lblTo.setBounds(110, 98, 70, 22);
		contentPane.add(lblTo);
		
		JLabel lblDepartureDate = new JLabel("DEPARTURE DATE:");
		lblDepartureDate.setBounds(390, 32, 139, 22);
		contentPane.add(lblDepartureDate);
		
		JLabel lblReturnDate = new JLabel("RETURN DATE:");
		lblReturnDate.setBounds(390, 98, 139, 22);
		contentPane.add(lblReturnDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(390, 65, 139, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(390, 127, 139, 20);
		contentPane.add(dateChooser_1);
		
		JList<String> list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(110, 200, 620, 80);
		contentPane.add(list);
		
		JList<String> list1 = new JList<String>();
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.setBounds(110, 319, 620, 80);
		contentPane.add(list1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flights[0].equals("") || flights[1].equals("")) {
					String message = "select a departure and arrival city";
					String title = "ERROR";
					JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
				}
				else if (flights[0].equals(flights[1])){
					String message = "departure and arrival city can't be the same";
					String title = "ERROR";
					JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					DefaultListModel<String> dlm = new DefaultListModel<String>();
					DefaultListModel<String> dlm1 = new DefaultListModel<String>();
					dlm.removeAllElements();
					dlm1.removeAllElements();
										
					SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
					
					try {
						Date date = dateChooser.getDate();
						String dDate = DATE_FORMAT.format(date);
						flights[2] = dDate;;
					}
					catch (Exception e2) {
						String message = "no departure date selected";
						String title = "ERROR";
						JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
						flights[2] = "";
					}
					try {
						Date date1 = dateChooser_1.getDate();
						String rDate = DATE_FORMAT.format(date1);
						flights[3] = rDate;
					}
					catch (Exception e3) {
						String message = "no return date selected";
						String title = "ERROR";
						JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
						flights[3] = "";
					}
					try {
						Date date = dateChooser.getDate();
						Date date1 = dateChooser_1.getDate();
						Date cdate = new Date();
						if (date.before(cdate)){
							String message = "selected departure date has already passed";
							String title = "ERROR";
							JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
							flights[2] = "";
						}
						else if (date1.before(cdate)){
							String message = "selected return date has already passed";
							String title = "ERROR";
							JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
							flights[3] = "";
						}
						else if (date1.before(date)) {
							String message = "return date can't be before departure date";
							String title = "ERROR";
							JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
							flights[3] = "";
						}
					}
					catch (Exception e4) {	
					}
					
					ArrayList<String[]> available = filterFlights(flights);
					
					int i;					
					for (i = 0; i < available.size(); ++i) {
						String [] data = available.get(i);
						if (flights[0].equals(data[7])) {
							dlm.addElement(String.format("%1.20s %20.20s %20.20s %20.20s %20.20s %20.20s %20.20s" , data[7] , data[6] , data[9] , data[8] , data[1] , data[2] , data[10]));
							list.setModel(dlm);
						}
						else {
							dlm1.addElement(String.format("%1.20s %20.20s %20.20s %20.20s %20.20s %20.20s %20.20s" , data[7] , data[6] , data[9] , data[8] , data[1] , data[2] , data[10]));
							list1.setModel(dlm1);
	
						}
					}
				}
			}
		});
		btnNewButton.setBounds(641, 127, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JLabel lbldFlights = new JLabel("DEPARTURE FLIGHTS");
		lbldFlights.setBounds(110, 180, 210, 20);
		contentPane.add(lbldFlights);
		
		JLabel lblrFlights = new JLabel("RETURN FLIGHTS");
		lblrFlights.setBounds(110, 300, 210, 20);
		contentPane.add(lblrFlights);		
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String rData = (String) list1.getSelectedValue();
					String fData = (String) list.getSelectedValue();
					boolean x = rData.equals(null);
					boolean y = fData.equals(null);
					String message = "flights have been booked";
					String title = "SUCCESS";
					JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e5) {
					String message = "flights not selected";
					String title = "ERROR";
					JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton_1.setBounds(641, 420, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
