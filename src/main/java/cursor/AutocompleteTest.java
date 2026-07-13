package cursor;

/**
 * autocomplete测试
 */
public class AutocompleteTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        for (int j = 0; j < 10; j++) {
            System.out.println("hello");
        }

        for (int k = 0; k < 10; k++) {
            System.out.println("hello");
        }

        for (int l = 0; l < 10; l++) {
            System.out.println("hello");
        }

        AutocompleteTest test = new AutocompleteTest();
        System.out.println(test.generatedMethod("hello", 5L));
    }

    /**
     * 由 cursor 悬浮对话框生成
     */
    /**
     * 该方法先判断传入的字符串 str 是否为 null，
     * 如果不是 null 就取其长度，否则取 0，
     * 再加上第二个参数 num（long 类型被强制转换为 int）。
     * 方法加了 synchronized，代表在对象粒度上是线程安全的。
     *
     * 存在的问题：
     * 1. 如果 num 很大（比如超出 int 范围），强制转换会丢失高位数据，存在数据溢出风险。
     * 2. Thread.sleep(1000) 可能抛出 InterruptedException，需要处理或继续向上抛出。
     * 3. 字符串长度与 long 转 int 之后相加，有潜在的业务含义混淆，缺乏注释说明这样做的目的。
     */
    private synchronized int generatedMethod(String str, long num) throws InterruptedException {
        Thread.sleep(1000);
        return (str != null ? str.length() : 0) + (int) num;
    }
}
