package SolidPrinciple.SRP.BetterCodePerformance;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("John", 101);

        ReportGenerator pdfGenerator = new PdfReportGenerator();
        ReportGenerator wordGenerator = new WordReportGenerator();

        Performance performance = new Performance();

        System.out.println(performance.generateReport(pdfGenerator, emp));
        System.out.println(performance.generateReport(wordGenerator, emp));

    }
}
