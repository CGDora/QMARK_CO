package timing;

public class Timer implements ITimer{
	public static long start;
	public static long end;
	public static long elapsed;
	public static long totalTime;
	public static void start()
	{
		start=System.nanoTime();
		elapsed=0;
		totalTime=0;
	}
	public static long stop()
	{
		end=System.nanoTime();
		elapsed=end-start;
		totalTime=totalTime+elapsed;
		return totalTime;
	}
	public static void resume()
	{
		elapsed=0;
		start=System.nanoTime();
	}
	public static long pause()
	{
		end=System.nanoTime();
		elapsed=end-start;
		totalTime=totalTime+elapsed;
		return elapsed;
	}
}
