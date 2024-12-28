package Entity;

public class Passenger {

    private String passengerID;
    private String passengerNID;
    private String passengerName;
    private String passengerContact;
    private String passengerEmail;

    
    private static int passengerCounter = 0;

    public Passenger() {
    }

    public Passenger(String passengerID,String passengerNID,String passengerName, String passengerContact, String passengerEmail) {
		this.passengerID = passengerID;
		this.passengerNID = passengerNID;
        this.passengerName = passengerName;
        this.passengerContact = passengerContact;
        this.passengerEmail = passengerEmail;
		
		passengerCounter++;
    }
	
	public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }
	
	public void setPassengerNID(String passengerNID) {
        this.passengerNID = passengerNID;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
	

    public void setPassengerContact(String passengerContact) {
        this.passengerContact = passengerContact;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public String getPassengerID() {
        return passengerID;
    }
	
	 public String getPassengerNID() {
        return passengerNID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerContact() {
        return passengerContact;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void showpassengerInfo() {
        System.out.println("Passenger ID: " + passengerID);
        System.out.println("Passenger NID: " + passengerNID);
        System.out.println("PassengerName: " + passengerName);
        System.out.println("PassengerContact: " + passengerContact);
        System.out.println("PassengerEmail: " + passengerEmail);
    }
	
	public String getPassengerInfoAsString(){
		
		
		return  "Passenger id : "+passengerID+"\n"+
				"Passenger nid : "+passengerNID+"\n"+
				"Passenger name : "+passengerName+"\n"+
				"Passenger Contact : "+passengerContact+"\n"+
				"Passenger E- mail : "+passengerEmail+"\n";
	}

 
}
