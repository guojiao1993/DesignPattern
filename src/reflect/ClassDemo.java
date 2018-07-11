package reflect;

/**
 * 任何一个类都是 Java.lang.Class 类的实例化对象
 */
public class ClassDemo {

    public static void main(String[] args) {
        F f = new F();
        // 第一种表达方式：任何一个类都有一个隐含的静态成员变量class
        Class c1 = F.class;
        // 第二种表达方式：在已知了该类的对象的情况下通过getClass方法获取
        Class c2 = f.getClass();
        ////第三种表达方式：类的全称
        Class c3 = null;
        try {
            c3 = Class.forName("reflect.F");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        try {
            // f1 就表示 F 类的实例化对象
            F f1 = (F)c1.newInstance();
            f1.print();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        // int 的类类型
        Class c4 = int.class;
        // String 的类类型
        Class c5 = String.class;
        // void 的类类型
        Class c6 = void.class;
        System.out.println(c4.getName());
        System.out.println(c5.getName());
        System.out.println(c5.getSimpleName());
        System.out.println(c6.getName());
    }

}

class F {
    void print(){
        System.out.println("Hello");
    }
}
