package net.emis.define.dao;

import net.emis.define.model.BaseTableDefine;

public interface BaseTableDefineMapper {
    int deleteByPrimaryKey(String tdUuid);

    int insert(BaseTableDefine record);

    int insertSelective(BaseTableDefine record);

    BaseTableDefine selectByPrimaryKey(String tdUuid);

    int updateByPrimaryKeySelective(BaseTableDefine record);

    int updateByPrimaryKey(BaseTableDefine record);
}