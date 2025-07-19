package SolidPrinciple.SRP.BetterCodePerformance;

public class PdfReportGenerator implements ReportGenerator {
    @Override
    public String generate(Employee employee) {
        return "generating pdf report for employess";
    }
}
