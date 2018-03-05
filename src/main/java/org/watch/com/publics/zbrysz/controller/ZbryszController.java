package org.watch.com.publics.zbrysz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.publics.zbrysz.model.ZbryModel;
import org.watch.com.publics.zbrysz.service.ZbryService;
import org.watch.com.util.resultJson.ResponseResult;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/zbrysz")
public class ZbryszController {

    @Autowired
    private ZbryService service;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("/zbrysz/index");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult<ZbryModel> add(@RequestParam("id") String id) throws Exception {
        return service.save(id);
    }

}
