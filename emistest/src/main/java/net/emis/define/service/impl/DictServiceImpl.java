package net.emis.define.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.emis.define.dao.DictionaryMapper;
import net.emis.define.model.Dictionary;
import net.emis.define.service.DictServiceI;
import net.emis.util.StringUtil;

@Service("dictionaryService")
public class DictServiceImpl implements DictServiceI{

	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Override
	public int addDictionary(Dictionary dict) {
		dict.setDictionaryid(StringUtil.uuid());
		return dictionaryMapper.insertSelective(dict);
	}

	@Override
	public int deleteDictionary(String uuid) {
		return dictionaryMapper.deleteByPrimaryKey(uuid);
	}

	@Override
	public int updateDictionary(Dictionary dict) {
		return dictionaryMapper.updateByPrimaryKeySelective(dict);
	}

	@Override
	public Dictionary selectDictionary(String uuid) {
		return dictionaryMapper.selectByPrimaryKey(uuid);
	}

	@Override
	public List<Dictionary> findDictionaryList() {
		return dictionaryMapper.listAllDict();
	}

	@Override
	public List<Dictionary> findDictByCode(String dictCode) {
		return dictionaryMapper.selectByCode(dictCode);
	}

}
