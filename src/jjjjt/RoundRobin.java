package jjjjt;
import java.util.Scanner;

public class RoundRobin {
	public int[] burstTime;
	public int[] waitingTime;
	public int[] arrivalTime;
	public int[] done;
	public int[] lastTime;
	public int Quanta;
	public double averageWaitingTime;
	public int size;
	
	public RoundRobin(int n, int q, int[] arrival_array,int[] burst_array )
	{
		burstTime=new int[n];
		lastTime=new int[n];
		done=new int[n];
		for(int i=0;i<n;i++)
			burstTime[i]=burst_array[i];
		waitingTime=new int[n];
		arrivalTime=new int[n];
		for(int i=0;i<n;i++)
		{
			arrivalTime[i]=arrival_array[i];
			lastTime[i]=0;
			done[i]=0;
			waitingTime[i]=0;
		}

		size=n;
		Quanta=q;
	}
	public void setValues()
	{
		System.out.println("Give input values:");
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Quanta time : ");
        Quanta=in.nextInt();
        int i=0;
        while(i<size)
        {
            System.out.println("Enter Burst Time : ");
            burstTime[i]=in.nextInt();
            System.out.println("Enter Arrival Time : ");
            arrivalTime[i]=in.nextInt();
			done[i]=0;
			waitingTime[i]=0;
			lastTime[i]=0;
            i++;
        }
	}
	public void averageWaitingTimeCalc()
	{
		//implement RoundRobin
		int all=0;
		int i=0;
		int time=0;
		int total=0;
		System.out.println("Process order - ");
		while(all!=size)
		{
			System.out.print(i);
			System.out.print(" - ");
			if(done[i]==0 && (arrivalTime[i]<time || i==0))
			{
				System.out.print("doing");
				System.out.print(" - ");	
				System.out.println(time);
				if(burstTime[i]>=Quanta)
				{
					waitingTime[i]=waitingTime[i]+(time-lastTime[i]);
					lastTime[i]=time+burstTime[i];
					burstTime[i]=burstTime[i]-Quanta;
					time=time+Quanta;
				}
				else
				{
					waitingTime[i]=waitingTime[i]+(time-lastTime[i]);
					lastTime[i]=time+burstTime[i];
					time=time+burstTime[i];
					burstTime[i]=0;						
				}
				if(burstTime[i]==0)
				{
					all++;
					done[i]=1;
				}
			}
			else if(done[i]==1)
			{
				System.out.println("done");	
			}
			else
			{
				System.out.println("not yet arrived");	
			}
			i=(i+1)%size;
		}
		i=0;
		while(i<size)
        {
            total=total+waitingTime[i];
			i=i+1;
        }
		averageWaitingTime=(double)(total)/(double)(size);
	}
	public double printWaitingTime()
	{
		//Print Waiting Time
		System.out.println("Average Waiting Time = "+averageWaitingTime);
		return averageWaitingTime;
	}
}