package EntityList;

import Entity.Taxi;
import File.FileIORide; 

public class TaxiList {
    private Taxi[] taxis; // Corrected variable name

    public TaxiList() {
        taxis = new Taxi[5];
		
        FileIORide.loadFromFile(this);
    }

    public TaxiList(int size) {
        taxis = new Taxi[size];
		
        FileIORide.loadFromFile(this);
    }

    public void insert(Taxi taxi) {
        boolean flag = false;
        for (int i = 0; i < taxis.length; i++) {
            if (taxis[i] == null) {
                taxis[i] = taxi;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Taxi Insertion Successful");
        } else {
            System.out.println("Taxi Insertion Failed");
        }
    }

    public Taxi getByTaxiID(String taxiID) {
        for (Taxi taxi : taxis) {
            if (taxi != null && taxi.getTaxiID().equals(taxiID)) {
                return taxi;
            }
        }
        return null;
    }

    public void delete(Taxi taxi) {
        for (int i = 0; i < taxis.length; i++) {
            if (taxis[i] != null && taxis[i].getTaxiID().equals(taxi.getTaxiID())) {
                taxis[i] = null;
                System.out.println("Taxi Deletion Successful");
                return;
            }
        }
        System.out.println("Taxi Deletion Failed");
    }

    public void searchByTaxiID(String taxiID) {
        for (Taxi taxi : taxis) {
            if (taxi != null && taxi.getTaxiID().equals(taxiID)) {
                System.out.println("+++ Taxi Found +++");
                taxi.showTaxiInfo(); // Assuming showTaxiInfo() is a method in Taxi class
                return;
            }
        }
        System.out.println("=== Taxi Not Found ===");
    }

    public Taxi[] getAllTaxi() {
        return taxis;
    }

    public void showAll() {
        System.out.println("------- List of All Taxi ------- ");
        for (Taxi taxi : taxis) {
            if (taxi != null) {
                System.out.println("-------------- ");
                taxi.showTaxiInfo(); // Assuming showTaxiInfo() is a method in Taxi class
            }
        }
        System.out.println("+--------------  ");
    }

    public String getAllTaxisAsString() {
        StringBuilder allTaxisInfo = new StringBuilder("-------  List of All Taxis ------- \n");
        for (Taxi taxi : taxis) {
            if (taxi != null) {
                allTaxisInfo.append("--------------  \n");
                allTaxisInfo.append(taxi.getTaxiInfoAsString()).append("\n"); // Assuming getTaxiInfoAsString() is a method in Taxi class
            }
        }
        allTaxisInfo.append("--------------  \n");
        return allTaxisInfo.toString();
    }
}





