package net.emis.define.model;

public class BaseTableDefine {
    private String tdUuid;

    private String tdCode;

    private String tdName;

    private String tdUsable;

    private String tdDescribe;

    public String getTdUuid() {
        return tdUuid;
    }

    public void setTdUuid(String tdUuid) {
        this.tdUuid = tdUuid == null ? null : tdUuid.trim();
    }

    public String getTdCode() {
        return tdCode;
    }

    public void setTdCode(String tdCode) {
        this.tdCode = tdCode == null ? null : tdCode.trim();
    }

    public String getTdName() {
        return tdName;
    }

    public void setTdName(String tdName) {
        this.tdName = tdName == null ? null : tdName.trim();
    }

    public String getTdUsable() {
        return tdUsable;
    }

    public void setTdUsable(String tdUsable) {
        this.tdUsable = tdUsable == null ? null : tdUsable.trim();
    }

    public String getTdDescribe() {
        return tdDescribe;
    }

    public void setTdDescribe(String tdDescribe) {
        this.tdDescribe = tdDescribe == null ? null : tdDescribe.trim();
    }
}