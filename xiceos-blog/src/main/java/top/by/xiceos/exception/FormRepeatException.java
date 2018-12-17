package top.by.xiceos.exception;

/**
 * <p>Title: FormRepeatException</p>
 * <p>Description: 表单重复提交异常类</p>
 *
 * @author zwp
 * @date 2018/12/17 11:38
 */
public class FormRepeatException extends Exception {

    public FormRepeatException(String message) {
        super(message);
    }

    public FormRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

}
