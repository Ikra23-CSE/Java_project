package EntityList;

import Entity.Employee;
import File.FileIOE;

public class EmployeeList {

    private Employee employees[];

    public EmployeeList() {
        employees = new Employee[5];
        
        FileIOE.loadFromFile(this);
    }

    public EmployeeList(int size) {
        employees = new Employee[size];
        
        FileIOE.loadFromFile(this);
    }

    public void insert(Employee employee) {
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Employee Insertion Successful");
        } else {
            System.out.println("Employee Insertion Failed");
        }
    }

    public Employee getById(String employeeID) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getEmployeeID().equals(employeeID)) {
                return employees[i];
            }
        }
        return null;
    }

    public void delete(Employee employeeToDelete) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employeeToDelete)) {
                employees[i] = null;
                System.out.println("Employee Deletion Successful");
                return;
            }
        }
        System.out.println("Employee Deletion Failed");
    }

    public void deleteById(String employeeID) {
        boolean flag = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getEmployeeID().equals(employeeID)) {
                employees[i] = null;
                flag = true;
                System.out.println("Employee Deletion Successful");
                break;
            }
        }
        if (!flag) {
            System.out.println("Employee Deletion Failed");
        }
    }

    public void searchByName(String employeeName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getEmployeeName().equals(employeeName)) {
                System.out.println("--------- Employee Found ---------");
                employees[i].showEmployeeInfo();
                return;
            }
        }
        System.out.println("=== Employee Not Found ===");
    }

    public void showAll() {
        System.out.println("--------- List of All Employees ---------");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("---------------------");
                employees[i].showEmployeeInfo();
            }
        }
        System.out.println("---------------------");
    }

    public String getAllEmployeesAsString() {
        StringBuilder allEmployeesInfo = new StringBuilder("--------- List of All Employees ---------\n");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                allEmployeesInfo.append("---------------------\n");
                allEmployeesInfo.append(employees[i].getEmployeeInfoAsString()).append("\n");
            }
        }
        allEmployeesInfo.append("---------------------\n");
        return allEmployeesInfo.toString();
    }

    public Employee[] getAllEmployees() {
        return employees;
    }
}




