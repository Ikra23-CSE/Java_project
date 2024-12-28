package Entity;

public class Employee {

    private String employeeID;
    private String employeeNID;
    private String employeeName;
    private String employeeContact;
    private String employeeEmail;

    private static int employeeCounter = 0;

    public Employee() {
    }

    public Employee(String employeeID, String employeeNID, String employeeName, String employeeContact, String employeeEmail) {
        this.employeeID = employeeID;
        this.employeeNID = employeeNID;
        this.employeeName = employeeName;
        this.employeeContact = employeeContact;
        this.employeeEmail = employeeEmail;

        employeeCounter++;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeeNID(String employeeNID) {
        this.employeeNID = employeeNID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeNID() {
        return employeeNID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void showEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Employee NID: " + employeeNID);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Contact: " + employeeContact);
        System.out.println("Employee Email: " + employeeEmail);
    }

    public String getEmployeeInfoAsString() {
        return "Employee ID: " + employeeID + "\n" +
                "Employee NID: " + employeeNID + "\n" +
                "Employee Name: " + employeeName + "\n" +
                "Employee Contact: " + employeeContact + "\n" +
                "Employee Email: " + employeeEmail + "\n";
    }
}
