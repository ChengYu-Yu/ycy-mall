package ycy.tmall.exception;


/**
 * 自定义异常处理
 * 用于处理参数异常情况
 */
public class ParameterException extends Exception {
    public ParameterException(String message) {
        super(message);
    }
}
