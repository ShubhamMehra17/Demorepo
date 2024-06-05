package org.example.Dao;

import org.example.Utility;

import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BusDao {

    private static Connection connection;
    private static Scanner in = new Scanner(System.in);

    public static void addBus() {
        try {
            connection = Utility.getConnection();

            Scanner in = new Scanner(System.in);

            System.out.print("Enter Bus No : ");
            String busNO = in.nextLine();


            System.out.print("Enter Bus Route No : ");
            int busRoute = in.nextInt();



            while (true) {


                PreparedStatement preparedStatement1 = connection.prepareStatement("select * from buses where BUSROUTE=?");
                preparedStatement1.setInt(1, busRoute);
                ResultSet rst = preparedStatement1.executeQuery();
                if (!rst.next()) {

                    System.out.print("Enter Ticket Price  : ");
                    int ticketPrice = in.nextInt();
                    in.nextLine();
                    System.out.print("Enter Bus Start Time (HH:mm:ss): ");
                    String busTime = in.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime localTime = LocalTime.parse(busTime, formatter);

                    Time time = Time.valueOf(localTime);

                    System.out.print("Enter Starting Point : ");
                    String busSource = in.nextLine();

                    System.out.print("Enter Destination Point :");
                    String busDestination = in.nextLine();

                    System.out.print("Enter Seating Capacity : ");
                    int seatingCapacity = in.nextInt();
                    System.out.println("Please Wait");
                    try {
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }

                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BUSES ( BUSNO, BUSROUTE, BUS_SOURCE, BUS_DESTINATION, BUS_TIME, BUS_CAPACITY, TICKET_PRICE)" +
                            "VALUES (?,?,?,?,?,?,?)");
                    preparedStatement.setString(1, busNO);
                    preparedStatement.setInt(2, busRoute);
                    preparedStatement.setString(3, busSource);
                    preparedStatement.setString(4, busDestination);
                    preparedStatement.setTime(5, time);
                    preparedStatement.setInt(6, seatingCapacity);
                    preparedStatement.setInt(7, ticketPrice);

                    int savedBus = preparedStatement.executeUpdate();
                    if (savedBus > 0) {
                        System.out.println("Bus saved successfully");
                        return;
                    } else {
                        System.out.println("Failed To Save Bus");
                        return;
                    }
                } else {
                    System.out.print("Please Enter A Different Route No ");
                    busRoute = in.nextInt();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void viewBuses() {
        System.out.println("===================================================================");
        try {
            connection = Utility.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BUSES ");
            ResultSet rst = preparedStatement.executeQuery();

            while (rst.next()) {
                String busNo = rst.getString("BUSNO");
                int busRoute = rst.getInt("BUSROUTE");
                String busSource = rst.getString("BUS_SOURCE");
                String busDestination = rst.getString("BUS_DESTINATION");
                int busCapacity = rst.getInt("BUS_CAPACITY");
                Time busTime = rst.getTime("BUS_TIME");
                int ticketPrice = rst.getInt("TICKET_PRICE");

                System.out.println("Bus No           : " + busNo);
                System.out.println("Bus Route        : " + busRoute);
                System.out.println("Bus Source       : " + busSource);
                System.out.println("Bus Destination  : " + busDestination);
                System.out.println("Bus Capacity     : " + busCapacity);
                System.out.println("Bus Time         : " + busTime);
                System.out.println("Bus Ticket price : " + ticketPrice);

                System.out.println("===================================================================");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteBus() {

        try {
            connection = Utility.getConnection();
            System.out.println("=============================================================================");
            System.out.println("Enter Bus Route No : ");
            int busRoute = in.nextInt();


            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM BUSES WHERE BUSROUTE=? ");
            preparedStatement1.setInt(1, busRoute);
            ResultSet rst1 = preparedStatement1.executeQuery();

            if (rst1.next()) {
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM BUSES WHERE BUSROUTE=? ");
                preparedStatement.setInt(1, busRoute);
                int busDeleted = preparedStatement.executeUpdate();
                if (busDeleted > 0) {
                    System.out.println("Bus Deletde Successfully.. ");
                } else {
                    System.out.println("Failed To Delete Bus...");
                    System.out.println("=============================================================================");
                }

            } else {
                System.out.println("No Bus Found For The Given Route No ");
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }


}
