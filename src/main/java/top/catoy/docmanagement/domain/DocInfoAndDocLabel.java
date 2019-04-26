package top.catoy.docmanagement.domain;

/**
 * @description: 文档信息和文档标签中间表
 * @author: xjn
 * @create: 2019-04-26 08:55
 **/
public class DocInfoAndDocLabel {
    private int dLabelId;
    private int labelId;
    private int docId;

    public int getdLabelId() {
        return dLabelId;
    }

    public void setdLabelId(int dLabelId) {
        this.dLabelId = dLabelId;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    @Override
    public String toString() {
        return "DocInfoAndDocLabel{" +
                "dLabelId=" + dLabelId +
                ", labelId=" + labelId +
                ", docId=" + docId +
                '}';
    }
}
