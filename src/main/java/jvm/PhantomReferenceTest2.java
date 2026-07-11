package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2026/7/3 20:31
 */
public class PhantomReferenceTest2 {
    public static void main(String[] args) throws InterruptedException {
        Cat Cat = new Cat();
        final ReferenceQueue<Cat> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Cat> phantomReference = new PhantomReference<Cat>(Cat, referenceQueue);
        Cat = null;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PhantomReference<Cat> p = null;
                    if((p = (PhantomReference)referenceQueue.remove()) != null) {
                        System.out.println("对象被回收：" + p);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        List<byte[]> list = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            list.add(new byte[1 * 1024 * 1024]);
            Thread.sleep(10);
        }

//        List<Cat> list = new ArrayList<Cat>();
//        while(true) {
//            list.add(new Cat());
//        }
    }
}
