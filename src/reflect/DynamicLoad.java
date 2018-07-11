package reflect;

public class DynamicLoad {
    public static void main(String[] args) {
        try {
            Class cl = Class.forName(args[0]);
            // 通过类类型，创建该类的对象
            Stand s = (Stand) cl.newInstance();
            s.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
