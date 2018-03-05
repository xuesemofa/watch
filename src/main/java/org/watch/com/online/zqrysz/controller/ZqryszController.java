package org.watch.com.online.zqrysz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.online.xsdbry.model.XsdbryModel;
import org.watch.com.util.resultJson.ResponseResult;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/zqrysz")
public class ZqryszController {

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("/zqrysz/index");
    }

    @RequestMapping(value = "/initData", method = RequestMethod.POST)
    public ResponseResult<XsdbryModel> initData(@RequestParam("pageNow") int pageNow) {
        return new ResponseResult<>();
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        return new ModelAndView("/zqrysz/add");
    }
}
