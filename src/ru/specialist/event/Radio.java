package ru.specialist.event;

/**
 * Created by tigra on 22.04.17.
 */
public class Radio implements ElectricityConsumer {
    public void radioOn() {
        System.out.println("Radio is ON");
    }

    @Override
    public void electricityOn(Object sender) {
        radioOn();
    }
}
