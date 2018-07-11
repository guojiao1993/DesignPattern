package proxy.staticproxy;

public class RealSubject implements Subject {
    @Override
    public void operate() {
        System.out.println("RealSubject");
    }
}
