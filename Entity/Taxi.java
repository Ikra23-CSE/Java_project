package Entity;

public class Taxi {
    private String taxiID;
    private String taxiName;
    private String sourceArea;
    private String destinationArea;
    

    public Taxi(String taxiID, String taxiName, String sourceArea, String destinationArea) {
        this.taxiID = taxiID;
        this.taxiName = taxiName;
        this.sourceArea = sourceArea;
        this.destinationArea = destinationArea;
        
    }
	
	 public void setTaxiID(String taxiID){
        this.taxiID = taxiID;
    }
	public void setTaxiName(String taxiName) {
        this.taxiName = taxiName;
    }

    public void setSourceArea(String sourceArea) {
        this.sourceArea = sourceArea;
    }

    public void setDestinationArea(String destinationArea) {
        this.destinationArea = destinationArea;
    }


    public String getTaxiID() {
        return taxiID;
    }

    public String getTaxiName() {
        return taxiName;
    }

    public String getSourceArea() {
        return sourceArea;
    }

    public String getDestinationArea() {
        return destinationArea;
    }

 
    public void showTaxiInfo() {
        System.out.println("Taxi ID: " + taxiID);
        System.out.println("Taxi Name: " + taxiName);
        System.out.println("Source Area: " + sourceArea);
        System.out.println("Destination Area: " + destinationArea);
        
    }


    public String getTaxiInfoAsString() {
        
       
		 return "Taxi  ID : " + taxiID + "\n" +
            "Taxi Name : " + taxiName + "\n" +
            "Source Station: " + sourceArea + "\n" +
            "Destination Station : " + destinationArea + "\n" ;
            
    }
}





