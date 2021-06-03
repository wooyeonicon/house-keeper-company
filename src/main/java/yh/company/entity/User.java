package yh.company.entity;

public class User {
    private long userId;//用户工号
    private String username;//用户姓名
    private String sex;//用户性别
    private long idCard;//用户身份证
    private long phone;//用户电话
    private String email;//用户邮箱
    private int departmentId;//部门
    private long card;//银行卡
    private String password;//用户密码

    private int basepay;//基础工资
    private int reward;//奖金
    private int allowance;//补贴

    private int authority;//权限

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public long getCard() {
        return card;
    }

    public void setCard(long card) {
        this.card = card;
    }

    public int getBasepay() {
        return basepay;
    }

    public void setBasepay(int basepay) {
        this.basepay = basepay;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", idCard=" + idCard +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", departmentId=" + departmentId +
                ", card=" + card +
                ", password='" + password + '\'' +
                ", basepay=" + basepay +
                ", reward=" + reward +
                ", allowance=" + allowance +
                ", authority=" + authority +
                '}';
    }
}
