package net.emis.define.model;

public class DictionaryContent {
    private String contentid;

    private String dictionaryid;

    private String itemname;

    private String itemvalue;

    private String description;

    private String status;

    private Integer sortinfo;

    private String creater;

    private String parentcontentid;

    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid == null ? null : contentid.trim();
    }

    public String getDictionaryid() {
        return dictionaryid;
    }

    public void setDictionaryid(String dictionaryid) {
        this.dictionaryid = dictionaryid == null ? null : dictionaryid.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue == null ? null : itemvalue.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getSortinfo() {
        return sortinfo;
    }

    public void setSortinfo(Integer sortinfo) {
        this.sortinfo = sortinfo;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getParentcontentid() {
        return parentcontentid;
    }

    public void setParentcontentid(String parentcontentid) {
        this.parentcontentid = parentcontentid == null ? null : parentcontentid.trim();
    }
}