package ru.javabegin.address_book.objects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by tigra on 09.04.17.
 */
public class Person {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty phone = new SimpleStringProperty("");

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public Person(String name, String phone) {
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
    }
    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
