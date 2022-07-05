package com.company.airport.csv;

import java.util.ArrayList;

public class CSVRow {
    public String[] values;
    public ArrayList<String> errors;
    public int index;

    public CSVRow(String[] values, int index) {
        this.values = values;
        this.index = index;
        errors = new ArrayList<>();
    }

    public RowIterator iterator() {
        return new RowIterator(this);
    }

    public String get(int index) {
        if (values.length > index)
            return values[index];
        return null;
    }

    public <T> T convert(int index, Converter<T> converter) {
        return convert(index, converter, null);
    }

    public <T> T convert(int index, Converter<T> converter, String err) {
        var value = get(index);
        var result = converter.convert(value);
        if (err != null && result == null) {
            errors.add(err.replace("[val]", value));
        }
        return result;
    }

    public static Converter<Double> ConvertDouble = (String val) -> {
        if (val.length() == 0)
            return null;
        return Double.parseDouble(val);
    };

    public static Converter<Integer> ConvertInt = (String val) -> {
        if (val.length() == 0)
            return null;
        return Integer.parseInt(val);
    };

    @Override
    public String toString() {
        return String.join(",", values);
    }
}
