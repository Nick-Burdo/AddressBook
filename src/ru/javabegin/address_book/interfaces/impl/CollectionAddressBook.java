package ru.javabegin.address_book.interfaces.impl;

import ru.javabegin.address_book.interfaces.AddressBook;
import ru.javabegin.address_book.objects.Person;

import java.util.ArrayList;

/**
 * Created by tigra on 09.04.17.
 */
public class CollectionAddressBook implements AddressBook {
    private ArrayList<Person> personList = new ArrayList<>();

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

    public ArrayList<Person> getPersonList() {
        return personList;
    }
}
