package problems.integer;

public class countPrime {

    // how many primes up to n
    public static void main(String[] args) {
        int n = 10;
        int prime = countPrime(n);
        System.out.print(prime);
    }

    private static int countPrime(int n) {
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {

        //no number is divisible by more than its half.
        for (int i = 2; i < n/2; i++) {
            // if number is divisble then not a prime
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
