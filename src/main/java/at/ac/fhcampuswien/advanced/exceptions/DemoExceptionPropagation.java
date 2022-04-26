package at.ac.fhcampuswien.advanced.exceptions;

public class DemoExceptionPropagation {

    public static void main(String[] args) {
        startDemo();
    }

    private static void startDemo(){
        System.out.println("Inside start Demo");
        try {
            function1();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static void function1(){
        System.out.println("Inside function 1");
        function2();
    }
    private static void function2(){
        System.out.println("Inside function 2");
        throw new NullPointerException("Throw an exception");
    }
}
