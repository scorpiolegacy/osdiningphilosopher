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

public class Schedulling_Algorithm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	int[] arrival_array;
	int[] burst_array;
	int[] priority_array;
	int[] process_id;
	int np;
	int qs;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedulling_Algorithm frame = new Schedulling_Algorithm();
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
	public Schedulling_Algorithm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(-15, -33, 741, 525);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(350, 5, 10, 10);
		panel_1.add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(365, 5, 10, 10);
		panel_1.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(380, 5, 10, 10);
		panel_1.add(panel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.YELLOW);
		panel_5.setBounds(28, 81, 680, 113);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		textField = new JTextField();
		JTextArea panel_6 = new JTextArea();
		
		JButton btnFirstCumFirst = new JButton("First Cum First Serve (FCFS)");
		btnFirstCumFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String final_output="";
				System.out.println("Hello");
				Fcfs fcfs_scheduler=new Fcfs(np,burst_array);
				final_output="Average Waiting Time for FCFS: \n"+Double.toString(fcfs_scheduler.averageWaitingTimeCalc());
				final_output=final_output+"\n";
				
				textField.setText(final_output);
				
			}
		});
		btnFirstCumFirst.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnFirstCumFirst.setBackground(Color.MAGENTA);
		btnFirstCumFirst.setBounds(28, 11, 189, 23);
		panel_5.add(btnFirstCumFirst);
		
		JButton btnSjfnonPreemptive = new JButton("SJF-Non Preemptive");
		btnSjfnonPreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String final_output="";
				System.out.println("SJF Non-Preemptive");
				SjfNP sjf_scheduler = new SjfNP();
				final_output+="Average Waiting Time for SJF: \n"+Double.toString(sjf_scheduler.getWaitingList(process_id,arrival_array,burst_array));
				final_output=final_output+"\n";
				textField.setText(final_output);
			}
		});
		btnSjfnonPreemptive.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnSjfnonPreemptive.setBackground(Color.RED);
		btnSjfnonPreemptive.setBounds(443, 11, 189, 23);
		panel_5.add(btnSjfnonPreemptive);
		
		JButton btnSjfPreemptive = new JButton("SJF - Preemptive\r\n ");
		btnSjfPreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String final_output="";
				System.out.println("SJF Preemptive");
				Sjf sjf_scheduler = new Sjf();
				final_output+="Average Waiting Time for SJF Preemptive: \n"+Double.toString(sjf_scheduler.calcAverage(np,arrival_array,burst_array));
				final_output=final_output+"\n";
				textField.setText(final_output);
				
			}
		});
		btnSjfPreemptive.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnSjfPreemptive.setBackground(Color.ORANGE);
		btnSjfPreemptive.setBounds(245, 45, 189, 23);
		panel_5.add(btnSjfPreemptive);
		
		JButton btnRoundRobin = new JButton("Round Robin\r\n");
		btnRoundRobin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String final_output="";
				System.out.println("Round Robin Scheduling");
				RoundRobin r_scheduler = new RoundRobin(np, qs, burst_array, arrival_array);
				r_scheduler.averageWaitingTimeCalc();
				final_output+="Average Waiting Time for Round Robin Scheduling: \n"+Double.toString(r_scheduler.printWaitingTime());
				final_output=final_output+"\n";
				textField.setText(final_output);
			}
		});
		btnRoundRobin.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnRoundRobin.setBackground(Color.PINK);
		btnRoundRobin.setBounds(28, 79, 189, 23);
		panel_5.add(btnRoundRobin);
		
		JButton btnPriority = new JButton("Priority\r\n");
		btnPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String final_output="";
				System.out.println("Priority");
				SjfNP sjf_scheduler = new SjfNP();
				final_output+="Average Waiting Time for Priority: \n"+Double.toString(sjf_scheduler.getWaitingList(process_id,arrival_array,priority_array));
				final_output=final_output+"\n";
				textField.setText(final_output);
			}
		});
		btnPriority.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnPriority.setBackground(Color.CYAN);
		btnPriority.setBounds(443, 79, 189, 23);
		panel_5.add(btnPriority);
		
		JTextPane txtpnSelectASchedulling = new JTextPane();
		txtpnSelectASchedulling.setBackground(Color.ORANGE);
		txtpnSelectASchedulling.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtpnSelectASchedulling.setForeground(Color.BLACK);
		txtpnSelectASchedulling.setText("      Select a Schedulling Algorithm\r\n");
		txtpnSelectASchedulling.setBounds(236, 36, 295, 34);
		panel_1.add(txtpnSelectASchedulling);
		
		JButton btnNewButton = new JButton("Generate Random Input");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RandomInputGeneration generatefile=new RandomInputGeneration(10,3,10,23,12);
				generatefile.randomGenerationToFile();
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(56, 205, 194, 23);
		panel_1.add(btnNewButton);
		
		JButton btnExecute = new JButton("Execute\r\n");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
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
		btnExecute.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnExecute.setBackground(Color.RED);
		btnExecute.setBounds(470, 205, 194, 23);
		panel_1.add(btnExecute);
		
		
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(28, 251, 680, 206);
		panel_1.add(panel_6);
		
		JTextPane txtpnInput = new JTextPane();
		txtpnInput.setText("      Input\r\n");
		txtpnInput.setForeground(Color.BLACK);
		txtpnInput.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtpnInput.setBackground(Color.ORANGE);
		txtpnInput.setBounds(308, 205, 94, 23);
		panel_1.add(txtpnInput);
		
		JTextPane txtpnOutput = new JTextPane();
		txtpnOutput.setText("     Output\r\n");
		txtpnOutput.setForeground(Color.BLACK);
		txtpnOutput.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtpnOutput.setBackground(Color.ORANGE);
		txtpnOutput.setBounds(38, 468, 94, 23);
		panel_1.add(txtpnOutput);
		

		textField.setBounds(156, 468, 552, 20);
		panel_1.add(textField);
		textField.setColumns(10);
	}
}
