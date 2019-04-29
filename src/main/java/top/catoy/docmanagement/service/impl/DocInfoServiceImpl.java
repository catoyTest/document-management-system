package top.catoy.docmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.catoy.docmanagement.domain.DocInfo;
import top.catoy.docmanagement.mapper.DocInfoMapper;
import top.catoy.docmanagement.service.DocInfoService;


@Service
public class DocInfoServiceImpl implements DocInfoService {


    @Autowired
    private DocInfoMapper docInfoMapper;

    @Override
    public int insertDocInfo(DocInfo docInfo) {
        return docInfoMapper.insertDocInfo(docInfo);
    }



}
