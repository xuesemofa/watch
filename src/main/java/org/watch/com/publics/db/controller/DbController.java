package org.watch.com.publics.db.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.publics.db.model.DbModel;
import org.watch.com.publics.db.service.DbService;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.util.resultJson.ResponseResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/db")
public class DbController {

    @Value("${page.pageSize}")
    private int pageSize;

    @Autowired
    private DbService service;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("/db/index");
    }

    @RequestMapping(value = "/initData", method = RequestMethod.POST)
    public ResponseResult<Page<PeopleModel>> init(@RequestParam("pageNow") int pageNow,
                                                  @RequestParam(value = "search", required = false) String search) {
        return service.find(pageNow, pageSize, search);
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        return new ModelAndView("/db/add");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult<DbModel> add(@RequestParam("id") String id) {
        DbModel d = new DbModel();
        d.setPeople_id(id);
        return service.add(d);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ResponseResult<DbModel> del(@RequestParam("id") String id) {
        return service.del(id);
    }

    @RequestMapping(value = "/setCode", method = RequestMethod.GET)
    public ModelAndView setCode(@RequestParam("sex") String sex) {
        return new ModelAndView("/db/code")
                .addObject("sex", sex);
    }

    @RequestMapping(value = "/setCodeSave", method = RequestMethod.POST)
    public ResponseResult<DbModel> setCodeSave(@RequestParam("code") String code) {
        String[] split = code.split(",");
        Map<String, Integer> map = new HashMap<>();
        for (String s : split) {
            map.put(s.split("-")[0], Integer.parseInt(s.split("-")[1]));
        }
        return service.updates(map);
    }
}
