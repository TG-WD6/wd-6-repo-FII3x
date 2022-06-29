package com.company.Forrest;

public class Rabbit extends ForrestAnimal implements Carnivore {

    public Rabbit() {
        super("rabbit");
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

    }
}
