package SolidPrinciple.DIP.BadCode;

public class main {
    public static void main(String[] args) {
        OrderService orderService=new OrderService();
        orderService.placeOrder();
    }
}
