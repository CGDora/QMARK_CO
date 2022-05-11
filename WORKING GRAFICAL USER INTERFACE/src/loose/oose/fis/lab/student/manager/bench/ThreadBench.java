package bench;

import java.util.Random;

public class ThreadBench implements IBenchmark{
	public int n;
	public void run()
	{
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(Object x) 
	{
		
	}
	public void initialize(int y)
	{
		this.n=y;
		
	}
	public void clean()
	{
		
	}
	public void cancel()
	{
		
	}
	@Override
	public void warmup() {
		// TODO Auto-generated method stub
		
	}
}