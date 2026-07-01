package algorithm;

/**
 * @date 2026/6/27 10:46 AM
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
//        Thread thread = new Thread();
        ThreadLocal<String> tL = new ThreadLocal<String>();
        try {
            tL.set("123");
            String s = tL.get();
            System.out.println(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            tL.remove();
        }
    }
}
