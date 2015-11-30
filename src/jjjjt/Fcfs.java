package jjjjt;
import java.util.Scanner;

public class Fcfs {
	public int[] burstTime;
	public int[] waitingTime;
	public double averageWaitingTime;
	public int size;

	public Fcfs(int n,int[] burst_array)
	{
		burstTime=new int[n];
		for(int i=0;i<n;i++)
		{
			burstTime[i]=burst_array[i];
		}
		waitingTime=new int[n];
		size=n;
	}
	public void setValues()
	{
		System.out.println("Give input values:");
        Scanner in=new Scanner(System.in);
        int i=0;
        while(i<size)
        {
            burstTime[i]=in.nextInt();
            i++;
        }
	}
	public double averageWaitingTimeCalc()
	{
		//implement FCFS
		int total=0;
		System.out.println("Calculating Average Waiting Time:");
		int i=1;
        waitingTime[0]=0;
        System.out.println("Calculating Average Waiting Time:");
        while(i<size)
        {
            waitingTime[i]=waitingTime[i-1]+burstTime[i-1];
            total=total+waitingTime[i];
			i=i+1;
        }
        
        averageWaitingTime=(double)(total)/(double)(size);
        System.out.println(Double.toString(averageWaitingTime));
        return averageWaitingTime;
	}
	public double printWaitingTime()
	{
		//Print Waiting Time
		System.out.println("Average Waiting Time = "+averageWaitingTime);
		return averageWaitingTime;
	}
}
