package File;

import EntityList.TaxiList;
import Entity.Taxi;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIORide {
    public static void loadFromFile(TaxiList taxilist) {
        try {
            Scanner sc = new Scanner(new File("./File/Ride.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                Taxi taxi = new Taxi(data[0], data[1], data[2], data[3]);
                 taxilist.insert(taxi);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeTaxiInFile(Taxi taxi) {
        try {
            FileWriter writer = new FileWriter(new File("./File/Ride.txt"), true);
            String data = taxi.getTaxiID() + ";" + taxi.getTaxiName() + ";" +
                    taxi.getSourceArea() + ";" + taxi.getDestinationArea() + "\n";
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateTaxisInFile(TaxiList taxilist) {
        try {
            FileWriter writer = new FileWriter(new File("./File/Ride.txt"));
            Taxi taxis[] = taxilist.getAllTaxi();

            String allData = "";

            for (Taxi taxi : taxis) {
                if (taxi != null) {
                    String data = taxi.getTaxiID() + ";" + taxi.getTaxiName() + ";" +
                            taxi.getSourceArea() + ";" + taxi.getDestinationArea() + "\n";

                    allData += data;
                }
            }
            writer.write(allData);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUserFromFile(String userName, String userPass) {
        try {
            Scanner sc = new Scanner(new File("./File/UserData.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                String storedUserName = data[0];
                String storedUserPass = data[1];

                if (userName.equals(storedUserName) && userPass.equals(storedUserPass)) {
                    sc.close();
                    return true;
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
