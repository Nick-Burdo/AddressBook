package ru.javabegin.address_book.interfaces.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.javabegin.address_book.interfaces.AddressBook;
import ru.javabegin.address_book.objects.Person;

import java.util.ArrayList;

/**
 * Created by tigra on 09.04.17.
 */
public class CollectionAddressBook implements AddressBook {
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void edit(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void print() {
        int number = 1;
        for (Person person: personList) {
            System.out.println(number++ + ") name = " +person.getName() + "; phone = " + person.getPhone());
        }
    }

    public void fillTestData() {
        personList.add(new Person("Ivan","1234567"));
        personList.add(new Person("Semen","9990000"));
        personList.add(new Person("Nick","5556677"));
        personList.add(new Person("Peter","2222222"));
        personList.add(new Person("Andrey","7654321"));
    }

}
