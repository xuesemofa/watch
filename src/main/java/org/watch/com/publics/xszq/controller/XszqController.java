package org.watch.com.publics.xszq.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.xszq.model.XszqModel;
import org.watch.com.publics.xszq.service.XszqService;
import org.watch.com.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/xszq")
public class XszqController {

    @Value("${page.pageSize}")
    private int pageSize;

    @Autowired
    private XszqService service;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("/xszq/index");
    }

    /**
     * 所有周期
     *
     * @param pageNow
     * @return
     */
    @RequestMapping(value = "/initData", method = RequestMethod.GET)
    public ResponseResult<Page<XszqModel>> initData(@RequestParam("pageNow") int pageNow) {
        return service.find(pageNow, pageSize);
    }

    /**
     * 未设置带班的周期
     *
     * @param pageNow
     * @return
     */
    @RequestMapping(value = "/initData2", method = RequestMethod.GET)
    public ResponseResult<Page<XszqModel>> initData2(@RequestParam("pageNow") int pageNow) {
        return service.find2(pageNow, pageSize);
    }

    /**
     * 未设置值班的周期
     *
     * @param pageNow
     * @return
     */
    @RequestMapping(value = "/initData3", method = RequestMethod.GET)
    public ResponseResult<Page<XszqModel>> initData3(@RequestParam("pageNow") int pageNow) {
        return service.find3(pageNow, pageSize);
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        return new ModelAndView("/xszq/add");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult<XszqModel> add(@ModelAttribute("form") XszqModel model) throws Exception {
        return service.save(model);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ModelAndView query(@RequestParam("id") String id) {
        return new ModelAndView("/xszq/query")
                .addObject("id", id);
    }

    @RequestMapping(value = "/queryData", method = RequestMethod.POST)
    public ResponseResult<List<PeopleModel>> queryData(@RequestParam("id") String id) {
        return service.query(id);
    }

    @RequestMapping(value = "/sz", method = RequestMethod.GET)
    public ModelAndView sz(@RequestParam("id") String id) {
        return new ModelAndView("/xszq/sz")
                .addObject("id", id);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ResponseResult<XszqModel> del(@RequestParam("id") String id) {
        return service.del(id);
    }
}
