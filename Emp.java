package employee;

public class Emp {
    private String name;
    private int employeeId;
    private String category;
    private double basicPay;
    private double HRA;
    private double DA;
    private double netPay;
    private double providentFund;
    private double grossPay;
    private double incomeTax;
    private double allowance;

    public Emp(String name, int employeeId, String category, double basicPay, double allowance) {
        this.name = name;
        this.employeeId = employeeId;
        this.category = category;
        this.basicPay = basicPay;
        this.allowance = allowance;
    }

    private void calculateHRA() {
        // Calculate HRA based on the basic pay and category
        if (category.equalsIgnoreCase("A"))
            HRA = 0.25 * basicPay;
        else if (category.equalsIgnoreCase("B"))
            HRA = 0.20 * basicPay;
        else
            HRA = 0.15 * basicPay;
    }

    private void calculateDA() {
        // Calculate DA based on the basic pay
        DA = 0.10 * basicPay;
    }

    private void calculateGrossPay() {
        // Calculate gross pay by adding basic pay, HRA, DA, and allowance
        grossPay = basicPay + HRA + DA + allowance;
    }

    private void calculateProvidentFund() {
        // Calculate provident fund based on the gross pay
        providentFund = 0.12 * grossPay;
    }

    private void calculateIncomeTax() {
        // Calculate income tax based on the gross pay
        incomeTax = 0.15 * grossPay;
    }

    public void calculateNetPay() {
        calculateHRA();
        calculateDA();
        calculateGrossPay();
        calculateProvidentFund();
        calculateIncomeTax();

        // Calculate net pay by deducting provident fund and income tax from the gross pay
        netPay = grossPay - providentFund - incomeTax;
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Category: " + category);
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("HRA: $" + HRA);
        System.out.println("DA: $" + DA);
        System.out.println("Allowance: $" + allowance);
        System.out.println("Gross Pay: $" + grossPay);
        System.out.println("Provident Fund: $" + providentFund);
        System.out.println("Income Tax: $" + incomeTax);
        System.out.println("Net Pay: $" + netPay);
    }
}
