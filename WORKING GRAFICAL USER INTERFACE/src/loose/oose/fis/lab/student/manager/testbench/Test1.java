package loose.oose.fis.lab.student.manager.testbench;

import java.io.IOException;


import loose.oose.fis.lab.student.manager.bench.ThreadBench;
import loose.oose.fis.lab.student.manager.logging.ConsoleLogger;
import loose.oose.fis.lab.student.manager.logging.FileLogger;
import timing.Timer;

public class Test1 {

	public static void main(String[] args) throws IOException {
		long Offset;
		Timer.start();
		ThreadBench benchmark=new ThreadBench();
		benchmark.initialize(1000);
		benchmark.run();
		ConsoleLogger.write(Timer.stop()/1000000);
		//Offset = 100 * (Timer.totalTime - 1000*1000000) / (1000*1000000);
		//ConsoleLogger.write(Offset);
		ConsoleLogger.close();
		
		final int workload = 100;
		benchmark.initialize(workload);
		for(int i=0;i<12;++i)
		{
			Timer.resume();
			benchmark.run();
			long time = Timer.pause();
			ConsoleLogger.write("Run "+i+":" + (time)/1000000);
		}
		ConsoleLogger.write("Finished in " + Timer.stop()/1000000);
		//COMMENT: GIT WORKS nyohohohohohohohohohohohohoho
		
		FileLogger x = new FileLogger("input.txt");
		FileLogger.write(0);
		FileLogger.close();
	}

}
