package SolidPrinciple.LSP.Employee;

public class Intern extends Employee implements Payable{

    private double stipend;

    public Intern(String name, String id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    public double calculateSalary() {
        return stipend;
    }
}
