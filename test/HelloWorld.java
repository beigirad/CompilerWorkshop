public class HelloWorld {
    static int age = 10;
    private static double height = 1.74;
    public double weight = (((74.02 - 75.549)));

    public static int action(int a, int b, boolean sum) {
        if (sum)
            return a + b; //sum
        else
            return a - b;
    }

    private static double myFunc2(double b, int c) {
        if (true) {
            b = b + (2 - 6);
        } else {

        }
        if (c < 2 * b) {
            b = 8 * 2;
        } else {
            c = 0;
        }
        return b / c;
    }

    public static void doSth() {
        Integer a = 0;
        while (a < 200) {
            a = a + 5;
        }

        // call methods
        double result = Test.myFunc2(5, 10);
    }
}
