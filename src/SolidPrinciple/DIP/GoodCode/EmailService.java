package SolidPrinciple.DIP.GoodCode;

public class EmailService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("email:"+message);
    }
}