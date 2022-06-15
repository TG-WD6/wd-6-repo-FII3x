package com.company.Forrest;

public abstract class ForrestAnimal {
    public boolean wounded = false;
    public boolean dead = false;
    public int energy;

    private String name;
    public String getName() {
        return name;
    }

    public String species;

    public abstract void fightAnimal(ForrestAnimal animal) ;
    public abstract void sleep();

    public ForrestAnimal(String species) {
        System.out.println("An animal has entered the forest");
        this.species = species;
    }
}
