package org.watch.com.online.xsdbry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.online.xsdbry.model.XsdbryModel;
import org.watch.com.online.xsdbry.service.XsdbryService;
import org.watch.com.util.resultJson.ResponseResult;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/xsdbry")
public class XsdbryController {

    @Autowired
    private XsdbryService service;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("/xsdbry/index");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult<XsdbryModel> add(@RequestParam("id") String id) throws Exception {
        return service.save(id);
    }

    /**
     * 手动设置
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/sdsz", method = RequestMethod.GET)
    public ModelAndView sdsz(@RequestParam("id") String id) {
        return new ModelAndView("/xsdbry/sdsz");
    }
}
