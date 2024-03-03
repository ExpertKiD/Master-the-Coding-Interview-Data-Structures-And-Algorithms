package section_12_algorithms_recursion;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 8;

        System.out.printf("Recursive: n = %d Fibonacci = %d\n", n, fibonacciRecursive(n));
        System.out.printf("Iterative: n = %d Fibonacci = %d\n", n, fibonacciIterative(n));
    }

    public static int fibonacciIterative(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n cannot be less than orr equal to zero");
        }

        int a = 0, b = 1;

        int num = 0;

        if (n == 1) {
            return a;
        } else if (n == 2) {
            return b;
        } else {
            for (int i = 3; i <= n; i++) {
                num = a + b;
                System.out.printf("a = %d, b = %d, num = %d i=%d\n", a, b, num, i);
                a = b;
                b = num;
            }

            return num;
        }


    }

    public static int fibonacciRecursive(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);

    }
}
