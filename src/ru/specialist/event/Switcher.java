package ru.specialist.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tigra on 22.04.17.
 */
public class Switcher {
    private List<ElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricityListener(ElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener(ElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {

        System.out.println("Switcher is ON");
        for (ElectricityConsumer consumer : listeners) {
            consumer.electricityOn(this);
        }
    }
}
