package SolidPrinciple.DIP.GoodCode;



public class SMSService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("sms:"+ message);


       }
}
