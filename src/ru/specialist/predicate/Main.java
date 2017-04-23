package ru.specialist.predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tigra on 23.04.17.
 */
public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan", 33));
        persons.add(new Person("Mary", 25));
        persons.add(new Person("Pedro", 30));
        persons.add(new Person("Dasha", 31));
        persons.add(new Person("Semen", 33));

//        for (Person person: persons) {
//            System.out.println(person);
//        }

        persons.stream().
//                filter(person -> person.getAge() > 30).
                sorted((person1, person2) -> person1.getName().compareTo(person2.getName())).
                sorted((person1, person2) -> person1.getAge() - person2.getAge()).
                forEach(System.out::println);
    }
}
