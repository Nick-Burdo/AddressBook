package ru.specialiast.event;

/**
 * Created by tigra on 22.04.17.
 */
public class Programm {
    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        switcher.addElectricityListener(lamp);
        Radio radio = new Radio();
        switcher.addElectricityListener(radio);

        switcher.addElectricityListener(() -> System.out.println("FIRE"));

        switcher.switchOn();
    }
}
