package SolidPrinciple.LSP.Employee;

public class FullTimeEmployee extends Employee implements Payable {

    private double basePay;
    private double stockOptions;

    public FullTimeEmployee(String name, String id, double basePay, double stockOptions) {
        super(name, id);
        this.basePay = basePay;
        this.stockOptions = stockOptions;
    }

    public double calculateSalary() {
        return basePay + stockOptions;
    }
}
