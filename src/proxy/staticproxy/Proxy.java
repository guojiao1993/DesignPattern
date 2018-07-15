package proxy.staticproxy;

public class Proxy implements Subject {
    private Subject subject = null;

    @Override
    public void operate() {
        if (subject == null) {
            subject = new RealSubject();
        }
        System.out.println("I'm Proxy, I'm invoking...");
        this.subject.operate();
        System.out.println("Proxy invoke end.");
    }

}
