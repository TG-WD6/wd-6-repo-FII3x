package com.company.Forrest;

public class Wolf extends ForrestAnimal implements Carnivore {
    public Wolf() {
        super("Wolf");
    }

    @Override
    public int feed(ForrestAnimal prey) {
        return -1;
    }

    @Override
    public void fightAnimal(ForrestAnimal animal) {

    }

    @Override
    public void sleep() {
        energy = 100;
    }
}
