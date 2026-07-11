package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * java的四种引用——虚引用
 *
 * @Date 2026/7/3 17:47
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        final ReferenceQueue<Cat> referenceQueue = new ReferenceQueue<Cat>();
        Cat cat = new Cat();
        PhantomReference<Cat> phantomReference = new PhantomReference<Cat>(cat, referenceQueue);
        cat = null;

        new Thread() {
            @Override
            public void run() {
                while(true) {
                    Reference<? extends Cat> reference = referenceQueue.poll();
                    if(reference == null) {
                        System.out.println("对象没有被回收");
                    } else {
                        System.out.println("对象被回收了...");
                        System.out.println("-------------");
                        break;
                    }
                }
            }
        }.start();

        // 让jvm进行gc
//        List<Cat> list = new ArrayList<Cat>();
//        while(true) {
//            list.add(new Cat());
////            System.gc();
//            /*
//            TODO 很奇怪，加上System.gc()就会走到上面的else分支，打印"对象被回收了..."，不加这句话就走不到else分支，不知道为什么。
//            不加这句话我看gc日志里面也有fullgc，为什么不回收虚引用对象呢？System.gc()本质上不也是通知jvm进行full gc吗？不一样的吗？
//            */
//                // 不知道为什么
//        }

        List<byte[]> list = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            list.add(new byte[1 * 1024 * 1024]);
        }
    }
}
