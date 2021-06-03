package yh.company.entity;
//工资
public class Wages {
    private long wagesId;
    private String time;
    private double money;
    private long wuid;
    private double basepay;
    private double reward;
    private double allowance;

    public double getBasepay() {
        return basepay;
    }

    public void setBasepay(double basepay) {
        this.basepay = basepay;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public long getWagesId() {
        return wagesId;
    }

    public void setWagesId(long wagesId) {
        this.wagesId = wagesId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public long getWuid() {
        return wuid;
    }

    public void setWuid(long wuid) {
        this.wuid = wuid;
    }

    @Override
    public String toString() {
        return "Wages{" +
                "wagesId=" + wagesId +
                ", time='" + time + '\'' +
                ", money=" + money +
                ", wuid=" + wuid +
                ", basepay=" + basepay +
                ", reward=" + reward +
                ", allowance=" + allowance +
                '}';
    }
}
