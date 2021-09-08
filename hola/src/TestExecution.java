public class TestExecution {
    public static void main(String[] args) {
        int  x=3, y=5, z=10;
        int ans = ++z + y - y + z-- + z + x++;
        System.out.println(ans);


//        TestExecution obj = new TestExecution(n);
//        TestExecution obj2 = new TestExecution(n);
    }
    static int a = 10;
    static Integer n;
    int b = 5;
    int c;
    public TestExecution(Integer m) {
        System.out.println(a + ", " + b + ", " + c + ", " + n + ", " + m);
    }
    // Instance Block  
    {
        System.out.println("instance");
        b = 30;
        n = 20;
    }
    // Static Block  
    static
    {
        a = 60;
    }
}