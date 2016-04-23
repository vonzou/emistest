package net.emis.define.service;

import java.util.List;

import net.emis.define.model.BaseTableDefine;

public interface BaseTableDefineServiceI {
	
	int addTable(BaseTableDefine table);
	
	int deleteTable(String tableId);
	
	int updateTable(BaseTableDefine table);
	
	BaseTableDefine findTableById(String tableId);
	
	List<BaseTableDefine> findTables();
}
