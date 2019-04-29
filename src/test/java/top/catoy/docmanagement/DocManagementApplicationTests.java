package top.catoy.docmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.catoy.docmanagement.domain.Department;
import top.catoy.docmanagement.domain.DocLabel;
import top.catoy.docmanagement.domain.Log;
import top.catoy.docmanagement.mapper.DepartmentMapper;
import top.catoy.docmanagement.mapper.DocLabelMapper;
import top.catoy.docmanagement.mapper.LogMapper;
import top.catoy.docmanagement.service.DocLabelService;
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
    private DocLabelMapper docLabelMapper;

    @Autowired
    private DocLabelService docLabelService;

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
    public void testDocLabelMapper(){
        DocLabel docLabel = new DocLabel();
        DocLabel docLabelNew = new DocLabel();
        docLabel.setDocLabelName("图片");
        docLabelNew.setDocLabelName("视频");

        int sum = docLabelMapper.insertLabel(docLabel);
        System.out.println(docLabel.toString());
        if(sum > 0){
            System.out.println("----------标签插入成功");
        }else{
            System.out.println("----------标签插入失败");
        }

//        List<DocLabel> docLabels = docLabelMapper.getAllDocLabels();
//        if(docLabels != null){
//            System.out.println("----------查询成功");
//            System.out.println(docLabels.toString());
//        }else{
//            System.out.println("----------查询失败");
//        }
//
//        int sum3 = docLabelMapper.editDocLabel(docLabelNew);
//        if(sum3 > 0){
//            System.out.println("----------标签修改成功");
//        }else{
//            System.out.println("----------标签修改失败");
//        }
//
//        int sum2 = docLabelMapper.delDocLabel(docLabel);
//        if(sum2 > 0){
//            System.out.println("----------标签删除成功");
//        }else{
//            System.out.println("----------标签删除失败");
//        }
    }

    @Test
    public void testDocLabelService(){
//        DocLabel docLabel = new DocLabel();
//        DocLabel docLabelNew = new DocLabel();
//        docLabel.setDocLabelName("图片");
//        docLabelNew.setDocLabelName("视频");
//        System.out.println(docLabelService.insertDocLabel(docLabel).toString());
//        System.out.println(docLabelService.editDocLabel(docLabelNew).toString());
//        docLabel = docLabelNew;
//        System.out.println(docLabelService.getAllDocLabels().toString());
//        System.out.println(docLabelService.delDocLabel(docLabel).toString());
        System.out.println(docLabelService.getSonDocLabels(19));
    }

}
