package bench;

import java.util.Random;

public class DemoBench implements IBenchmark{
	public int n;
	public int[] array;
	public boolean running;
	public void run()
	{
		running=true;
		int x;
		for(int i=0;i<n && running;i++)
			for(int j=i;j<n && running;j++)
			{
				if(array[i]>array[j])
				{
					x=array[i];
					array[i]=array[j];
					array[j]=x;
				}
			}
	}
	public void run(Object x) 
	{
		
	}
	public void initialize(int y)
	{
		Random random = new Random();
		this.n=y;
		this.array= new int[n];
		for(int i=0;i<n;i++)
		{
			array[i]= random.nextInt(1000);
		}
	}
	public void clean()
	{
		
	}
	public void cancel()
	{
		running=false;
	}
	@Override
	public void warmup() {
		// TODO Auto-generated method stub
		
	}
}
