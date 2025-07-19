package SolidPrinciple.Lesson3.AbstarctAndInterfaces;

public interface Flyable {
    default void start() {
        System.out.println("Default start");
    }

    static void maintenanceTip() {
        System.out.println("Check oil every 5000 km");
    }
}

class Airplane implements Flyable{
    public static void main(String[] args) {
        Flyable airplane=new Airplane();
        airplane.start();
         Flyable.maintenanceTip();

    }
}
