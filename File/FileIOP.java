package File;
import Entity.Passenger;
import EntityList.PassengerList;
import java.io.*;
import java.util.*;

public class FileIOP {
    public static void loadFromFile(PassengerList passengerList) {
        try {
            Scanner sc = new Scanner(new File("./File/PassengerData.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                Passenger p = new Passenger(data[0], data[1], data[2], data[3], data[4]);
                passengerList.insert(p);
            }
            sc.close();
        } catch (Exception e) {

        }
    }

    public static void writePassengerInFile(Passenger passenger) {
        try {
            FileWriter writer = new FileWriter(new File("./File/PassengerData.txt"));
            String data = passenger.getPassengerID() + ";" + passenger.getPassengerNID() + ";" +
                    passenger.getPassengerName() + ";" + passenger.getPassengerContact() + passenger.getPassengerEmail() + "\n";
            writer.write(data);
            writer.close();
        } catch (Exception e) {

        }
    }

    public static void updatePassengersInFile(PassengerList passengerList) {
        try {
            FileWriter writer = new FileWriter(new File("./File/UserData.txt"));
            Passenger passengers[] = passengerList.getAllPassengers();

            String allData = "";

            for (int i = 0; i < passengers.length; i++) {
                if (passengers[i] != null) {
                    String data = passengers[i].getPassengerID() + ";" + passengers[i].getPassengerNID() + ";" +
                            passengers[i].getPassengerName() + ";" + passengers[i].getPassengerContact() + passengers[i].getPassengerEmail() + "\n";

                    allData += data;
                }
            }
            writer.write(allData);
            writer.close();
        } catch (Exception e) {

        }
    }

    public static boolean checkUserFromFile(String userName, String userPass) {
        try {
            Scanner sc = new Scanner(new File("./File/UserData.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                if (data[0].equals(userName) && data[1].equals(userPass)) {
                    sc.close();
                    return true;
                }
            }
            sc.close();
        } catch (Exception e) {

        }
        return false;
    }
}
