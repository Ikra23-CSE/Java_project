package File;
import Entity.Employee;
import EntityList.EmployeeList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIOE {

    public static void loadFromFile(EmployeeList employeeList) {
        try {
            Scanner sc = new Scanner(new File("./File/EmployeeData.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                Employee employee = new Employee(data[0], data[1], data[2], data[3], data[4]);
                employeeList.insert(employee);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeEmployeeInFile(Employee employee) {
        try {
            FileWriter writer = new FileWriter(new File("./File/EmployeeData.txt"), true);
            String data = employee.getEmployeeID() + ";" + employee.getEmployeeNID() + ";" +
                    employee.getEmployeeName() + ";" + employee.getEmployeeContact() + ";" + employee.getEmployeeEmail() + "\n";
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateEmployeesInFile(EmployeeList employeeList) {
        try {
            FileWriter writer = new FileWriter(new File("./File/EmployeeData.txt"));
            Employee employees[] = employeeList.getAllEmployees();

            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    String data = employees[i].getEmployeeID() + ";" + employees[i].getEmployeeNID() + ";" +
                            employees[i].getEmployeeName() + ";" + employees[i].getEmployeeContact() + ";" + employees[i].getEmployeeEmail() + "\n";
                    writer.write(data);
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkEmployeeFromFile(String userName, String password) {
		 try {
            Scanner sc = new Scanner(new File("./File/UserData.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                if (data[0].equals(userName) && data[1].equals(password)) {
                    sc.close();
                    return true;
                }
            }
            sc.close();
        }
		
      catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
