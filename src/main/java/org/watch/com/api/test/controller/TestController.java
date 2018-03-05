package org.watch.com.api.test.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.watch.com.publics.db.service.DbService;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.util.resultJson.ResponseResult;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private DbService service;

    @CrossOrigin()
    @RequestMapping("/data")
    public ResponseResult<Page<PeopleModel>> data() {
        return service.find(1, 30, "");
    }
}
