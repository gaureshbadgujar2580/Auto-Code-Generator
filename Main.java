import employee.Emp;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Emp
        Emp emp = new Emp("John Doe", 12345, "A", 5000, 500);

        // Calculate the net pay
        emp.calculateNetPay();

        // Display the employee details
        emp.displayDetails();
    }
}
