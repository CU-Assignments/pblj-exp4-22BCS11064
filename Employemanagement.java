import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    
    public void displayEmployeeDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeManagementSystem {

    private static ArrayList<Employee> employeeList = new ArrayList<>();

    
    public static void addEmployee(int id, String name, double salary) {
        Employee newEmployee = new Employee(id, name, salary);
        employeeList.add(newEmployee);
        System.out.println("Employee added successfully.");
    }

    
    public static void updateEmployee(int id, String name, double salary) {
        for (Employee emp : employeeList) {
            if (emp.id == id) {
                emp.name = name;
                emp.salary = salary;
                System.out.println("Employee details updated.");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    
    public static void removeEmployee(int id) {
        for (Employee emp : employeeList) {
            if (emp.id == id) {
                employeeList.remove(emp);
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    
    public static void searchEmployee(int id) {
        for (Employee emp : employeeList) {
            if (emp.id == id) {
                emp.displayEmployeeDetails();
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    
    public static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        for (Employee emp : employeeList) {
            emp.displayEmployeeDetails();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter Employee ID: ");
                    int idToAdd = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter Employee Name: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salaryToAdd = scanner.nextDouble();
                    addEmployee(idToAdd, nameToAdd, salaryToAdd);
                    break;

                case 2: // Update Employee
                    System.out.print("Enter Employee ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter new Employee Name: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter new Employee Salary: ");
                    double salaryToUpdate = scanner.nextDouble();
                    updateEmployee(idToUpdate, nameToUpdate, salaryToUpdate);
                    break;

                case 3: // Remove Employee
                    System.out.print("Enter Employee ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    removeEmployee(idToRemove);
                    break;

                case 4: // Search Employee
                    System.out.print("Enter Employee ID to search: ");
                    int idToSearch = scanner.nextInt();
                    searchEmployee(idToSearch);
                    break;

                case 5: // Display All Employees
                    displayAllEmployees();
                    break;

                case 6: // Exit
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
