package net.emis.define.dao;

import net.emis.define.model.BaseFieldDefine;

public interface BaseFieldDefineMapper {
    int deleteByPrimaryKey(String fdUuid);

    int insert(BaseFieldDefine record);

    int insertSelective(BaseFieldDefine record);

    BaseFieldDefine selectByPrimaryKey(String fdUuid);

    int updateByPrimaryKeySelective(BaseFieldDefine record);

    int updateByPrimaryKey(BaseFieldDefine record);
}