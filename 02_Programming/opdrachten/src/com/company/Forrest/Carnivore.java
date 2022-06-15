package com.company.Forrest;

public interface Carnivore {
    int feed (ForrestAnimal prey);
    String getName();

    default void hunt(ForrestAnimal animal) {
        System.out.println(getName() + "is chasing "+ animal.getName());
    }
}
