package com.company.annotations;

public enum Weekday {
    MONDAY(true),
    TUESDAY(true),
    WEDNESDAY(true),
    THURSDAY(true),
    FRIDAY(true) ,
    SATURDAY(false),
    SUNDAY(false),
    ;

    public final boolean workday;

    Weekday(boolean workday) {
        this.workday = workday;
    }

    @Override
    public String toString() {
        return "Weekday: " + this.name() + (workday ? " Go to work" : " Stay home and play with your pet");
    }

    @Buggy(priority = Priority.HIGH, severity = Severity.ZERODAY) // definitely!!
    public static void run() {
        for (var x : Weekday.values())
            System.out.println(x);
    }
}
