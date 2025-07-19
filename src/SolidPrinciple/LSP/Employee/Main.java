package SolidPrinciple.LSP.Employee;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Payable> paidEmployees = EmployeeRepository.getPayableEmployees();

        for (Payable emp : paidEmployees) {
            System.out.println("Salary: " + emp.calculateSalary());
        }
    }
}
