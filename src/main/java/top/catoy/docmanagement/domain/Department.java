package top.catoy.docmanagement.domain;

/**
 * @description: 部门
 * @author: xjn
 * @create: 2019-04-26 08:50
 **/
public class Department {
    private int departmentId;
    private String departmentName;
    private int superId;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getSuperId() {
        return superId;
    }

    public void setSuperId(int superId) {
        this.superId = superId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", superId=" + superId +
                '}';
    }
}
