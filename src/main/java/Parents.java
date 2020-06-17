public class Parents {
    void sayHello() {
        System.out.println("hello from " + this.getClass().getCanonicalName());
    }

    public static void main(String[] args) {
        B instance = new B();
        instance.sayHello();
    }
}

class B extends Parents {
    Parents p;

    @Override
    void sayHello() {
        p.sayHello();
        System.out.println("Hello from " + this.getClass().getName());
    }

    public B() {
        p = new Parents();
    }
}
