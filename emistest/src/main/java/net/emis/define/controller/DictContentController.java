package net.emis.define.controller;

import java.util.HashMap;
import java.util.List;

import net.emis.define.model.DictionaryContent;
import net.emis.define.service.DictContentServiceI;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

@RequestMapping("/dictContent")
@Controller("dictContentController")
public class DictContentController {
	
	private static Logger log = Logger.getLogger(DictContentController.class);
	
	@Autowired
	private DictContentServiceI contentService;
	
	@RequestMapping("/contentList/{dictid}")
	public String contentList(@PathVariable String dictid, Model model){
		List<DictionaryContent> contList = contentService.findByDictID(dictid);
		log.debug("id 为 " + dictid + " 的字典项信息：" + JSON.toJSONString(contList));
		model.addAttribute("contList", contList);
		model.addAttribute("dictId", dictid);
		//HashMap<String, Object> data = new HashMap<String, Object>();
		//data.put("view", contList);
		//ModelAndView view = new ModelAndView("define/dictContentList", data);
		return "define/dictContentList";
	}
	
	@RequestMapping("/content/{contid}")
	public String getContByid(@PathVariable String contid, Model model){
		log.debug("字典项ID ： " + contid);
		DictionaryContent cont = contentService.findById(contid);
		log.debug("id 为 " + contid + " 的字典项信息 : " + JSON.toJSONString(cont));
		model.addAttribute("dictCont", cont);
		return "define/editDictCont";
	}
	
	@ResponseBody
	@RequestMapping(value = "/editCont", produces = "application/json;charset=utf-8")
	public String editContByid(DictionaryContent cont){
		JSONObject json = new JSONObject();
		log.debug("传入字典项: " + JSON.toJSONString(cont));
		String id = cont.getContentid();
		if(id == null || "".equals(id.trim())){
			json.put("editSucc", false);
			json.put("errorInfo", "修改失败，字典id为空");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		boolean isSucc = contentService.updateDictContent(cont) > 0;
		if(isSucc){
			json.clear();
			json.put("editSucc", true);
			json.put("errorInfo", "修改成功");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		
		json.clear();
		json.put("editSucc", false);
		json.put("errorInfo", "未知原因，修改失败");
		log.debug(json.toJSONString());
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/addCont", produces = "application/json;charset=utf-8")
	public String addDictCont(DictionaryContent dictCont){
		log.debug("入参dictCont : " + JSON.toJSONString(dictCont));
		log.debug("字典编码：" + dictCont.getDictionaryid());
		JSONObject json = new JSONObject();
		String contName = dictCont.getItemname().trim();
		if(dictCont == null 
				|| null == dictCont.getItemname() || "".equals(dictCont.getItemname())
				|| null == dictCont.getItemvalue() || "".equals(dictCont.getItemvalue())
				|| null == dictCont.getDictionaryid() || "".equals(dictCont.getContentid())){
			json.put("addSucc", false);
			json.put("errorInfo", "参数错误,添加失败");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		
		List<DictionaryContent> tempCont = contentService.findByCode(dictCont);
		if(tempCont.size() > 0){
			json.clear();
			json.put("addSucc", false);
			json.put("errorInfo", "该字典项已存在，添加失败");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		
		boolean isSucc = contentService.addDictConetent(dictCont) > 0;
		
		if(isSucc){
			json.clear();
			json.put("addSucc", true);
			json.put("errorInfo", "添加成功");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		
		json.clear();
		json.put("addSucc", false);
		json.put("errorInfo", "未知原因，添加失败");
		log.debug(json.toJSONString());
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value="/delCont/{contids}", produces = "application/json;charset=utf-8")
	public String deleteContentById(@PathVariable String contids){
		JSONObject json = new JSONObject();
		log.debug("删除字典项 ids : " + contids);
		if(contids == null || "".equals(contids.trim())){
			json.put("delSucc", false);
			json.put("errorInfo", "参数为空，删除失败");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		String []ids = contids.split(",");
		int tempSucc = 0;
		int tempFail = 0;
		for(String id : ids){
			boolean isSucc = contentService.deleteById(id) > 0;
			if(isSucc){
				tempSucc ++;
			} else {
				tempFail ++;
			}
		}
		if(tempSucc == ids.length){
			json.clear();
			json.put("delSucc", true);
			json.put("errorInfo", "删除成功，" + tempSucc + "条数据受影响");
			log.debug(json.toJSONString());
			return json.toJSONString();
		}
		json.clear();
		json.put("delSucc", false);
		json.put("errorInfo", "删除失败 ,e = " + tempSucc + "条数据删除成功， " + tempFail + "条数据删除失败");
		log.debug(json.toJSONString());
		return json.toJSONString();
	}
}
