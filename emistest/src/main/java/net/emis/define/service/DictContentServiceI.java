package net.emis.define.service;

import java.util.List;

import net.emis.define.model.DictionaryContent;

public interface DictContentServiceI {
	
	int addDictConetent(DictionaryContent dictC);
	
	int deleteByDictId(String dictId);
	
	int deleteById(String ctId);
	
	int updateDictContent(DictionaryContent dictC);
	
	List<DictionaryContent> findByDictID(String dictId);
	
	List<DictionaryContent> findByCode(DictionaryContent cont);
	
	DictionaryContent findById(String ctId);
	
}
