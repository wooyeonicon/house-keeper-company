package yh.company.entity;

public class Mend {
    //mend_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '补签id',
    //	user_id LONG NOT NULL COMMENT '申请人id',
    //	username CHAR(20) NOT NULL COMMENT '申请人姓名',
    //	csignin VARCHAR(50) COMMENT '签到时间',
    //	TYPE INT NOT NULL DEFAULT 0 COMMENT '补签状态',
    //	witness_id LONG COMMENT '见证人id',
    //	witness_name CHAR(20) COMMENT '见证人姓名',
    //	cause TEXT NOT NULL COMMENT '原因'
    private int mendId;
    private long userId;
    private String username;
    private String csignin;
    private int type;
    private long witnessId;
    private String witnessName;
    private String cause;

    public int getMendId() {
        return mendId;
    }

    public void setMendId(int mendId) {
        this.mendId = mendId;
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

    public String getCsignin() {
        return csignin;
    }

    public void setCsignin(String csignin) {
        this.csignin = csignin;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getWitnessId() {
        return witnessId;
    }

    public void setWitnessId(long witnessId) {
        this.witnessId = witnessId;
    }

    public String getWitnessName() {
        return witnessName;
    }

    public void setWitnessName(String witnessName) {
        this.witnessName = witnessName;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "mend{" +
                "mendId=" + mendId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", csignin='" + csignin + '\'' +
                ", type=" + type +
                ", witnessId=" + witnessId +
                ", witnessName='" + witnessName + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
