package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * java的四种引用——软引用
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        // 软引用
        final ReferenceQueue<Cat> queue = new ReferenceQueue<Cat>();// 用于跟踪对象的回收过程
        Cat cat = new Cat();
        SoftReference<Cat> softReference = new SoftReference<Cat>(cat, queue);
        cat = null;// Cat对象现在只持有软引用
//        Cat cat1 = softReference.get();
//        System.out.println(cat == cat1);

        //创建线程监控引用队列
        Thread thread = new Thread("myThread") {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    Reference<? extends Cat> ref = queue.poll();
                    if(ref == null) {
                        System.out.println("对象没有被回收" + count++);
                    } else {
                        System.out.println("对象被回收了...");
                        System.out.println("----------------------");
                        break;
                        /*
                        TODO 实测在爆出OOM的时候也没有执行到这个分支，不知道为什么，按理来说在发生OOM之前会回收掉只持有软引用的对象。
                         */
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread.start();

        //制造内存压力
        List<SoftReferenceTest> list = new ArrayList<SoftReferenceTest>();
        while (true) {
            list.add(new SoftReferenceTest());
        }
    }
}