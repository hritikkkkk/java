package SolidPrinciple.Lesson3.AbstarctAndInterfaces;



abstract class Car {
    String EngineNumber;

    Car(String engineNumber) {
        this.EngineNumber = engineNumber;
    }
    //concrete method

    String getEngineNumber(){
        return this.EngineNumber;
    }
}


class Tesla extends Car {
    Tesla(String engineNumber) {
        super(engineNumber);
    }

    public static void main(String[] args) {
        Tesla t=new Tesla("102GV");
        System.out.println(t.getEngineNumber());

    }
}