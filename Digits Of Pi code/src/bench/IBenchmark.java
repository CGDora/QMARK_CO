package bench;

public interface IBenchmark {

	void run();
	void run(Object x);
	void initialize(int y);
	void clean();
	void cancel();
	public void warmup();
}
