package section_12_algorithms_recursion;

public class Factorial {
    public static void main(String[] args) {

        int n = 5;

        System.out.printf("Recursive: n = %d factorial = %d\n", n, findFactorialRecursive(n));
        System.out.printf("Iterative: n = %d factorial = %d\n", n, findFactorialIterative(n));
    }

    public static long findFactorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be less than zero.");
        }

        if (n == 0) {
            return 1;
        }

        return (long) n * findFactorialRecursive(n - 1);
    }

    public static long findFactorialIterative(int n) {
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= (long) i;
        }

        return factorial;
    }


}
