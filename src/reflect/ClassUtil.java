package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

    public ClassUtil() {

    }

    ClassUtil(int a) {

    }

    public static void main(String[] args) {
        ClassUtil cu = new ClassUtil();
        printClassMethodMessage(cu);
        printFieldMessage(cu);
        printConMessage(cu);
    }

    public static void printClassMethodMessage(Object obj) {
        // 获取类的类类型
        Class c = obj.getClass();
        // Object类是一切类的父类，所以我们传递的是哪个子类的对象，c就是该子类的类类型。
        // 获取类的名称
        System.out.println("类的名称是:" + c.getName());
        // 我们知道，万事万物都是对象，方法也是对象，是谁的对象呢？
        // 在java里面，方法是Method类的对象，一个成员方法就是一个Method的对象，那么Method就封装了对这个成员方法的操作
        // 如果要获得所有的方法，可以用getMethods()方法，这个方法获取的是所有的Public的函数，包括父类继承而来的。
        // 如果要获取所有该类自己声明的方法，就可以用getDeclaredMethods()方法，这个方法是不问访问权限的。
        Method[] ms = c.getMethods();
        Method[] dms = c.getDeclaredMethods();
        // 接下来拿到这些方法之后干什么？可以获取这些方法的信息，比如方法的名字。
        // 首先要循环遍历这些方法
        for (int i = 0; i < ms.length; i++) {
            System.out.println("***********************************");
            // 然后可以得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            // 得到方法的返回值类型的名字
            System.out.print(returnType.getName() + " ");
            // 得到方法的名称
            System.out.print(ms[i].getName() + "(");
            // 获取参数类型 -> 得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
        for (int i = 0; i < dms.length; i++) {
            System.out.println("-----------------------------------");
            Class returnType = dms[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            System.out.print(dms[i].getName() + "(");
            Class[] paramTypes = dms[i].getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

    public static void printFieldMessage(Object obj) {
        Class c = obj.getClass();
        Field[] fs = c.getFields();
        Field[] dfs = c.getDeclaredFields();
        for (Field field : fs) {
            System.out.println("===================================");
            // 得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            // 得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
        for (Field field : dfs) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            // 得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            // 得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    public static void printConMessage(Object obj) {
        Class c = obj.getClass();
        /*
         * 首先构造函数也是对象，是java.lang.Constructor类的对象
         * 也就是java.lang. Constructor中封装了构造函数的信息
         * 和前面说到的一样，它也有两个方法：
         * getConstructors()方法获取所有的public的构造函数
         * getDeclaredConstructors()方法得到所有的自己声明的构造函数
         */
        Constructor[] cs = c.getConstructors();
        for (Constructor constructor : cs) {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            // 我们知道构造方法是没有返回值类型的，但是我们可以：
            System.out.print(constructor.getName() + "(");
            // 获取构造函数的参数列表，得到的是参数列表的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
        Constructor[] dcs = c.getDeclaredConstructors();
        for (Constructor constructor : dcs) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            // 我们知道构造方法是没有返回值类型的，但是我们可以：
            System.out.print(constructor.getName() + "(");
            // 获取构造函数的参数列表，得到的是参数列表的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

    public int a;
    String b;

    public int test1(int a, int b) {
        return 1;
    }

    String test2(String c, String d) {
        return "2";
    }

}
