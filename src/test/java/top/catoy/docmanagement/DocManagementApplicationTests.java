package top.catoy.docmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.catoy.docmanagement.domain.Department;
import top.catoy.docmanagement.domain.DocInfo;
import top.catoy.docmanagement.domain.Log;
import top.catoy.docmanagement.mapper.DepartmentMapper;
import top.catoy.docmanagement.mapper.LogMapper;
import top.catoy.docmanagement.service.DocInfoService;
import top.catoy.docmanagement.service.LogService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class DocManagementApplicationTests {
    @Autowired
    private LogMapper logMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private LogService logService;


    @Autowired
    private DocInfoService docInfoService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testLogMapper(){
        Log log = new Log();
        log.setOpLabel("用户操作");
        log.setOpName("用户登入");
        log.setUserId(1);
        List<Log> logs = logMapper.getAllLogs();
        System.out.println("查询Id为1的日志:"+logMapper.selectLogById(1).toString());
        System.out.println("查询所有日志:"+logs.toString());
    }

    @Test
    public void testLogService(){
        int sun = 0;
        sun = logService.insertLog(1,"删除用户","用户管理");
        if(sun > 0){
            System.out.println("日志插入成功");
        }else {
            System.out.println("日志插入失败");
        }

    }

    @Test
    public void testDepartmentMapper(){
        Department department = new Department();
        Department department1 = new Department();
        department.setDepartmentName("丽水学院");
        department1.setDepartmentName("工学院");
        department1.setSuperId(1);
        departmentMapper.insertDepartment(department);
        departmentMapper.insertDepartment(department1);
        System.out.println("得到所有部门信息"+departmentMapper.getAllDepartments().toString());
    }


    @Test
    public void insertDocInfo(){
        DocInfo docInfo = new DocInfo();
        docInfo.setDocId(4);
        docInfo.setDocName("水浒");
        docInfo.setDocSavePath("d://sxito");
        docInfo.setSuffixName(".txt");
        docInfo.setUserId(2);
        docInfoService.insertDocInfo(docInfo);
    }





    @Test
    public void CreateTag(){

    }

}
