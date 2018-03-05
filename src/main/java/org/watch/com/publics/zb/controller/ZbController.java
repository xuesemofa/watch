package org.watch.com.publics.zb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.zb.model.ZbModel;
import org.watch.com.publics.zb.service.ZbService;
import org.watch.com.util.resultJson.ResponseResult;

import com.github.pagehelper.Page;

@RestController
@RequestMapping("/zb")
public class ZbController {

	 @Value("${page.pageSize}")
	    private int pageSize;

	    @Autowired
	    private ZbService service;

	    @RequestMapping(value = "/init", method = RequestMethod.GET)
	    public ModelAndView init() {
	        return new ModelAndView("/zb/index");
	    }

	    @RequestMapping(value = "/initData", method = RequestMethod.POST)
	    public ResponseResult<Page<PeopleModel>> init(@RequestParam("pageNow") int pageNow,
	                                                  @RequestParam(value = "search", required = false) String search) {
	        return service.find(pageNow, pageSize, search);
	    }

	    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
	    public ModelAndView toAdd() {
	        return new ModelAndView("/zb/add");
	    }

	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public ResponseResult<ZbModel> add(@RequestParam("id") String id) {
	    	ZbModel d = new ZbModel();
	        d.setPeople_id(id);
	        return service.add(d);
	    }

	    @RequestMapping(value = "/del", method = RequestMethod.GET)
	    public ResponseResult<ZbModel> del(@RequestParam("id") String id) {
	        return service.del(id);
	    }

	    @RequestMapping(value = "/setCode", method = RequestMethod.GET)
	    public ModelAndView setCode(@RequestParam("sex") String sex) {
	        return new ModelAndView("/zb/code")
	                .addObject("sex", sex);
	    }

	    @RequestMapping(value = "/setCodeSave", method = RequestMethod.POST)
	    public ResponseResult<ZbModel> setCodeSave(@RequestParam("code") String code) {
	        String[] split = code.split(",");
	        Map<String, Integer> map = new HashMap<>();
	        for (String s : split) {
	            map.put(s.split("-")[0], Integer.parseInt(s.split("-")[1]));
	        }
	        return service.updates(map);
	    }
}
