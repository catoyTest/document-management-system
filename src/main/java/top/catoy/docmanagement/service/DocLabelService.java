package top.catoy.docmanagement.service;

import top.catoy.docmanagement.domain.DocLabel;
import top.catoy.docmanagement.domain.ResponseBean;

import javax.print.Doc;

public interface DocLabelService {
    ResponseBean insertDocLabel(DocLabel docLabel);

//    ResponseBean delDocLabelByName(String docLabelName);

    ResponseBean delDocLabel(DocLabel docLabel);

//    ResponseBean editDocLabelByName(String docLabelName);

    ResponseBean editDocLabel(DocLabel docLabel);

    ResponseBean getAllDocLabels();

    ResponseBean getSonDocLabels(int superId);

    ResponseBean getDocLabelById(int id);
}
