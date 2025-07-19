package SolidPrinciple.DIP.GoodCode;

public class OrderService {

    private NotificationService notificationService;

    // Constructor Injection
    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        System.out.println("Placing order...");
        notificationService.sendNotification("Order placed!");
    }

}
