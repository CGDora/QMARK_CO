package bench;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class CPUDigitsOfPi implements IBenchmark{
	private int size;
	public static BigDecimal pi =  BigDecimal.ZERO;
	public static BigDecimal denom1 =  BigDecimal.ONE;
	public static BigDecimal denom2 =  BigDecimal.ONE;
	public static BigDecimal term1 =  BigDecimal.ZERO;
	public static BigDecimal term2 =  BigDecimal.ZERO;
	@SuppressWarnings("deprecation")
	public void run() {
		{
			// accuracy parameters set to 1000 arbitrarily
			for(int i=2;i<1000;i+=4)
			{
				denom1 =  BigDecimal.ONE;
				denom1 = denom1.multiply(new BigDecimal(i));
				denom1 = denom1.multiply(new BigDecimal(i+1));
				denom1 = denom1.multiply(new BigDecimal(i+2));

				denom2 =  BigDecimal.ONE;
				denom2 = denom2.multiply(new BigDecimal(i+2));
				denom2 = denom2.multiply(new BigDecimal(i+3));
				denom2 = denom2.multiply(new BigDecimal(i+4));

				// accuracy parameters set to 1000 arbitrarily
				term1 = new BigDecimal("4").divide(denom1,1000, RoundingMode.HALF_UP);
				term2 = new BigDecimal("-4").divide(denom2, 1000, RoundingMode.HALF_UP);

				pi = pi.add(term1);
				pi = pi.add(term2);
			}

			// 3 + calculated value
			pi = pi.add(new BigDecimal (3));
			System.out.println(pi);
			// user digit input applied
			pi = pi.setScale(size,  1);
			//System.out.println(pi);
			pi =  BigDecimal.ZERO;
		}
		
	}

	public void run(Object x) {
		{
			// accuracy parameters set to 1000 arbitrarily
			int scale = (int)x;
			for(int i=2;i<scale;i+=4)
			{
				denom1 =  BigDecimal.ONE;
				denom1 = denom1.multiply(new BigDecimal(i));
				denom1 = denom1.multiply(new BigDecimal(i+1));
				denom1 = denom1.multiply(new BigDecimal(i+2));

				denom2 =  BigDecimal.ONE;
				denom2 = denom2.multiply(new BigDecimal(i+2));
				denom2 = denom2.multiply(new BigDecimal(i+3));
				denom2 = denom2.multiply(new BigDecimal(i+4));

				// accuracy parameters set to 1000 arbitrarily
				term1 = new BigDecimal("4").divide(denom1,scale, RoundingMode.HALF_UP);
				term2 = new BigDecimal("-4").divide(denom2, scale, RoundingMode.HALF_UP);

				pi = pi.add(term1);
				pi = pi.add(term2);
			}

			// 3 + calculated value
			pi = pi.add(new BigDecimal (3));
			System.out.println(pi);
			// user digit input applied
			pi = pi.setScale(size,  1);
			//System.out.println(pi);
			pi =  BigDecimal.ZERO;
		}
		
	}

	public void initialize(int y) {
		// TODO Auto-generated method stub
		this.size = size;
	}

	public void clean() {
		// TODO Auto-generated method stub
		
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warmup() {
		for(int i=2;i<1000;i+=4)
		{
			denom1 =  BigDecimal.ONE;
			denom1 = denom1.multiply(new BigDecimal(i));
			denom1 = denom1.multiply(new BigDecimal(i+1));
			denom1 = denom1.multiply(new BigDecimal(i+2));

			denom2 =  BigDecimal.ONE;
			denom2 = denom2.multiply(new BigDecimal(i+2));
			denom2 = denom2.multiply(new BigDecimal(i+3));
			denom2 = denom2.multiply(new BigDecimal(i+4));

			// accuracy parameters set to 1000 arbitrarily
			term1 = new BigDecimal("4").divide(denom1, 1000, RoundingMode.HALF_UP);
			term2 = new BigDecimal("-4").divide(denom2, 1000, RoundingMode.HALF_UP);

			pi = pi.add(term1);
			pi = pi.add(term2);
		}

		// 3 + calculated value
		pi = pi.add(new BigDecimal (3));

		// user digit input applied
		System.out.println(pi);
		pi = pi.setScale(size,  BigDecimal.ROUND_HALF_UP);
		//System.out.println(pi);
		pi =  BigDecimal.ZERO;
	}
		
}
