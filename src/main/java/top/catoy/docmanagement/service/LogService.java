package top.catoy.docmanagement.service;

public interface LogService {
    int insertLog(int userId,String opName,String opLabel);
}
