package SolidPrinciple.SRP.BetterCodePerformance;

public class Performance {  //delegates the work
    public String generateReport(ReportGenerator generator, Employee employee) {
        return generator.generate(employee);
    }

}
