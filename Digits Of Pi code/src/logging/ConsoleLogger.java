package logging;

import java.util.concurrent.TimeUnit;

public class ConsoleLogger implements ILog{

	public static void write (long x)
	{
		System.out.println(x);
	}
	public static void write (String str)
	{
		System.out.println(str);
	}
	public static void close()
	{
		
	}
	public static void write ()
	{
		
	}
	static void writeTime(long value, TimeUnit unit)
	{
		
	}
	static void writeTime(String string, long value, TimeUnit unit)
	{
		if (unit == TimeUnit.MILLISECONDS)
			System.out.println(string+value/1000000+" Milli");
		if (unit == TimeUnit.NANOSECONDS)
			System.out.println(string+value+" NANO");
		if (unit == TimeUnit.SECONDS)
			System.out.println(string+value/1000000000+" Seconds");
		
	}
}
