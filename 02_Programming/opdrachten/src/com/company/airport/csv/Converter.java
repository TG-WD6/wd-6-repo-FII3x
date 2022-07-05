package com.company.airport.csv;

public interface Converter<T> {
    T convert(String str);
}
