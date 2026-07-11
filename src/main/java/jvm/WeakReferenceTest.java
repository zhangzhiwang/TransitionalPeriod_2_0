package jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * java的四种引用——弱引用
 */
public class WeakReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        final ReferenceQueue<Cat> referenceQueue = new ReferenceQueue<Cat>();
        Cat cat = new Cat();
        WeakReference<Cat> weakReference = new WeakReference<Cat>(cat, referenceQueue);
//        WeakReference<Cat> weakReference2 = new WeakReference<Cat>(cat);
        cat = null;

        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    Reference<? extends Cat> reference = referenceQueue.poll();
                    if(reference == null) {
                        System.out.println("Cat对象没有被回收");
                    } else {
                        DateFormat df = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
                        Date date = new Date(System.currentTimeMillis());
                        System.out.println(df.format(date) + ":Cat对象被回收了...");
                        System.out.println("-------------------");
                        break;
                    }
                }
            }
        };
        thread.start();

        List<WeakReferenceTest> list = new ArrayList<WeakReferenceTest>();
        while(true) {
            list.add(new WeakReferenceTest());
            Thread.sleep(10);
        }
    }
}
