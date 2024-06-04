package org.example.Dao;

import org.example.Utility;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

import static org.example.Dao.BusDataDao.updatingInBusRecord;
import static org.example.Dao.TicketDao.generateTicket;

public class PassengerDao {


    public static class operations {


        private static Scanner in = new Scanner(System.in);
        private static Connection connection;


        static {
            try {
                connection = Utility.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        public static void bookSeat() throws SQLException {


            try {
                showBus();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            int busRoute = 0;
            String busSource = null;
            String busDestination = null;

            while (true) {

                System.out.print("Choose A Bus Route : ");
                busRoute = in.nextInt();

                PreparedStatement preparedStatement = connection.prepareStatement("Select * from buses where BUSROUTE = ?");
                preparedStatement.setInt(1, busRoute);

                ResultSet rst = preparedStatement.executeQuery();

                while (rst.next()) {
                    busSource = rst.getString("BUS_SOURCE");
                    busDestination = rst.getString("BUS_DESTINATION");
                }
                if (busSource == null && busDestination == null) {
                    System.out.println("Please Enter A Valid Route No...");
                } else {
                    break;
                }

            }

            in.nextLine();
            System.out.println("Starting Point    : " + busSource);
            System.out.println("Destination Point : " + busDestination);

            System.out.print("Enter your name : ");
            String passengerName = in.nextLine().trim();
            System.out.print("Enter Your Email : ");
            String passengerEmail = in.nextLine().trim();
            System.out.print("Enter Your Age : ");
            int passengerAge = Integer.parseInt(in.nextLine());
            System.out.print("Enter Your Contact No : ");
            String passengerContact = in.nextLine().trim();

            System.out.println("Enter Your Booking Date : dd/MM/yyyy");
            String dateStr = in.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate pDateOfBooking = LocalDate.parse(dateStr, formatter);
            Date sqlDate = Date.valueOf(pDateOfBooking);

            LocalDateTime datebooked = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(datebooked);


            printSeats(sqlDate, busRoute);
            int seatNo = 0;

            while (true) {
                System.out.print("Please Select A Seat No : ");
                seatNo = in.nextInt();


                while (seatNo > 30 || seatNo <= 0) {
                    System.out.println("Please Enter A Valid Seat No. ");
                    seatNo = in.nextInt();
                }

                PreparedStatement preparedStatement = connection.prepareStatement("select * from passengersdata where SEAT_NO=? And Bus_Route = ? And PASSENGER_DATEOFBOOKING=?");
                preparedStatement.setInt(1, seatNo);
                preparedStatement.setInt(2, busRoute);
                preparedStatement.setDate(3, sqlDate);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {

                    break;
                }

            }

            updatingInBusRecord(sqlDate, busRoute,connection);

            int ticketno = generateTicket(busRoute, connection);

            PreparedStatement savingpasssenger = connection.prepareStatement("INSERT INTO PASSENGERSDATA( PASSENGER_NAME, PASSENGER_EMAIL,PASSENGER_AGE, PASSENGER_CONTACT,PASSENGER_DATEOFBOOKING, PASSENGER_DATEBOOKED,TICKET_ID,SEAT_NO,Bus_Route) VALUES" +
                    "(? ,? ,? ,? ,? , ?, ?,?,?) ");
            savingpasssenger.setString(1, passengerName);
            savingpasssenger.setString(2, passengerEmail);
            savingpasssenger.setInt(3, passengerAge);
            savingpasssenger.setString(4, passengerContact);
            savingpasssenger.setDate(5, sqlDate);
            savingpasssenger.setTimestamp(6, timestamp);
            savingpasssenger.setInt(8, seatNo);
            savingpasssenger.setInt(9, busRoute);


            PreparedStatement ticketIdFetching = connection.prepareStatement("select * from tickets where TICKET_NO = ?");
            ticketIdFetching.setInt(1, ticketno);
            ResultSet rst1 = ticketIdFetching.executeQuery();
            int ticketId = 0;
            while (rst1.next()) {
                ticketId = rst1.getInt("ticket_id");
            }

            if (ticketno != 0) {
                savingpasssenger.setInt(7, ticketId);
                int passengersaved = savingpasssenger.executeUpdate();

                System.out.print("Please Wait");
                try {
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(500);
                        System.out.print(".");
                    }
                } catch (Exception e) {
                    e.getMessage();
                }


                System.out.println();
                System.out.println("============== Booking Confirmed On Date : " + pDateOfBooking + " =============");
                System.out.println("==================== Your Ticket Id : " + ticketId + " ===================");
                System.out.println("========================== Happy Journey ==========================");
                System.out.println("===================================================================");
            } else {
                System.out.println("Booking failed...");
            }
        }


        public static void showBus() throws SQLException {


            Connection connection = Utility.getConnection();

            Statement stmt = connection.createStatement();
            ResultSet rst = stmt.executeQuery("select * from buses");


            System.out.println("========================== Bus Details ============================");

            while (rst.next()) {
                int busId = rst.getInt("BUSID");
                String busNo = rst.getString("BUSNO");
                String busroute = rst.getString("BUSROUTE");
                String busSource = rst.getString("BUS_SOURCE");
                String busDestination = rst.getString("BUS_DESTINATION");
                int busCapacity = rst.getInt("BUS_CAPACITY");
                LocalTime busStartTime = rst.getTime("BUS_TIME").toLocalTime();
                int ticketPrice = rst.getInt("TICKET_PRICE");

                System.out.println("Bus No                  : " + busNo);
                System.out.println("Bus Route               : " + busroute);
                System.out.println("Bus Timing              : " + busStartTime);
                System.out.println("Bus Capacity            : " + busCapacity);
                System.out.println("Ticket Price            : " + ticketPrice);
                System.out.println("Bus Source-Point        : " + busSource);
                System.out.println("Bus Destination-Point   : " + busDestination);

                System.out.println("===================================================================");
                System.out.println();

            }


        }


        public static void printSeats(Date date, int busroute) {
            Date sqlDate = date;
            int busRoute = busroute;

            System.out.println(" Seats :  1   2   3   4   5   6   7   8   9  10");
            System.out.println("       : 11  12  13  14  15  16  17  18  19  20");
            System.out.println("       : 21  22  23  24  25  26  27  28  29  30");

            System.out.println();
            System.out.println("Booked Seats : ");
            try {

                PreparedStatement preparedStatement = connection.prepareStatement("Select SEAT_NO FROM PASSENGERSDATA  WHERE PASSENGER_DATEOFBOOKING=? and  Bus_Route=?");

                preparedStatement.setDate(1, sqlDate);
                preparedStatement.setInt(2, busRoute);

                ResultSet resultSet = preparedStatement.executeQuery();
                int count = 0;

                while (resultSet.next()) {

                    int bookedSeats = resultSet.getInt("SEAT_NO");
                    if (count == 10) {
                        System.out.println();
                    }
                    if (count == 20) {
                        System.out.println();
                    }
                    count++;
                    System.out.print(bookedSeats + " ");

                }
                System.out.println();

            } catch (Exception e) {
                e.getMessage();
            }

        }

    }
}
