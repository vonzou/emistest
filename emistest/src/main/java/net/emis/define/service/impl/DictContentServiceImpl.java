package net.emis.define.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.emis.define.dao.DictionaryContentMapper;
import net.emis.define.model.DictionaryContent;
import net.emis.define.service.DictContentServiceI;
import net.emis.util.StringUtil;

@Service("dictContentService")
public class DictContentServiceImpl implements DictContentServiceI{

	@Autowired
	private DictionaryContentMapper dictContentMapper;
	
	@Override
	public int addDictConetent(DictionaryContent dictC) {
		dictC.setContentid(StringUtil.uuid());
		return dictContentMapper.insertSelective(dictC);
	}

	@Override
	public int updateDictContent(DictionaryContent dictC) {
		return dictContentMapper.updateByPrimaryKeySelective(dictC);
	}

	@Override
	public List<DictionaryContent> findByDictID(String dictId) {
		return dictContentMapper.findByDictId(dictId);
	}

	@Override
	public DictionaryContent findById(String ctId) {
		return dictContentMapper.selectByPrimaryKey(ctId);
	}

	@Override
	public int deleteById(String ctId) {		
		return dictContentMapper.deleteByPrimaryKey(ctId);
	}

	@Override
	public List<DictionaryContent> findByCode(DictionaryContent cont) {
		return dictContentMapper.findByDictContCode(cont);
	}

	@Override
	public int deleteByDictId(String dictId) {
		return dictContentMapper.deleteByDictId(dictId);
	}

}
