package cursor.mall.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一 API 响应封装，对应接口文档 code / message / data。
 * （由 Curosr 自动生成）
 *
 * @param <T> 业务数据类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    /** 业务状态码，0 表示成功。 */
    private int code;

    /** 提示信息。 */
    private String message;

    /** 业务数据。 */
    private T data;

    /**
     * 构造成功响应。
     * （由 Curosr 自动生成）
     *
     * @param data 业务数据
     * @param <T>  数据类型
     * @return 成功响应
     */
    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<T>(0, "ok", data);
    }

    /**
     * 构造带自定义文案的成功响应。
     * （由 Curosr 自动生成）
     *
     * @param message 提示文案
     * @param data    业务数据
     * @param <T>     数据类型
     * @return 成功响应
     */
    public static <T> ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<T>(0, message, data);
    }

    /**
     * 构造失败响应。
     * （由 Curosr 自动生成）
     *
     * @param code    错误码
     * @param message 错误提示
     * @param <T>     数据类型
     * @return 失败响应
     */
    public static <T> ApiResponse<T> fail(int code, String message) {
        return new ApiResponse<T>(code, message, null);
    }
}
