package com.company.airport;

import com.company.airport.csv.CSVRow;
import com.company.airport.csv.Parser;

import java.io.FileReader;
import java.io.IOException;
import com.company.airport.entity.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Stream;

public class AirportProgram {
    public static void test() throws IOException {
        System.out.println("no arguments");
        run(new String[] {});
        System.out.println("Search for na (this is automatically capitalized)");
        run(new String[] {"na"});
        System.out.println("Search for brazil (becomes Brazil automatically)");
        run(new String[] {"brazil"});
        System.out.println("search for mex (search is case insensitiveve)");
        run(new String[] {"mex"});
    }

    public static void run(String[] args) throws IOException {
        var airportId = new HashMap<String, Airport>();
        var countryCode = new HashMap<String, Country>();
        var countryName = new HashMap<String, Country>();

        var countries = Parse("countries.csv")
                .skip(1)
                .map(Country::new)
                .peek(x -> countryCode.put(x.code, x))
                .peek(x -> countryName.put(x.name, x))
                .toList();

        var airports = Parse("airports.csv")
                .skip(1)
                .map(Airport::new)
                .peek(x -> airportId.put(x.identifier, x))
                .peek(x -> {
                    if (countryCode.containsKey(x.iso_country))
                        countryCode.get(x.iso_country).airports.add(x);
                })
                .toList();

        var runways = Parse("runways.csv")
                .skip(1)
                .map(Runway::new)
                .peek(x -> {
                    if (airportId.containsKey(x.airportIdentifier))
                        airportId.get(x.airportIdentifier).runways.add(x);
                })
                .toList();

        if (args.length == 1) {
            var name = args[0];
            Country country = null;
            var gcode = CountryCode(name);
            var gname = CountryName(name);
            if (countryCode.containsKey(gcode)) {
                country = countryCode.get(gcode);
            } else if (countryName.containsKey(gname)) {
                country = countryName.get(gname);
            } else {
                var match = 0;
                for (var x : countries) {
                    var m = match(name, x.name);
                    if (m > match) {
                        match = m;
                        country = x;
                    }
                }
            }
            if (country == null) {
                System.out.println("no such country found");
            }
            System.out.println(country.name + " -> " + country.airports.size());
        } else {
            var sorted = countries
                    .stream()
                    .sorted(Comparator.comparingInt(a -> a.airports.size()))
                    .toList();
            for (var x = 0; x < 10; x++) {
                var item = sorted.get(sorted.size()-1-x);
                System.out.println(item.name + " -> " + item.airports.size());
            }
        }
        System.out.println();
    }

    //@jens mischien moet je hier de / naar \\ veranderen voor windows
    public static String base = "/Users/alexander/github-classroom/TG-WD6/wd-6-repo-FII3x/02_Programming/opdrachten/src/com/company/airport/";
    public static Stream<CSVRow> Parse(String ext) throws IOException {
        return Arrays.stream(Parser.Parse(new FileReader(base + ext)));
    }

    public static int match(String a, String b) {
        var len = Math.min(a.length(), b.length());
        for (var x = 0; x < len; x++) {
            if (Character.toLowerCase(a.charAt(x)) != Character.toLowerCase(b.charAt(x)))
                return x;
        }
        return len-1;
    }

    public static String CountryCode(String s) {
        return s.toUpperCase();
    }

    public static String CountryName(String s) {
        return Character.toUpperCase(s.charAt(0))
               + s.substring(1).toLowerCase();
    }
}
