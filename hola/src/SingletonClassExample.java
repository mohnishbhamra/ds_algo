import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonClassExample {
    private static SingleInnerClass singleInnerClassObject = new SingleInnerClass();

    private static class SingleInnerClass{
        private Map<Integer,String> map;
        public  SingleInnerClass(){
            //load data into map
            //loading time takes some long duration
            System.out.println("test");
            map = new ConcurrentHashMap<>();
        }

        public String insert(Integer empid, String details){
            map.put(empid,details);
            return details;
        }
        public String getDetails(Integer empid){
            return map.get(empid);
        }
    }
     /* public SingletonClassExample(){

        if(singleInnerClassObject == null){
            singleInnerClassObject = new SingleInnerClass();
        }
    }*/

    public String getSingletonClassExampleObject(Integer empid){
        return singleInnerClassObject.getDetails(empid);
    }

    public static void main(String arg[]){
        System.out.println("VOID MAIN");
        SingletonClassExample SingletonClassExampleObject = new SingletonClassExample();
//        SingleInnerClass SingleInnerClassObject = SingletonClassExampleObject.getSingletonClassExampleObject();
        SingletonClassExample SingletonClassExampleObject2 = new SingletonClassExample();
//        SingleInnerClass SingleInnerClassObject2 = SingletonClassExampleObject2.getSingletonClassExampleObject();



    }
}


//500000 lackh employees
//employee String name,String Address, Interger - DOB
//32+ 10*16 + 100*16 = 1792 * 500000
// 896,000,000 bits storage needed for just emp
//112,000,000 byte - 109,375 KB data 106Mb data