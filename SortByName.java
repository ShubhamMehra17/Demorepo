package org.example;

import java.util.Comparator;

public class SortByName implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.eName,o2.eName);
    }
}
