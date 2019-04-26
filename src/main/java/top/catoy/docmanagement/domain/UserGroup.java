package top.catoy.docmanagement.domain;

/**
 * @description: 权限组
 * @author: xjn
 * @create: 2019-04-26 09:03
 **/
public class UserGroup {
    private int groupId;
    private String groupName;
    private String groupPermission;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupPermission() {
        return groupPermission;
    }

    public void setGroupPermission(String groupPermission) {
        this.groupPermission = groupPermission;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupPermission='" + groupPermission + '\'' +
                '}';
    }
}
