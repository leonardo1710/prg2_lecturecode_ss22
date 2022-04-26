package at.ac.fhcampuswien.advanced.exceptions;

import java.io.IOException;

/**
 * Unchecked exceptions are not checked at compile time.
 * It means if your program is throwing an unchecked exception and even if you didn’t handle/declare that exception,
 * the program won’t give a compilation error. Most of the times these exception occurs due to the bad data provided
 * by user during the user-program interaction. It is up to the programmer to judge the conditions in advance,
 * that can cause such exceptions and handle them appropriately.
 * All Unchecked exceptions are direct sub classes of RuntimeException class.
 */
public class UncheckedExceptions {
    public static void main(String[] args) {
        divide(10, 0);
    }

    private static void uncheckedExample(){
        throw new ArithmeticException();
    }

    private static double divide(double dividend, double divisor) {
        if(divisor == 0) {
            throw new ArithmeticException("divisor not valid");
        }else {
            System.out.println("Result: " + dividend/divisor);
            return dividend/divisor;
        }
    }

    private static void exceptionExample1(){
        try{
            int[] myArr = new int[3];
            int myElement = myArr[3];   // throws an ArrayOutOfBounds exception
        }catch(Exception e){
            System.out.println("Catch block is executed");
            System.out.println(e);
        }

        try{
            int x = 10/0;   // throws an ArithmeticException and is not handled with catch
        }finally {
            System.out.println("Finally block is executed");
        }
    }

    private static void multiCatchExample(){
        try{
            int[] a = new int[5];
            a[5] = 30/0; // 30/2
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        } catch(Exception e) {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");
    }
}
