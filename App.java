package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {


        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String s = localDate.format(dateTimeFormatter);

        System.out.println(localDate.isLeapYear());
        System.out.println(localDate.getDayOfWeek());
        System.out.println( localDate.getDayOfYear());

        String s2 = "$2000";
        String numericValue = s2.substring(1);
        int number = Integer.parseInt(numericValue);
        number+=1;
        String s3 = "$"+number;
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("$"+number);

       System.out.println(isLeapYear(2024));

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        ArrayList<Integer> arraylist = new ArrayList<>();
        arraylist.add(a);
        arraylist.add(12);
        arraylist.add(15);
        arraylist.add(16);
        arraylist.add(10);
        System.out.println(arraylist.contains(10));

    }

    static String isLeapYear(int year){
        if(year%4==0&&year%100!=0||year%400==0){

            return year+" is a leap year";
        }else{
            return year+" is not a leap year";
        }

}

}
