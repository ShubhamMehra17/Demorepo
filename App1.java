package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class App1 {
    public static void main(String[] args) {

        ArrayList<Employee> arrayList = new ArrayList<>();

        Employee emp1 = new Employee("Akhil",1004,"FrontEnd Dev");
        Employee emp2 = new Employee("Rohan",1201,"Software Dev");
        Employee emp3 = new Employee("Babita",1251,"Hr Executive");
        Employee emp4 = new Employee("Anubhuti",1545,"Devops Engineer");

        arrayList.add(emp1);
        arrayList.add(emp2);
        arrayList.add(emp3);
        arrayList.add(emp4);

        Collections.sort(arrayList,new SortByName());
        System.out.println(arrayList);

    }

}
