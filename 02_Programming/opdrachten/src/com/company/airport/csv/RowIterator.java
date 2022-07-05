package com.company.airport.csv;

public class RowIterator {
    private CSVRow row;
    private int index = 0;

    public RowIterator(CSVRow row) {
        this.row = row;
    }

    public boolean Done() {
        return index >= row.values.length;
    }

    public String get() {
        return !Done() ? row.get(index++) : null;
    }

    public <T> T convert(Converter<T> convert) {
        return !Done() ? row.convert(index++, convert) : null;
    }
}
