package net.emis.define.dao;

import java.util.List;

import net.emis.define.model.Dictionary;

public interface DictionaryMapper {
    int deleteByPrimaryKey(String dictionaryid);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(String dictionaryid);
    
    List<Dictionary> selectByCode(String dictCode);
    
    List<Dictionary> listAllDict();

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}