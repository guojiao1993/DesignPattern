package reflect;

public class StaticLoad {
    public static void main(String[] args) {
        if ("B".equals(args[0])) {
            B b = new B();
            b.start();
        }
        if ("C".equals(args[0])) {
            C c = new C();
            c.start();
        }
        try {
            Class cl = Class.forName(args[0]);
            // 通过类类型，创建该类的对象
            cl.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface Stand {
    public void start();
}

class B implements Stand{
    @Override
    public void start() {
        System.out.print("B...satrt");
    }
}

class C implements Stand {
    @Override
    public void start() {
        System.out.print("C...satrt");
    }
}
