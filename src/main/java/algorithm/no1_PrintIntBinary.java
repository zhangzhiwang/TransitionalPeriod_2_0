package algorithm;

/**
 * 打印一个int整数的二进制表示形式
 *
 * @author zhangzhiwang
 * @date 2026/6/24 11:13 AM
 */
public class no1_PrintIntBinary {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        printIntBinary(i);
    }

    private static void printIntBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((1 << i) & num) == 0 ? "0" : "1");
        }
    }
}
