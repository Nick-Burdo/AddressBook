package ru.specialiast.event;

/**
 * Created by tigra on 22.04.17.
 */
public class Lamp implements ElectricityConsumer {
    public void lampOn() {
        System.out.println("Lamp is ON");
    }

    @Override
    public void electricityOn() {
        lampOn();
    }
}
