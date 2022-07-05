package com.company.airport.entity;

import com.company.airport.csv.CSVRow;

import java.util.ArrayList;

//"id","ident","type","name","latitude_deg","longitude_deg","elevation_ft","continent","iso_country","iso_region","municipality","scheduled_service","gps_code","iata_code","local_code","home_link","wikipedia_link","keywords"
//6523,"00A","heliport","Total Rf Heliport",40.07080078125,-74.93360137939453,11,"NA","US","US-PA","Bensalem","no","00A",,"00A",,,
public class Airport {
    public int id;
    public String identifier;
    public String type;
    public String name;
    public String lat;
    public String lon;
    public String elevation_ft;
    public String continent;
    public String iso_country;
    public String iso_region;
    public String municipality;
    public String scheduledService;
    public String gpsCode;
    public String iataCode;
    public String localCode;
    public String homeLink;

    public ArrayList<Runway> runways = new ArrayList<>();

    public Airport(CSVRow row) {
        var irow = row.iterator();
        id = irow.convert(CSVRow.ConvertInt);
        identifier = irow.get();
        type = irow.get();
        name = irow.get();
        lat = irow.get();
        lon = irow.get();
        elevation_ft = irow.get();
        continent = irow.get();
        iso_country = irow.get();
        iso_region = irow.get();
        municipality = irow.get();
        scheduledService = irow.get();
        gpsCode = irow.get();
        iataCode = irow.get();
        localCode = irow.get();
        homeLink = irow.get();
    }
}


