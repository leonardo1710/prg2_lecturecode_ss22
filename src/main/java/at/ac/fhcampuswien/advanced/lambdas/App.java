package at.ac.fhcampuswien.advanced.lambdas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

public class App {
    public static int myFunc(int a, int b, MyOperation op){
        return op.operation(a, b);
    }

    public static void main(String[] args) {

        MyOperation addition = (a, b) -> a + b;

        System.out.println("Result addition: " + myFunc(10, 2, addition));
        MyOperation substraction = (a, b) -> a - b;

        System.out.println("Result substraction: " + myFunc(34, 2, substraction));

        //System.out.println(myComparator1.operation(4, 3));
        //System.out.println(myComparator2.operation(4, 3));
        //System.out.println(myComparator1.operation(6, 9));

        ArrayList<String> names = new ArrayList<>();
        names.add("Hugo");
        names.add("Anna");
        names.add("Udo");

        names.forEach( name -> System.out.println(name));       // print each name
        names.sort((current, next) -> current.compareTo(next)); // sort names
        names.sort(String::compareTo);  // even shorter with method reference call

        names.forEach( name -> System.out.println(name));

        Button b = new Button("Click Here");
        b.setBounds(50, 100, 80, 50);

        b.addActionListener(e -> System.out.println("Hello World!"));

        /*
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World!")
            }
        });
         */
    }
}
