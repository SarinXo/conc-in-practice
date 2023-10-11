package parallel_using;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Factorizer {

    // потокобезопасен. В нем нет переменных/данных,
    // которые могут быть использованы в разных потоках одновременно
    public List<BigInteger> factorize(long number) {
        List<BigInteger> factors = new ArrayList<>();

        for (int i=2; i<=sqrt(number); i++) {
            while (number % i  ==0) {
                factors.add(BigInteger.valueOf(i) );
                number/=i;
            }
        }
        if (number!=1) {
            factors.add(BigInteger.valueOf(number));
        }
        return factors;
    }

    private boolean isPrime(long number) {
        for (int i = 2; i <= sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
