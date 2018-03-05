package org.watch.com.publics.people.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.people.service.PeopleService;
import org.watch.com.util.resultJson.ResponseResult;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    @Value("${page.pageSize}")
    private int pageSize;

    @Autowired
    private PeopleService service;

    @Autowired
    private ResponseResult<PeopleModel> result;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("/people/index");
    }

    @RequestMapping(value = "/initData", method = RequestMethod.POST)
    public ResponseResult<Page<PeopleModel>> init(@RequestParam("pageNow") int pageNow,
                                                  @RequestParam(value = "search", required = false) String search) {
        return service.find(pageNow, pageSize, search);
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd() {
        return new ModelAndView("/people/add");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult<PeopleModel> add(@Valid @ModelAttribute("form") PeopleModel model,
                                           BindingResult bindingResult) {
        //数据验证
        if (bindingResult.hasErrors()) {
            result.setSuccess(false);
            result.setCode(400);
            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        return service.save(model);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ResponseResult<PeopleModel> del(@RequestParam("id") String id) {
        return service.del(id);
    }
}
