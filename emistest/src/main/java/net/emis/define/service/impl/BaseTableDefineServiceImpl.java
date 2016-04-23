package net.emis.define.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.emis.define.dao.BaseTableDefineMapper;
import net.emis.define.model.BaseTableDefine;
import net.emis.define.service.BaseTableDefineServiceI;
import net.emis.util.StringUtil;

@Service("baseTableDefineService")
public class BaseTableDefineServiceImpl implements BaseTableDefineServiceI{

	@Autowired
	private BaseTableDefineMapper tableMapper;
	
	@Override
	public int addTable(BaseTableDefine table) {
		table.setTdUuid(StringUtil.uuid());
		return tableMapper.insertSelective(table);
	}

	@Override
	public int deleteTable(String tableId) {
		return tableMapper.deleteByPrimaryKey(tableId);
	}

	@Override
	public int updateTable(BaseTableDefine table) {
		return tableMapper.updateByPrimaryKeySelective(table);
	}

	@Override
	public BaseTableDefine findTableById(String tableId) {
		return tableMapper.selectByPrimaryKey(tableId);
	}

	@Override
	public List<BaseTableDefine> findTables() {
		// TODO Auto-generated method stub
		return null;
	}

}
