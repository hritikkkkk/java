package SolidPrinciple.LSP.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public static List<Payable> getPayableEmployees() {
        List<Payable> list = new ArrayList<>();
        list.add(new FullTimeEmployee("Alice", "F001", 50000, 10000));
        list.add(new Intern("Bob", "I101", 8000));
        list.add(new Vendor("accenture","A401",5000000));
        return list;
    }
}
