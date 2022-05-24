package loose.oose.fis.lab.student.manager.bench;
import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DigitsOfPi2 {

        private static final BigDecimal TWO = new BigDecimal("2");
        private static final BigDecimal FOUR = new BigDecimal("4");
        private static final BigDecimal FIVE = new BigDecimal("5");
        private static final BigDecimal TWO_THIRTY_NINE = new BigDecimal("239");
        static int numDigits;

        private static BigDecimal arccot(BigDecimal x, int numDigits) {

            BigDecimal unity = BigDecimal.ONE.setScale(numDigits,
                    RoundingMode.DOWN);
            BigDecimal sum = unity.divide(x, RoundingMode.DOWN);
            BigDecimal xpower = new BigDecimal(sum.toString());
            BigDecimal term = null;

            boolean add = false;

            for (BigDecimal n = new BigDecimal("3"); term == null ||
                    term.compareTo(BigDecimal.ZERO) != 0; n = n.add(TWO)) {

                xpower = xpower.divide(x.pow(2), RoundingMode.DOWN);
                term = xpower.divide(n, RoundingMode.DOWN);
                sum = add ? sum.add(term) : sum.subtract(term);
                add = ! add;
            }
            return sum;
        }



            public static BigDecimal run() {

            int calcDigits = numDigits + 10;

            return FOUR.multiply((FOUR.multiply(arccot(FIVE, calcDigits)))
                            .subtract(arccot(TWO_THIRTY_NINE, calcDigits)))
                    .setScale(numDigits, RoundingMode.DOWN);

    }

    public void initialize(int size) {
        // TODO Auto-generated method stub
        this.numDigits = size;
    }

    public void clean() {
        // TODO Auto-generated method stub

    }

    public void cancel() {
        // TODO Auto-generated method stub

    }

    public void warmup() {
            DigitsOfPi2.run();
    }

}
