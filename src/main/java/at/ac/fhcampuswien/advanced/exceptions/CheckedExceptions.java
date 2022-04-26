package at.ac.fhcampuswien.advanced.exceptions;

import java.io.*;

/**
 * Checked exceptions are checked at compile-time.
 * It means if a method is throwing a checked exception then it should handle
 * the exception using try-catch block or it should declare the exception
 * using throws keyword, otherwise the program will give a compilation error.
 */
public class CheckedExceptions {

    public static void main(String args[]) {

        try{
            Currency currency = new Currency("EUR");    // valid
            Currency currency2 = new Currency("GBP");   // not allowed
        }catch (InvalidCurrencyException e){
            System.out.println(e.getMessage());
        }

        function1();
        try {
            readFile("mytextfile.txt");
        } catch (FileNotFoundException e){
            System.out.println("file could not be found.");
        } catch (IOException e) {
            System.out.println("i/o problem occurred.");
        }

        System.out.println("Continue with program");
    }

    public static String readFile(String filename) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(filename); // may throw a FileNotFoundException
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        StringBuilder content = new StringBuilder();
        String strCurrentLine;
        while ((strCurrentLine = br.readLine()) != null) {  // may throw an IOException
            content.append(strCurrentLine);
        }
        fis.close();    // may throw a IOException
        return content.toString();
    }

    /*
    public static void main(String args[]) {
        try{
            checkedExample();
        } catch (IOException e){
            // catching logic
        }

        // throws FileNotFoundException that must be handled
        FileInputStream fis = new FileInputStream("mytextfile.txt");


        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        readFileLineByLine("textfile.txt");
    }

     */

    private static void checkedExample() throws IOException{
        throw new IOException();
    }

    public static void readFileLineByLine(String filename){
        /*
        FileInputStream fis;

        // Open the file
        // This constructor FileInputStream(File filename)
        // throws FileNotFoundException which is a checked
        // exception
        fis = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;

        //Read File Line By Line
        // Method readLine() of BufferedReader class also throws
        // a checked exception: IOException
        while ((line = br.readLine()) != null)   {
            // Print the content on the console
            System.out.println(line);
        }

        //Close the input stream
        // The method close() closes the file input stream
        // It throws IOException
        fis.close();
        */
    }

    private static void function1(){
        try{
            function2();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Another exception..");
        }
        System.out.println("Normal flow..");
    }

    private static void function2() throws IOException {
        function3();
    }

    private static void function3() throws IOException {
        throw new IOException("Some file could not be found");
    }

}
