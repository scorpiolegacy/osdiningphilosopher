package jjjjt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Os_simulator extends JFrame {
	/**
	 * @wbp.nonvisual location=0,-31
	 */
	private final JPanel panel = new JPanel();
	private JTextField txtDemonstrationOfSchedulling;
	private JTextField textField;
	
	int[] arrival_array;
	int[] burst_array;
	int[] priority_array;
	int[] process_id;
	int np;
	int qs;
	private JTextField textField_1;
	private JTextField txtOutput;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Os_simulator frame = new Os_simulator();
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
	public Os_simulator() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 491);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 732, 431);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtDemonstrationOfSchedulling = new JTextField();
		txtDemonstrationOfSchedulling.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 12));
		txtDemonstrationOfSchedulling.setBackground(Color.BLUE);
		txtDemonstrationOfSchedulling.setText("                   Demonstration Of Schedulling Algorithms\r\n");
		txtDemonstrationOfSchedulling.setBounds(166, 11, 401, 35);
		panel_1.add(txtDemonstrationOfSchedulling);
		txtDemonstrationOfSchedulling.setColumns(10);
		
		JTextArea panel_6 = new JTextArea();
		panel_6.setFont(new Font("Verdana", Font.PLAIN, 13));
		textField = new JTextField();
		textField.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		textField.setForeground(Color.RED);
		
		JButton btnFirstCumFirst = new JButton("First Cum First Serve (FCFS)\r\n");
		btnFirstCumFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String final_output="";
				System.out.println("Hello");
				Fcfs fcfs_scheduler=new Fcfs(np,burst_array);
				final_output="Average Waiting Time for FCFS: \n"+Double.toString(fcfs_scheduler.averageWaitingTimeCalc());
				final_output=final_output+"\n";
				textField.setText(final_output);
			}
		});
		btnFirstCumFirst.setBackground(Color.ORANGE);
		btnFirstCumFirst.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		btnFirstCumFirst.setBounds(22, 129, 199, 23);
		panel_1.add(btnFirstCumFirst);
		
		JButton btnSjfnonPreemptive = new JButton("SJF-Non Preemptive\r\n");
		btnSjfnonPreemptive.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String final_output="";
					System.out.println("SJF Non-Preemptive");
					SjfNP sjf_scheduler = new SjfNP();
					final_output+="Average Waiting Time for SJF-Non Preemptive: \n"+Double.toString(sjf_scheduler.getWaitingList(process_id,arrival_array,burst_array));
					final_output=final_output+"\n";
					textField.setText(final_output);
				}
			});
		btnSjfnonPreemptive.setBackground(Color.YELLOW);
		btnSjfnonPreemptive.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		btnSjfnonPreemptive.setBounds(22, 183, 199, 23);
		panel_1.add(btnSjfnonPreemptive);
		
		JButton btnSjfPreemptive = new JButton("SJF-Preemptive\r\n");
		btnSjfPreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String final_output="";
				System.out.println("SJF Preemptive");
				Sjf sjf_scheduler = new Sjf();
				final_output+="Average Waiting Time for SJF Preemptive: \n"+Double.toString(sjf_scheduler.calcAverage(np,arrival_array,burst_array));
				final_output=final_output+"\n";
				textField.setText(final_output);
			}
		});
		btnSjfPreemptive.setBackground(Color.GREEN);
		btnSjfPreemptive.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		btnSjfPreemptive.setBounds(22, 239, 199, 23);
		panel_1.add(btnSjfPreemptive);
		
		JButton btnRoundRobin = new JButton("Round Robin\r\n");
		btnRoundRobin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String final_output="";
				System.out.println("Round Robin Scheduling");
				RoundRobin r_scheduler = new RoundRobin(np, qs, burst_array, arrival_array);
				r_scheduler.averageWaitingTimeCalc();
				final_output+="Average Waiting Time for Round Robin Scheduling: \n"+Double.toString(r_scheduler.printWaitingTime());
				final_output=final_output+"\n";
				textField.setText(final_output);
			}
		});
			
		btnRoundRobin.setBackground(Color.CYAN);
		btnRoundRobin.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		btnRoundRobin.setBounds(22, 293, 198, 23);
		panel_1.add(btnRoundRobin);
		
		JButton btnPriority = new JButton("Priority\r\n");
		btnPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String final_output="";
				System.out.println("Priority");
				SjfNP sjf_scheduler = new SjfNP();
				final_output+="Average Waiting Time for Priority: \n"+Double.toString(sjf_scheduler.getWaitingList(process_id,arrival_array,priority_array));
				final_output=final_output+"\n";
				textField.setText(final_output);
			}
		});
		btnPriority.setBackground(Color.PINK);
		btnPriority.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		btnPriority.setBounds(22, 345, 199, 23);
		panel_1.add(btnPriority);
		
		JButton btnNewButton = new JButton("Generate Random Input\r\n");
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					RandomInputGeneration generatefile=new RandomInputGeneration(10,3,10,23,12);
					generatefile.randomGenerationToFile();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(87, 70, 199, 23);
		panel_1.add(btnNewButton);
		
		JButton btnExecute = new JButton("Execute\r\n");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
String final_output ="";
				
				try (BufferedReader br = new BufferedReader(new FileReader("."+System.getProperty("file.separator")+"scheduling_input_java.txt")))
				{
					
					String line;
					line=br.readLine();
					String[] firstline=line.split(" ");
					np=Integer.valueOf(firstline[0]);
					qs=Integer.valueOf(firstline[1]);
					
					String desired_input="";
					desired_input="Number of processes: "+firstline[0]+" ,Quantum Slice: "+firstline[1]+"\n";
					desired_input+="PID     Arrival Time      Burst Time      Priority\n";
					
					arrival_array=new int[np];
					burst_array=new int[np];
					priority_array=new int[np];
					process_id=new int[np];
					
					while ((line = br.readLine()) != null) 
					{
						String[] valuelineString=line.split(" ");
						int process_i=Integer.valueOf(valuelineString[0]);
						int arrival_time=Integer.valueOf(valuelineString[1]);
						int burst_time=Integer.valueOf(valuelineString[2]);
						int priority_val=Integer.valueOf(valuelineString[3]);
						
						arrival_array[process_i]=arrival_time;
						burst_array[process_i]=burst_time;
						priority_array[process_i]=priority_val;
						process_id[process_i]=process_i;
						
						desired_input+="     "+valuelineString[0]+"               "+valuelineString[1]+"                 "+valuelineString[2]+"                 "+valuelineString[3]+"\n";
						
						System.out.println(Integer.toString(burst_time));
						panel_6.setText(desired_input);
					}
			}
				catch (IOException ep)
				{
					ep.printStackTrace();
				}
		}});
		btnExecute.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		btnExecute.setBackground(Color.GRAY);
		btnExecute.setBounds(419, 70, 199, 23);
		panel_1.add(btnExecute);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(288, 128, 4, 22);
		panel_1.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(683, 128, -377, 237);
		panel_1.add(textArea_1);
		
		
		panel_6.setBounds(282, 128, 420, 237);
		panel_1.add(panel_6);
		
		textField.setBounds(99, 379, 603, 41);
		panel_1.add(textField);
		textField.setColumns(10);
		
		txtOutput = new JTextField();
		txtOutput.setBackground(Color.MAGENTA);
		txtOutput.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		txtOutput.setText("    Output \r\n");
		txtOutput.setBounds(3, 389, 86, 20);
		panel_1.add(txtOutput);
		txtOutput.setColumns(10);
	}
}
