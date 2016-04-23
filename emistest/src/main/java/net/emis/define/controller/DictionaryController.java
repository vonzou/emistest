package net.emis.define.controller;

import java.util.List;

import net.emis.define.model.Dictionary;
import net.emis.define.service.DictServiceI;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
	
	private static Logger log = Logger.getLogger(DictionaryController.class);
	
	@Autowired
	private DictServiceI dictService;
	
	@ResponseBody
	@RequestMapping("/showDict")
	public List<Dictionary> listDict(){
		List<Dictionary> dictList = dictService.findDictionaryList();
		log.debug("dictList : " + JSON.toJSONString(dictList));
		return dictList;
	}
	
	@ResponseBody
	@RequestMapping(value="/addDict",produces="application/json;charset=utf-8")
	public String addDict(Dictionary dict, Model model){
		log.debug("data from client : " + JSON.toJSONString(dict));
		String dictCode = dict.getDictionarycode();
		JSONObject json = new JSONObject();
		if(dictCode == null || "".equals(dictCode)){
			json.put("addSucc", false);
			json.put("errorMsg", "添加字典失败，编码不能为空！");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		List<Dictionary> dictList = dictService.findDictByCode(dict.getDictionarycode());
		log.debug("database find result : " + JSON.toJSONString(dictList));
			
		if(dictList != null && dictList.size() > 0){
			json.put("addSucc", false);
			json.put("errorMsg", "添加字典失败，字典编码已存在");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		
		boolean isSucc = dictService.addDictionary(dict) > 0;
		
		if(isSucc){
			json.clear();
			json.put("addSucc", true);
			json.put("errorMsg", "添加字典成功");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		
		json.clear();
		json.put("addSucc", false);
		json.put("errorMsg", "添加字典失败，未知错误");
		log.debug(json.toJSONString());
		
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping("/deleteDict/{ids}")
	public String deleteDict(@PathVariable String ids){
		log.debug("入参 ids : " + ids);
		String []idList = ids.split(",");
		for(String id : idList){
			int result = dictService.deleteDictionary(id);
			log.debug("ids : " + id + "删除成功 ？" + (result > 0));
		}
		return "";
	}
}
