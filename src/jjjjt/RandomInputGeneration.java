package jjjjt;
import java.util.Random;
import java.io.*;

public class RandomInputGeneration {
	private int numOfProcess;
	private int maxpriority;
	private int maxArrival;
	private int maxBurstTime;
	private int quantumslice;
	
	public RandomInputGeneration(int numOfProcess, int quantumslice, int maxpriority, int maxArrival, int maxBurstTime )
	{
		this.numOfProcess=numOfProcess;
		this.maxpriority=maxpriority;
		this.maxArrival=maxArrival;
		this.maxBurstTime=maxBurstTime;
		this.quantumslice=quantumslice;
	}
	
	public void PrintPerm(int[] inputs, int currentFocus)
	{
	   if (currentFocus == inputs.length-1)
	      {
	        return;
	      }
	   PrintPerm(inputs, currentFocus+1);
	   for(int i=currentFocus+1;i<inputs.length;i++)
	   {
	     int temp= inputs[currentFocus];
	     inputs[currentFocus]=inputs[i];
	     inputs[i]=temp;
	     PrintPerm(inputs, currentFocus+1);
	   }
	}


	public void randomGenerationToFile()
	{
		//fill your code so that 
		
		try {

			
			File file = new File("."+System.getProperty("file.separator")+"scheduling_input_java.txt");			
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(),false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Random randomvariable=new Random();
			
			String np=Integer.toString(numOfProcess);
			String qs=Integer.toString(quantumslice);
			bw.write(np+" "+qs+System.lineSeparator());
			
			int[] priority_array=new int[numOfProcess];
			
			for(int i=0;i<numOfProcess;i++)
			{
				priority_array[i]=i+1;
			}
			
			PrintPerm(priority_array,randomvariable.nextInt(numOfProcess));

			for(int i=0;i<numOfProcess;i++)
			{
				int tt=randomvariable.nextInt(maxArrival);
				int bb=randomvariable.nextInt(maxBurstTime);
				int pid=i;				
				String stt=Integer.toString(tt);
				String sbb=Integer.toString(bb);
				String spid=Integer.toString(pid);
				String getpriority=Integer.toString(priority_array[i]);
				
				bw.write(spid+" "+stt+" "+sbb+" "+getpriority+System.lineSeparator());							
			}
			
			bw.close();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
