package test.extend;

public class ExtendMain {
    public static void main(String[] args) {
        Parent parent = new Child();
        Child child = new Child();

        parent.shouting();
        child.shouting();
    }
}
