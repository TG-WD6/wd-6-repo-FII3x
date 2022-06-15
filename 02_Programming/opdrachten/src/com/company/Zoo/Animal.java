package com.company.Zoo;

import java.time.LocalDate;

public class Animal {
    public String Name;
    public String environment;
    protected int Feed; // for each day

    protected LocalDate BirthDate;

    @Override
    public String toString() {
        var x = this.getClass().getName().split("\\.");
        return Name + " " + x[x.length-1];
    }
}

