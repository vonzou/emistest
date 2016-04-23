package net.emis.define.service;

import java.util.List;

import net.emis.define.model.Dictionary;

public interface DictServiceI {
	
	int addDictionary(Dictionary dict);
	
	int deleteDictionary(String uuid);
	
	int updateDictionary(Dictionary dict);
	
	Dictionary selectDictionary(String uuid);
	
	List<Dictionary> findDictionaryList();
	
	List<Dictionary> findDictByCode(String dictCode);
}
