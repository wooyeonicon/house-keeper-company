package yh.company.entity;
//离职
public class Leave {
    private int leaveId;
    private long userId;
    private String username;
    private int departmentId;
    private String post;
    private String type;
    private String cause;
    private int state;

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId=" + leaveId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", departmentId=" + departmentId +
                ", post='" + post + '\'' +
                ", type='" + type + '\'' +
                ", cause='" + cause + '\'' +
                ", state=" + state +
                '}';
    }
}
