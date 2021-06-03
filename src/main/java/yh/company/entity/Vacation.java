package yh.company.entity;

public class Vacation {
    private int vacationId;
    private String username;
    private long vuid;
    private String starttime;
    private String endtime;
    private String type;
    private String cause;
    private int state;


    public int getVacationId() {
        return vacationId;
    }

    public void setVacationId(int vacationId) {
        this.vacationId = vacationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getVuid() {
        return vuid;
    }

    public void setVuid(long vuid) {
        this.vuid = vuid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
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
        return "Vacation{" +
                "vacationId=" + vacationId +
                ", username='" + username + '\'' +
                ", vuid=" + vuid +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", type='" + type + '\'' +
                ", cause='" + cause + '\'' +
                ", state=" + state +
                '}';
    }
}
