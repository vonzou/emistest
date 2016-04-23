package net.emis.define.model;

public class Dictionary {
    private String dictionaryid;

    private String dictionarycode;

    private String dictionaryname;

    private String note;

    private String enabledelete;

    private String creater;

    public String getDictionaryid() {
        return dictionaryid;
    }

    public void setDictionaryid(String dictionaryid) {
        this.dictionaryid = dictionaryid == null ? null : dictionaryid.trim();
    }

    public String getDictionarycode() {
		return dictionarycode;
	}

	public void setDictionarycode(String dictionarycode) {
		this.dictionarycode = dictionarycode == null ? null : dictionarycode.trim();
	}
	
	public String getDictionaryname() {
	    return dictionaryname;
	}

	public void setDictionaryname(String dictionaryname) {
        this.dictionaryname = dictionaryname == null ? null : dictionaryname.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getEnabledelete() {
        return enabledelete;
    }

    public void setEnabledelete(String enabledelete) {
        this.enabledelete = enabledelete == null ? null : enabledelete.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }
}