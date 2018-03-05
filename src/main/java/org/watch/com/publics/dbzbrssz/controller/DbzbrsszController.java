package org.watch.com.publics.dbzbrssz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.publics.dbzbrssz.model.DbzbrsszModel;
import org.watch.com.publics.dbzbrssz.service.DbzbrsszService;
import org.watch.com.util.resultJson.ResponseResult;

import com.github.pagehelper.Page;

@RestController
@RequestMapping("/dbzbrssz")
public class DbzbrsszController {
	
	@Value("${page.pageSize}")
    private int pageSize;

    @Autowired
    private DbzbrsszService service;
	
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("/dbzbrssz/index");
    }
    
    @RequestMapping(value = "/initData", method = RequestMethod.POST)
    public ResponseResult<Page<DbzbrsszModel>> initData(@RequestParam("pageNow") int pageNow) {
        return service.find(pageNow, pageSize);
    }
    
    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        return new ModelAndView("/dbzbrssz/add");
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult<DbzbrsszModel> toAdd(@ModelAttribute("form") DbzbrsszModel model) {
        return service.save(model);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ResponseResult<DbzbrsszModel> del(@RequestParam("id") String id) {
        return service.del(id);
    }
}
