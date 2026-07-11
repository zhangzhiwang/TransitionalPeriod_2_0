package algorithm;

import java.nio.ByteBuffer;

public class ThreadLocalTest2 {
    public static void main(String[] args) {
        ThreadLocal<String> tL = new ThreadLocal<String>();
        tL.remove();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
    }
}
