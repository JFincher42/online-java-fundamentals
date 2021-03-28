package tutorials;


interface FuncInterface {
    int operation(int a, int b);
}

class LambdaExample {
    private int operate(int a, int b, FuncInterface fobj)  {
        return fobj.operation(a, b);
    }
    public static void main(String args[]) {
        FuncInterface add = (int x, int y) -> x + y;
        FuncInterface multiply = (int x, int y) -> x * y;
        LambdaExample obj = new LambdaExample();

        // Add two numbers using lambda expression
        System.out.println("Addition is " + obj.operate(6, 3, add));

        // Multiply two numbers using lambda expression
        System.out.println("Multiplication is " + obj.operate(6, 3, multiply));
    }

}
