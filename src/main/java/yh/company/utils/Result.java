package yh.company.utils;

public class Result {
    //1，成功 2.异常
    private Object data;
    private String message;
    private int code;
    private Object flag;
    private String token;
    public Result(){}
    public Result(String message,int code){
        this.message = message;
        this.code = code;
    }
    public Result(Object data,String message,int code){
        this.data = data;
        this.message = message;
        this.code = code;
    }
    public Result(Object data,String message,int code,Object flag){
        this.data = data;
        this.message = message;
        this.code = code;
        this.flag = flag;
    }



    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getFlag() {
        return flag;
    }

    public void setFlag(Object flag) {
        this.flag = flag;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", flag=" + flag +
                ", token='" + token + '\'' +
                '}';
    }
}
