package yh.company.entity;

import java.sql.Date;
import java.sql.Time;
//签到
public class CheckWork {
    private long checkworkId;
    private long cuid;
    private String username;
    private String signin;
    private String signout;
    private int stat;

    public long getCheckworkId() {
        return checkworkId;
    }

    public void setCheckworkId(long checkworkId) {
        this.checkworkId = checkworkId;
    }

    public long getCuid() {
        return cuid;
    }

    public void setCuid(long cuid) {
        this.cuid = cuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSignin() {
        return signin;
    }

    public void setSignin(String signin) {
        this.signin = signin;
    }

    public String getSignout() {
        return signout;
    }

    public void setSignout(String signout) {
        this.signout = signout;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "CheckWork{" +
                "checkworkId=" + checkworkId +
                ", cuid=" + cuid +
                ", username='" + username + '\'' +
                ", signin='" + signin + '\'' +
                ", signout='" + signout + '\'' +
                ", stat=" + stat +
                '}';
    }
}
