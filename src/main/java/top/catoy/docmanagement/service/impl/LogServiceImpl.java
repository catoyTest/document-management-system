package top.catoy.docmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.catoy.docmanagement.domain.Log;
import top.catoy.docmanagement.mapper.LogMapper;
import top.catoy.docmanagement.service.LogService;

/**
 * @description:
 * @author: xjn
 * @create: 2019-04-27 15:25
 **/
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public int insertLog(int userId, String opName, String opLabel) {
        Log log = new Log();
        log.setUserId(userId);
        log.setOpName(opName);
        log.setOpLabel(opLabel);
        return logMapper.insertLog(log);
    }
}
