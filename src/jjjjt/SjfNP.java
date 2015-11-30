package jjjjt;

public class SjfNP 
{
	public double getWaitingList(int[] process_id, int[] arrival, int[] burst)
	{
		int[] process=new int[process_id.length];
		
		for(int i=0;i<process_id.length;i++)
		{
			process[i]=process_id[i];
		}

		int sum[] = new int[process.length];
		for(int i=0;i<process.length;i++)
		{
			sum[i] = arrival[i]+burst[i];
		}

		int temp1,temp2,temp3;
		for(int i=1;i<process.length;i++)
		{
			for(int j=i;j<process.length;j++)
			{
				if(sum[i]>sum[j])
				{
					temp1 = process[i];
					process[i] = process[j];
					process[j] = temp1;

					temp2 = arrival[i];
					arrival[i] = arrival[j];
					arrival[j] = temp2;

					temp3 = burst[i];
					burst[i] = burst[j];
					burst[j] = temp3;
				}
			}
		}

		int starttime[] = new int[process.length];
		int finaltime[] = new int[process.length];
		starttime[0] = arrival[0];
		finaltime[0] = burst[0];

		for(int i=1;i<process.length;i++)
		{
			starttime[i] = finaltime[i-1];
			finaltime[i] = starttime[i]+burst[i];
		}
		int waitingtime[] = new int[process.length];
		for(int i=1;i<process.length;i++)
		{
			waitingtime[i] = finaltime[i] - (arrival[i]+burst[i]);

		}
		int temp4,temp5;
		for(int i=0;i<process.length;i++)
		{
			for(int j=i;j<process.length;j++)
			{
				if(process[i]>process[j])
				{
					temp4 = process[i];
					process[i] = process[j];
					process[j] = temp4;

					temp5 = waitingtime[i];
					waitingtime[i] = waitingtime[j];
					waitingtime[j] = temp5;
				}
			}
		}
		
		double avg_sum=0.0;
		for(int i=0;i<process.length;i++)
			avg_sum=avg_sum+waitingtime[i];
		avg_sum=(double)avg_sum/(double)process.length;
		return avg_sum;
	}
}