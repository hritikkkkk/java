package SolidPrinciple.LSP.Employee;

public class Volunteer extends Employee {
    // No salary — doesn't implement Payable

    public Volunteer(String name, String id) {
        super(name, id);
    }
}
