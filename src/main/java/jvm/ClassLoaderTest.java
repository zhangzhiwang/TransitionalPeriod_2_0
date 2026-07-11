package jvm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 类加载器探究
 *
 * @Date 2026/7/6 17:15
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class c = ClassLoaderTest.class.getClassLoader().loadClass("jvm.Cat");
        System.out.println(c);

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> c1 = myClassLoader.loadClass("jvm.Cat");
        System.out.println("myClassLoader:" + c1);

        Connection connection = DriverManager.getConnection("localhost:3306/test?aaa", "root", "1234");
        Thread thread = new Thread();
        thread.setContextClassLoader(new MyClassLoader());
    }

    static class MyClassLoader extends ClassLoader {}
}
