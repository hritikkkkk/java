package SolidPrinciple.LSP.Employee;

public class Vendor extends Employee implements Payable {
    private double ProjectFee;

    public Vendor(String name, String id, double ProjectFee) {
        super(name, id);
        this.ProjectFee = ProjectFee;
    }

    @Override
    public double calculateSalary() {
        return this.ProjectFee;
    }
}
