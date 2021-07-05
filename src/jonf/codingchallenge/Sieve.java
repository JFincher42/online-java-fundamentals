package jonf.codingchallenge;

import java.sql.Array;
import java.util.ArrayList;

public class Sieve {

    public static void main(String[] args) {
        sieve(11);
//        sieve(18);
        sieve2(11);
//        sieve2(18);
    }

    public static void sieve(int max)
    {
        ArrayList<Boolean> primes = new ArrayList<>();
        for (int i=0; i<max+1; i++) primes.add(true);

        for (int i=2; i<max+1; i++){
            if (primes.get(i)){
                if (i>2) System.out.print(", ");
                System.out.print(i);
                for (int j=i+i; j<max+1; j+=i)
                    primes.set(j, false);
            }
        }
        System.out.println();
    }

    public static void sieve2(int max)
    {
        ArrayList<Integer> nonprimes = new ArrayList<>();

        for (int i=2; i<max+1; i++){
            if (!nonprimes.contains(i)){
                if (i>2) System.out.print(", ");
                System.out.print(i);
                for (int j = i + i; j<max+1; j+=i)
                    if (!nonprimes.contains(j)) nonprimes.add(j);
            }
        }
        System.out.println();
    }
}
