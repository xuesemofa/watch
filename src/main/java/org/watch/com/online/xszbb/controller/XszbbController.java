package org.watch.com.online.xszbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.xszq.service.XszqService;
import org.watch.com.publics.zbrysz.model.ZbryModel;
import org.watch.com.publics.zbrysz.service.ZbryService;
import org.watch.com.util.excel.CreateSimpleExcelToDisk;
import org.watch.com.util.files.FileTool;
import org.watch.com.util.resultJson.ResponseResult;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/xszbb")
public class XszbbController {

    @Autowired
    private XszqService service;
    @Autowired
    private ZbryService service2;

    @RequestMapping("/init")
    public ModelAndView init() {
        return new ModelAndView("/xszbb/index");
    }

    @RequestMapping("/query")
    public ModelAndView init(@RequestParam("id") String id) {
        return new ModelAndView("/xszbb/query")
                .addObject("id", id);
    }

    @RequestMapping(value = "/queryData", method = RequestMethod.POST)
    public Map<String, Object> queryData(@RequestParam("id") String id) {
        ResponseResult<List<PeopleModel>> result = service.query(id);
        List<ZbryModel> query = service2.query(id);
        Map<String, Object> map = new HashMap<>();
        if (result.getData() != null && result.getData().size() > 0) {
            map.put("db", result.getData());
        }
        if (query.size() > 0) {
            map.put("zb", query);
        }
        return map;
    }

    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public void export(@RequestParam("name") String name,
                       @RequestParam("title") String title,
                       @RequestParam("data") String data,
                       HttpServletResponse response) throws Exception {
//        导出
        String s = CreateSimpleExcelToDisk.strToJs(name, title, data, null, response);
//        下载
        FileTool.downloadFile(s, response);
    }
}
