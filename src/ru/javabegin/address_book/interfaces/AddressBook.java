package ru.javabegin.address_book.interfaces;

import ru.javabegin.address_book.objects.Person;

/**
 * Created by tigra on 09.04.17.
 */
public interface AddressBook {
    void add(Person person);

    void edit(Person person);

    void delete(Person person);
}
