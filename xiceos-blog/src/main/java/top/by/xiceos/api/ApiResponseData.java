package top.by.xiceos.api;

/**
 * <p>Title: ApiResponseData</p>
 * <p>Description: API数据格式封装</p>
 *
 * @author zwp
 * @date 2018/12/17 17:51
 */
public class ApiResponseData {

    /* 状态码 */
    private int code;

    /* 消息 */
    private String message;

    /* 数据 */
    private Object data;

    /* 更多 */
    private boolean more;

    public ApiResponseData(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponseData() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public static ApiResponseData ofMessage(int code, String message) {
        return new ApiResponseData(code, message, null);
    }

    public static ApiResponseData ofSuccess(Object data) {
        return new ApiResponseData(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data);
    }

    public static ApiResponseData ofStatus(Status status) {
        return new ApiResponseData(status.getCode(), status.getStandardMessage(), null);
    }

    /**
     * <p>Title: ApiResponseData</p>
     * <p>Description: 状态</p>
     *
     * @author zwp
     * @date 2018/12/17 19:33
     */
    public enum Status {
        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
        NOT_VALID_PARAM(40005, "Not valid Params"),
        NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
        NOT_LOGIN(50000, "Not Login");

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }

}
