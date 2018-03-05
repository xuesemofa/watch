package org.watch.com.publics.fzbrq.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.publics.fzbrq.model.FzbrqModel;
import org.watch.com.publics.fzbrq.service.FzbrqService;
import org.watch.com.util.resultJson.ResponseResult;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/fzbrq")
public class fzbrqController {

    @Value("${page.pageSize}")
    private int pageSize;

    @Autowired
    private FzbrqService service;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("/fzbrq/index");
    }

    @RequestMapping(value = "/initData", method = RequestMethod.POST)
    public ResponseResult<Page<FzbrqModel>> initData(@RequestParam("pageNow") int pageNow) {
        return service.find(pageNow, pageSize);
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        return new ModelAndView("/fzbrq/add");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult<FzbrqModel> toAdd(@ModelAttribute("form") FzbrqModel model) {
        return service.save(model);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ResponseResult<FzbrqModel> del(@RequestParam("id") String id) {
        return service.del(id);
    }

}
