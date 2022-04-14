package testbench;
import java.io.IOException;

import bench.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.FileLogger;
import timing.Timer;
public class CPUBench {
	public static void main(String[] args) throws IOException {
		Timer.start();
		CPUDigitsOfPi benchmark=new CPUDigitsOfPi();
		benchmark.initialize(9);
		benchmark.warmup();
		benchmark.initialize(9);
		benchmark.run();
		ConsoleLogger.write(Timer.stop()/1000000);
		//Offset = 100 * (Timer.totalTime - 1000*1000000) / (1000*1000000);
		//ConsoleLogger.write(Offset);
		//System.out.println(CPUDigitsOfPi.pi);
		ConsoleLogger.close();
		
	}
}
