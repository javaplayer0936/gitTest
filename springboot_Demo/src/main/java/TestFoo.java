public class TestFoo {

    public static void main(String[] args) {
        Bar bar = new Bar();
        System.out.println();

    }
}
class Foo {
    private int a;
    public Foo() {
        a = 3;
    }
    public void addFive() {
        a += 5;
    }
}

class Bar extends Foo {
    private int a;
    private int b;
    public Bar() {
        a = 8;
    }
    public void addFive() {
        this.a += 5;
    }

    public void addSix() {
        this.a += 6;
    }

}
