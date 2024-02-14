public class Main {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    public static int fibonacci(int n) {
        int firstValue = 0;
        int secondValue = 1;
        int newValue = 0;

        for (int i = 1; i < n; i++) {
            //System.out.println(firstValue);

            newValue = firstValue + secondValue;
            firstValue = secondValue;
            secondValue = newValue;
        }

        return firstValue;
    }
}
