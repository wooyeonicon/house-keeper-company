package yh.company.entity;

public class Result1 {
    private String time;
    private String type;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Result1{" +
                "time='" + time + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
