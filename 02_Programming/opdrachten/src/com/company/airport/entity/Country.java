package com.company.airport.entity;

import com.company.airport.csv.CSVRow;

import java.util.ArrayList;

//"id","code","name","continent","wikipedia_link","keywords"
//302672,"AD","Andorra","EU","https://en.wikipedia.org/wiki/Andorra",
public class Country {
    public int id;
    public String code;
    public String name;
    public String continent;
    public String wikipedia;
    public String keywords;

    public ArrayList<Airport> airports = new ArrayList<Airport>();

    public Country(CSVRow row) {
        var irow = row.iterator();
        id = irow.convert(CSVRow.ConvertInt);
        code = irow.get();
        name = irow.get();
        continent = irow.get();
        wikipedia = irow.get();
        keywords = irow.get();
    }
}
