package net.emis.define.service;

import java.util.List;

import net.emis.define.model.BaseFieldDefine;

public interface BaseFieldDefineServiceI {

	int addField(BaseFieldDefine field);
	
	int deleteFieldByFid(String fd_uuid);
	
	int deleteFieldByTid(String td_uuid);
	
	int updateFieldByFid(BaseFieldDefine field);
	
	BaseFieldDefine findFieldByFid(String fd_uuid);
	
	List<BaseFieldDefine> findFieldByTid(String td_uuid);
}
