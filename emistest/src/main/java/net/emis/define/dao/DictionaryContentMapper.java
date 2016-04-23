package net.emis.define.dao;

import java.util.List;

import net.emis.define.model.DictionaryContent;

public interface DictionaryContentMapper {
	
    int deleteByPrimaryKey(String contentid);

    int deleteByDictId(String dictId);
    
    int insert(DictionaryContent record);

    int insertSelective(DictionaryContent record);

    DictionaryContent selectByPrimaryKey(String contentid);
    
    List<DictionaryContent> findByDictId(String dictId);
    
    List<DictionaryContent> findByDictContCode(DictionaryContent cont);
    
    int updateByPrimaryKeySelective(DictionaryContent record);

    int updateByPrimaryKey(DictionaryContent record);
}