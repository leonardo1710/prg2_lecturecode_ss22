package at.ac.fhcampuswien.advanced.lambdas;

import java.awt.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        MyComparator myComparator1 = (a, b) -> { return a > b; };

        MyComparator myComparator2 = (a, b) -> a > b;

        System.out.println(myComparator1.compare(4, 3));
        System.out.println(myComparator2.compare(4, 3));
        System.out.println(myComparator1.compare(6, 9));

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
