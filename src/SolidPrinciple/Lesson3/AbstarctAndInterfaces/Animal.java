package SolidPrinciple.Lesson3.AbstarctAndInterfaces;

import org.w3c.dom.ls.LSOutput;

abstract class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
    abstract void makeSound();
    void sleep(){
        System.out.println( "animal is sleeping...");

    }
}

interface Swimmable {
    void swim();
}

class Dolphin extends Animal implements Swimmable {
    Dolphin(String name) {
        super(name);
    }

    @Override
    void makeSound() {
//        super.makeSound(); // here we cannot
        System.out.println(name + " makes clicking sounds");
    }

    @Override
    public void swim() {


        System.out.println(name + " is swimming fast!");
    }
    @Override
    public void sleep(){
        super.sleep();
        System.out.println(name+"is sleeping.....");
    }

    public static void main(String[] args) {
        Dolphin d=new Dolphin("bruno");
        d.sleep();

    }
}


