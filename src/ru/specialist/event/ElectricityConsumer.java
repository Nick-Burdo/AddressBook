package ru.specialist.event;

/**
 * Created by tigra on 22.04.17.
 */

@FunctionalInterface
public interface ElectricityConsumer {
    void electricityOn(Object sender);
}
