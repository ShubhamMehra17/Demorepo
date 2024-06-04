package org.example;
import java.util.Scanner;
import static org.example.Service.BusService.*;
import static org.example.Service.Passenger.addPassenger;
import static org.example.Service.TicketService.*;

public class App {
    public static void main(String[] args) {
        main();
    }

    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("           Welcome To Bus Reservation System ");
        System.out.println("=======================================================");


        while (true) {
            System.out.println("1. For Admin ");
            System.out.println("2. For User ");
            System.out.println("3. For Exit ");
            int choice = Integer.parseInt(in.nextLine());

            if(choice==2){
            while (true) {
                System.out.println("1. Book A Ticket ");
                System.out.println("2. View Booked Tickets ");
                System.out.println("3. Cancel Tickets ");
                System.out.println("4. Exit ");
                System.out.print("Enter Your Choice : ");
                 choice = Integer.parseInt(in.nextLine());

                switch (choice) {

                    case 1:
                        try {
                            addPassenger();
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        break;

                    case 2:
                        viewTripDetails();
                        break;

                    case 3:
                        cancelBooking();
                        break;

                    case 4:
                        System.out.print("Exiting");
                        try {
                            for (int i = 0; i < 3; i++) {
                                Thread.sleep(400);
                                System.out.print(".");
                            }
                        } catch (Exception e) {
                            e.getMessage();
                        }
                        return;


                    default:
                        System.out.println("Enter A Valid Choice");
                        break;

                }
            }
        }else if(choice==1){


                while (true){
                    System.out.println("For Admin :");
                    System.out.println("1. Add Bus ");
                    System.out.println("2. View Buses ");
                    System.out.println("3. Delete Bus ");
                    System.out.println("4. Exit");
                    choice=in.nextInt();

                    switch (choice){
                        case 1:
                            addBusByAdmin();
                            break;

                        case 2:
                            viewBusesByAdmin();
                            break;

                        case 3:
                            deleteBusByAdmin();
                            break;


                        case 4:
                            System.out.print("Exiting");
                            try {
                                for (int i = 0; i < 3; i++) {
                                    Thread.sleep(400);
                                    System.out.print(".");
                                }
                            } catch (Exception e) {
                                e.getMessage();
                            }
                            return;

                        default:
                            System.out.println("Enter A Valid Choice");
                    }
                }
            } else if (choice==3) {
                System.out.print("Exiting");
                try {
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(400);
                        System.out.print(".");
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
                return;

            } else {
                System.out.println("Enter A Valid Choice...");
            }

    }
}
}