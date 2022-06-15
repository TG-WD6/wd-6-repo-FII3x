package com.company.Forrest;

public class Bear extends ForrestAnimal {
    public Type type; //grizly bear || black bear
    public enum Type { Grizzly, Black }

    public int feed(ForrestAnimal prey) {
        System.out.println ("Bear is feeding on prey. species" + prey);
        return energy;
    }

    @Override
    public void fightAnimal(ForrestAnimal animal) {}

    @Override
    public void sleep() {
        energy = 100;
    }

    public Bear(Type type) {
        super(type.toString());
        this.type = type;
    }

    public void PrintType() {
        System.out.println(this.getClass().getName() + " " + this.getClass().getSuperclass().getName());
    }
}