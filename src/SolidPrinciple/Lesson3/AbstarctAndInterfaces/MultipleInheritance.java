package SolidPrinciple.Lesson3.AbstarctAndInterfaces;

public class MultipleInheritance {
    public static void main(String[] args) {
        D d=new D();
        d.useA();
        d.useB();

        C c=new C();
        c.greet();
    }
}

interface A {
    default void greet() {
        System.out.println("Hello from A");
    }
}

interface B {
    default void greet() {
        System.out.println("Hello from B");
    }
}

class C implements A, B {
    public void greet() {
        B.super.greet();
    }
}


class X {
    void aMethod() {
        System.out.println("A method");
    }
}

class Y {
    void bMethod() {
        System.out.println("B method");
    }
}

class D {
    X a = new X();
    Y b = new Y();

    void useA() { a.aMethod(); }
    void useB() { b.bMethod(); }
}
