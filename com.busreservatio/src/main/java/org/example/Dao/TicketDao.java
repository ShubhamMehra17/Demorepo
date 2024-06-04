package org.example.Dao;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;

import static org.example.Utility.getConnection;

public class TicketDao {
    private static int ticketNo;

    private static Connection connection;

    static {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean ticketStatus;
    private static Scanner in = new Scanner(System.in);

    public static int generateTicket(int busRouteNo, Connection connection) throws SQLException {
        int busroute = busRouteNo;
        PreparedStatement preparedStatement2 = connection.prepareStatement("Select * from buses where BUSROUTE = ?");
        preparedStatement2.setInt(1, busroute);

        ResultSet rst = preparedStatement2.executeQuery();


        String busSource = null;
        String busDestination = null;
        String busno = null;
        while (rst.next()) {
            busSource = rst.getString("BUS_SOURCE");
            busDestination = rst.getString("BUS_DESTINATION");
            busno = rst.getString("BUSNO");
        }

        Random random = new Random();
        int randomNo = random.nextInt(200) + 1;
        int randomno = random.nextInt(200) + 1;

        ticketNo = busroute + randomNo + 2 * randomno + 101;
        ticketStatus = true;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TICKETS(BUS_NO,BUS_ROUTE,SOURCE,DESTINATION,ticket_no,TICKET_STATUS)" +
                "VALUES(?,?,?,?,?,?)");
        preparedStatement.setString(1, busno);
        preparedStatement.setInt(2, busroute);

        preparedStatement.setString(3, busSource);
        preparedStatement.setString(4, busDestination);
        preparedStatement.setInt(5, ticketNo);
        preparedStatement.setBoolean(6, ticketStatus);

        int ticketgenerated = preparedStatement.executeUpdate();

        if (ticketgenerated != 0) {
            return ticketNo;
        }
        return 0;
    }


    public static void cancleTickets() {
        System.out.println("===================================================================");

        System.out.print("Enter Your Ticket Id : ");
        int ticketId = in.nextInt();


        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement("Select * from tickets where ticket_id=?");
            preparedStatement1.setInt(1, ticketId);
            ResultSet rst = preparedStatement1.executeQuery();

            boolean ticketCheck;
            while (rst.next()) {
                ticketCheck = rst.getBoolean("TICKET_STATUS");

                if (ticketCheck == true) {


                    PreparedStatement preparedStatement = connection.prepareStatement("Update TICKETS SET TICKET_STATUS=FALSE WHERE ticket_id=?");
                    preparedStatement.setInt(1, ticketId);
                    int cancledTicket = preparedStatement.executeUpdate();

                    if (cancledTicket > 0) {
                        System.out.println("Ticket Is Cancelled Successfully For Ticket No : " + ticketId);
                    } else {
                        System.out.println("Failed To Cancle Your Ticket");
                    }
                    System.out.println("===================================================================");

                } else {
                    System.out.println("Your Ticket Is Already Cancelled..");

                    System.out.println("===================================================================");
                }
            }


        } catch (SQLException e) {
            e.getMessage();
        }
    }


    public static void viewTickets() {

        System.out.println("===================================================================");
        System.out.println("Enter Your Ticket Id : ");
        int ticketId = in.nextInt();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tickets t, passengersdata p WHERE t.TICKET_ID = p.TICKET_ID AND t.TICKET_ID = ?");
            preparedStatement.setInt(1, ticketId);
            ResultSet rst = preparedStatement.executeQuery();


            while (rst.next()) {

                int ticktNo = rst.getInt("TICKET_NO");
                int busRoute = rst.getInt("BUS_ROUTE");
                boolean ticketStatus = rst.getBoolean("TICKET_STATUS");
                String source = rst.getString("SOURCE");
                String destination = rst.getString("DESTINATION");

                String passengerName = rst.getString("PASSENGER_NAME");
                String passengerEmail = rst.getString("PASSENGER_EMAIL");
                int passengerAge = rst.getInt("PASSENGER_AGE");
                Date bookingDate = rst.getDate("PASSENGER_DATEOFBOOKING");
                int seatNo = rst.getInt("SEAT_NO");

                in.nextLine();

                System.out.println("=========================== Trip Details =============================");
                System.out.println("            Passenger Name        : " + passengerName);
                System.out.println("            Passenger Email       : " + passengerEmail);
                System.out.println("            Passenger Age         : " + passengerAge);
                System.out.println("            Source                : " + source);
                System.out.println("            Destination           : " + destination);
                System.out.println("            Bus Route             : " + busRoute);
                System.out.println("            Ticket No             : " + ticktNo);
                System.out.println("            Seat no               : " + seatNo);
                System.out.println("            Booking Date          : " + bookingDate);
                if (ticketStatus == true) {
                    System.out.println("            Ticket Status         : Booked ");
                } else {
                    System.out.println("            Ticket Status         : Cancelled ");
                }


                System.out.println("===================================================================");


            }

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
