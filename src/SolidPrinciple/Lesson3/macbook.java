package SolidPrinciple.Lesson3;

public class macbook extends product{


    @Override
    public double calculateDiscount() {
        return 0;
    }

    @Override
    public void termsAndConditions(){
        System.out.println("some terms regarding macbook");
    }
}
