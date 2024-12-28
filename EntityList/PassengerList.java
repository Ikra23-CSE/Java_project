package EntityList;

import Entity.Passenger;

import File.FileIOP;

public class PassengerList {

    private Passenger passengers[];

    public PassengerList() {
        passengers = new Passenger[5];
		
		FileIOP.loadFromFile(this);
    }

    public PassengerList(int size) {
        passengers = new Passenger[size];
		
		FileIOP.loadFromFile(this);
    }

    public void insert(Passenger passenger) {
        boolean flag = false;
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Passenger Insertion Successful");
        } else {
            System.out.println("Passenger Insertion Failed");
        }
    }

    public Passenger getById(String passengerID) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null && passengers[i].getPassengerID().equals(passengerID)) {
                return passengers[i];
            }
        }
        return null;
    }
	
	public void delete(Passenger passengerToDelete) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null && passengers[i].equals(passengerToDelete)) {
                passengers[i] = null;
                System.out.println("Passenger Deletion Successful");
                return;
            }
        }
        System.out.println("Passenger Deletion Failed");
    }

    public void deleteById(String passengerID) {
        boolean flag = false;
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null && passengers[i].getPassengerID().equals(passengerID)) {
                passengers[i] = null;
                flag = true;
                System.out.println("Passenger Deletion Successful");
                break;
            }
        }
        if (!flag) {
            System.out.println("Passenger Deletion Failed");
        }
    }

    public void searchByName(String passengerName) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null && passengers[i].getPassengerName().equals(passengerName)) {
                System.out.println("--------- Passenger Found ---------");
                passengers[i].showpassengerInfo();
                return;
            }
        }
        System.out.println("=== Passenger Not Found ===");
    }

    public void showAll() {
        System.out.println("--------- List of All Passengers ---------");
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null) {
                System.out.println("---------------------");
                passengers[i].showpassengerInfo();
            }
        }
        System.out.println("---------------------");
    }

    public String getAllPassengersAsString() {
        StringBuilder allPassengersInfo = new StringBuilder("--------- List of All Passengers ---------\n");
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null) {
                allPassengersInfo.append("---------------------\n");
                allPassengersInfo.append(passengers[i].getPassengerInfoAsString()).append("\n");
            }
        }
        allPassengersInfo.append("---------------------\n");
        return allPassengersInfo.toString();
    }

    public Passenger[] getAllPassengers() {
        return passengers;
    }
}




