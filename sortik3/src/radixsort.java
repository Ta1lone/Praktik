import java.math.BigInteger;
import java.util.List;

public class radixsort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        List<List<BigInteger>> pockets = new java.util.ArrayList<>();
        for (int d = 0; d < 10; d++) {
            pockets.add(new java.util.ArrayList<>());
        }

        BigInteger ten = BigInteger.TEN;
        BigInteger exp = BigInteger.ONE;

        for (int rank = 0; rank < 20; rank++) {
            for (BigInteger value : nums) {
                int index = value.divide(exp).remainder(ten).intValue();
                pockets.get(index).add(value);
            }

            nums.clear();
            for (int d = 0; d < 10; d++) {
                nums.addAll(pockets.get(d));
                pockets.get(d).clear();
            }

            exp = exp.multiply(ten);
        }
    }
}