package SolidPrinciple.DIP.BadCode;

public class OrderService {
    EmailService emailService = new EmailService();
    SkypeService skypeService = new SkypeService();


    public void placeOrder() {
        emailService.sendEmail();
        skypeService.sendSkype();
    }
}
