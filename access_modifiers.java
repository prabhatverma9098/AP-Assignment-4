class AccessModifierDemo {
    public void publicMethod() {
        System.out.println("Public method called.");
    }

    private void privateMethod() {
        System.out.println("Private method called.");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called.");
    }

    // Method to internally call private method
    public void callPrivateMethod() {
        privateMethod(); // Allowed within the same class
    }
}

class SubClass extends AccessModifierDemo {
    public void accessMethodsInSubclass() {
        System.out.println("Inside subclass:");
        publicMethod();       // Accessible
        protectedMethod();    // Accessible
        // privateMethod();   // Not accessible - would cause a compilation error
    }
}
class SamePackageClass {
    public void accessMethods() {
        AccessModifierDemo obj = new AccessModifierDemo();
        System.out.println("Inside same package non-subclass:");
        obj.publicMethod();       // Accessible
        obj.protectedMethod();    // Accessible within same package
        // obj.privateMethod();   // Not accessible - would cause a compilation error
    }
}

public class AccessTest {
    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo();

        System.out.println("From main method:");
        demo.publicMethod();        // Accessible
        // demo.privateMethod();    // Not accessible - private
        demo.callPrivateMethod();   // Indirect access to private method
        demo.protectedMethod();     // Accessible (same package)

        SubClass sub = new SubClass();
        sub.accessMethodsInSubclass();

        SamePackageClass samePkg = new SamePackageClass();
        samePkg.accessMethods();
    }
}
