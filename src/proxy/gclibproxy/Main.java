package proxy.gclibproxy;

public class Main {
    public static void main(String[] args) {
        ProxyCglib proxy = new ProxyCglib();
        RealSubjectCglib cglib = (RealSubjectCglib) proxy.getInstance(new RealSubjectCglib());
        cglib.operate();
    }
}
