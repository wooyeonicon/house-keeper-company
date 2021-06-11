package yh.company.entity;

public class Txt {
    private long txtId;
    private long userId;
    private String time;
    private String title;
    private String message;
    private String content;

    public long getTxtId() {
        return txtId;
    }


    public void setTxtId(long txtId) {
        this.txtId = txtId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Txt{" +
                "txtId=" + txtId +
                ", userId=" + userId +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
