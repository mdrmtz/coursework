import java.util.ArrayList;
import java.util.List;

class SieveOfEratosthenes
{
    static final int MAX_SIZE = 10001;
    // isPrime[] : isPrime[i] is true if number is prime
    // prime[] : stores all prime number less than N
    // SPF[] that store smallest prime factor of number
    // [for Exp : smallest prime factor of '8' and '16'
    // is '2' so we put SPF[8] = 2 , SPF[16] = 2 ]
    static final List<Boolean> isPrime = new ArrayList<>(MAX_SIZE);
    static final List<Integer>prime = new ArrayList<>();
    static final List<Integer>SPF = new ArrayList<>(MAX_SIZE);

    // method generate all prime number less then N in O(n)
    public static List<Integer> getPrimes(int N)
    {
        // 0 and 1 are not prime
        isPrime.set(0, false);
        isPrime.set(1, false);

        // Fill rest of the entries
        for (int i=2; i<MAX_SIZE ; i++)
        {
            // If isPrime[i] == True then i is
            // prime number
            if (isPrime.get(i))
            {
                // put i into prime[] vector
                prime.add(i);

                // A prime number is its own smallest
                // prime factor
                SPF.set(i,i);
            }

            // Remove all multiples of  i*prime[j] which are
            // not prime by making isPrime[i*prime[j]] = false
            // and put smallest prime factor of i*Prime[j] as prime[j]
            // [for exp :let  i = 5, j = 0, prime[j] = 2 [ i*prime[j] = 10]
            // so the smallest prime factor of '10' is '2' that is prime[j] ]
            // this loop run only one time for number which are not prime
            for (int j=0; j < prime.size() && i*prime.get(j) < N && prime.get(j) <= SPF.get(i); j++) {
                isPrime.set(i*prime.get(j),false);

                // put smallest prime factor of i*prime[j]
                SPF.set(i*prime.get(j),prime.get(j)) ;
            }
        }

        return prime;
    }

    // Driver method
    public static void main(String[] args)
    {
        int N = 10001 ; // Must be less than MAX_SIZE

        // initializing isPrime and spf
        for (int i = 0; i < N; i++){
            isPrime.add(true);
            SPF.add(2);
        }


        List<Integer> primes = getPrimes(5).subList(0,3);

        for(Object p : primes) {
            System.out.print(p + " ");
        }
    }
}