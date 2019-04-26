package top.catoy.docmanagement.domain;

/**
 * @description: 用户
 * @author: xjn
 * @create: 2019-04-26 09:01
 **/
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private int groupId;
    private int departmentId;
    private int userLock;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getUserLock() {
        return userLock;
    }

    public void setUserLock(int userLock) {
        this.userLock = userLock;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", groupId=" + groupId +
                ", departmentId=" + departmentId +
                ", userLock=" + userLock +
                '}';
    }
}
