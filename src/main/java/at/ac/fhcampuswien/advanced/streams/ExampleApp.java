package at.ac.fhcampuswien.advanced.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleApp {

    public static void main(String[] args) {
        Employee[] arrayOfEmps = {
                new Employee(1, "Bart Simpson", 100.10),
                new Employee(2, "Lisa Simpson", 9999.99),
                new Employee(3, "Homer Simpson", 3002.00)
        };

        Stream<Employee> streamFromArray = Stream.of(arrayOfEmps);  // declare stream from array

        List<Employee> employeesList = Arrays.asList(arrayOfEmps);
        Stream<Employee> streamFromList = employeesList.stream();   // declare stream from list

        streamFromList
                .filter( employee -> employee.getSalary() > 300.00)
                .forEach( employee -> System.out.println(employee.getName()));


        Employee employee = employeesList.stream()
                .filter( e -> e != null)
                .filter( e -> e.getSalary() > 300.00)
                .findFirst()
                .orElse(null);

        System.out.println(employee.getName());

        List<Employee> employees = employeesList.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());

        for( Employee e : employees){
            System.out.println(e.getName());
        }
    }
}
