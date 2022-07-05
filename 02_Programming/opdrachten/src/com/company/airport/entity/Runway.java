package com.company.airport.entity;

import com.company.airport.csv.CSVRow;

//"id","airport_ref","airport_ident","length_ft","width_ft","surface","lighted","closed","le_ident","le_latitude_deg","le_longitude_deg","le_elevation_ft","le_heading_degT","le_displaced_threshold_ft","he_ident","he_latitude_deg","he_longitude_deg","he_elevation_ft","he_heading_degT","he_displaced_threshold_ft"
//253744,6802,"04W",2751,75,"ASPH-G",1,0,"06",46.0213,-92.9001,1021,66,190,"24",46.0244,-92.8902,1009,246,394
public class Runway {
    public int id;
    public String airportReference;
    public String airportIdentifier;
    public String length_ft;
    public String width_ft;
    public String surface;
    public String lighted;
    public String closed;
    public String le_ident;
    public String le_latitude_deg;
    public String le_longitude_deg;
    public String le_elevation_ft;
    public String le_heading_degT;
    public String le_displaced_threshold_ft;
    public String he_ident;
    public String he_latitude_deg;
    public String he_longitude_deg;
    public String he_elevation_ft;
    public String he_heading_degT;
    public String he_displaced_threshold_ft;

    public Runway(CSVRow row) {
        var irow = row.iterator();
        id = irow.convert(CSVRow.ConvertInt);
        airportReference = irow.get();
        airportIdentifier = irow.get();
        length_ft = irow.get();
        width_ft = irow.get();
        surface = irow.get();
        lighted = irow.get();
        closed = irow.get();
        le_ident = irow.get();
        le_latitude_deg = irow.get();
        le_longitude_deg = irow.get();
        le_elevation_ft = irow.get();
        le_heading_degT = irow.get();
        le_displaced_threshold_ft = irow.get();
        he_ident = irow.get();
        he_latitude_deg = irow.get();
        he_longitude_deg = irow.get();
        he_elevation_ft = irow.get();
        he_heading_degT = irow.get();
        he_displaced_threshold_ft = irow.get();
    }
}
