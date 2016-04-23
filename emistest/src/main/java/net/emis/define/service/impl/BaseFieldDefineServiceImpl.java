package net.emis.define.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.emis.define.dao.BaseFieldDefineMapper;
import net.emis.define.model.BaseFieldDefine;
import net.emis.define.service.BaseFieldDefineServiceI;
import net.emis.util.StringUtil;

public class BaseFieldDefineServiceImpl implements BaseFieldDefineServiceI{

	@Autowired
	private BaseFieldDefineMapper fieldMapper;
	
	@Override
	public int addField(BaseFieldDefine field) {
		field.setFdUuid(StringUtil.uuid());
		return fieldMapper.insertSelective(field);
	}

	@Override
	public int deleteFieldByFid(String fd_uuid) {
		return fieldMapper.deleteByPrimaryKey(fd_uuid);
	}

	@Override
	public int deleteFieldByTid(String td_uuid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFieldByFid(BaseFieldDefine field) {
		return fieldMapper.updateByPrimaryKeySelective(field);
	}

	@Override
	public BaseFieldDefine findFieldByFid(String fd_uuid) {
		return fieldMapper.selectByPrimaryKey(fd_uuid);
	}

	@Override
	public List<BaseFieldDefine> findFieldByTid(String td_uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
