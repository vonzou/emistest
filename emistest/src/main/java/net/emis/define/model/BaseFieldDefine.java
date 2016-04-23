package net.emis.define.model;

public class BaseFieldDefine {
    private String fdUuid;

    private String fdTableuuid;

    private String fdCode;

    private String fdName;

    private String fdIskey;

    private String fdFieldtype;

    private Integer fdLength;

    private Integer fdDecimal;

    private String fdDictioncode;

    private String fdDefault;

    private String fdNotnull;

    private String fdUsable;

    private String fdDescribe;

    private String fdSourcetype;

    private String fdFormula;

    private String fdGetsource;

    private String fdGetfield;

    private String fdWhereclause;

    private String fdChecktype;

    public String getFdUuid() {
        return fdUuid;
    }

    public void setFdUuid(String fdUuid) {
        this.fdUuid = fdUuid == null ? null : fdUuid.trim();
    }

    public String getFdTableuuid() {
        return fdTableuuid;
    }

    public void setFdTableuuid(String fdTableuuid) {
        this.fdTableuuid = fdTableuuid == null ? null : fdTableuuid.trim();
    }

    public String getFdCode() {
        return fdCode;
    }

    public void setFdCode(String fdCode) {
        this.fdCode = fdCode == null ? null : fdCode.trim();
    }

    public String getFdName() {
        return fdName;
    }

    public void setFdName(String fdName) {
        this.fdName = fdName == null ? null : fdName.trim();
    }

    public String getFdIskey() {
        return fdIskey;
    }

    public void setFdIskey(String fdIskey) {
        this.fdIskey = fdIskey == null ? null : fdIskey.trim();
    }

    public String getFdFieldtype() {
        return fdFieldtype;
    }

    public void setFdFieldtype(String fdFieldtype) {
        this.fdFieldtype = fdFieldtype == null ? null : fdFieldtype.trim();
    }

    public Integer getFdLength() {
        return fdLength;
    }

    public void setFdLength(Integer fdLength) {
        this.fdLength = fdLength;
    }

    public Integer getFdDecimal() {
        return fdDecimal;
    }

    public void setFdDecimal(Integer fdDecimal) {
        this.fdDecimal = fdDecimal;
    }

    public String getFdDictioncode() {
        return fdDictioncode;
    }

    public void setFdDictioncode(String fdDictioncode) {
        this.fdDictioncode = fdDictioncode == null ? null : fdDictioncode.trim();
    }

    public String getFdDefault() {
        return fdDefault;
    }

    public void setFdDefault(String fdDefault) {
        this.fdDefault = fdDefault == null ? null : fdDefault.trim();
    }

    public String getFdNotnull() {
        return fdNotnull;
    }

    public void setFdNotnull(String fdNotnull) {
        this.fdNotnull = fdNotnull == null ? null : fdNotnull.trim();
    }

    public String getFdUsable() {
        return fdUsable;
    }

    public void setFdUsable(String fdUsable) {
        this.fdUsable = fdUsable == null ? null : fdUsable.trim();
    }

    public String getFdDescribe() {
        return fdDescribe;
    }

    public void setFdDescribe(String fdDescribe) {
        this.fdDescribe = fdDescribe == null ? null : fdDescribe.trim();
    }

    public String getFdSourcetype() {
        return fdSourcetype;
    }

    public void setFdSourcetype(String fdSourcetype) {
        this.fdSourcetype = fdSourcetype == null ? null : fdSourcetype.trim();
    }

    public String getFdFormula() {
        return fdFormula;
    }

    public void setFdFormula(String fdFormula) {
        this.fdFormula = fdFormula == null ? null : fdFormula.trim();
    }

    public String getFdGetsource() {
        return fdGetsource;
    }

    public void setFdGetsource(String fdGetsource) {
        this.fdGetsource = fdGetsource == null ? null : fdGetsource.trim();
    }

    public String getFdGetfield() {
        return fdGetfield;
    }

    public void setFdGetfield(String fdGetfield) {
        this.fdGetfield = fdGetfield == null ? null : fdGetfield.trim();
    }

    public String getFdWhereclause() {
        return fdWhereclause;
    }

    public void setFdWhereclause(String fdWhereclause) {
        this.fdWhereclause = fdWhereclause == null ? null : fdWhereclause.trim();
    }

    public String getFdChecktype() {
        return fdChecktype;
    }

    public void setFdChecktype(String fdChecktype) {
        this.fdChecktype = fdChecktype == null ? null : fdChecktype.trim();
    }
}