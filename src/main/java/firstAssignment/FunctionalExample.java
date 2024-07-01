package firstAssignment;
import io.vavr.collection.List;

import java.util.function.Function;


public class FunctionalExample {
    public static void main(String[] args) {

        List<Person> people = createPeopleList();
        List<Person> adults = filterAdults(people);
        adults = sortByName(adults);
        List<String> names = collectNames(adults);


        if (!names.isEmpty()) {
            printNames(names);
        } else {
            System.out.println(" There is no names :( ");
        }

    }

    private static List<Person> createPeopleList() {
        return  List.of(
                new Person("Alice", 23),
                new Person("Bob", 17),
                new Person("Charlie", 20),
                new Person("David", 15),
                new Person("Eve", 19)
        );
    }

    private static List<Person> filterAdults(List<Person>people){
        return people.filter(
              person -> person.getAge() >= 18);
    }

    private  static List<Person> sortByName(List<Person> people){
        return people.sorted((elm1,elm2) -> elm1.getName().compareTo(elm2.getName()));
    }

    private static  List<String> collectNames(List<Person> people){
        return people.map(Person::getName);
    }
    private static void printNames (List<String> names){
    names.forEach(System.out::println);
    }
}