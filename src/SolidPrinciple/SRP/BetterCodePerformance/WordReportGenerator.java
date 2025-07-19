package SolidPrinciple.SRP.BetterCodePerformance;

public class WordReportGenerator implements ReportGenerator {

    @Override
    public String generate(Employee employee) {
        return "Generating Word report for employee.";
    }
}
