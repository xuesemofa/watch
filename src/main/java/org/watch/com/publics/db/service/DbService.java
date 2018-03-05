package org.watch.com.publics.db.service;

import com.github.pagehelper.Page;
import org.watch.com.publics.db.model.DbModel;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.util.resultJson.ResponseResult;

import java.util.Map;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface DbService {

    ResponseResult<DbModel> add(DbModel model);

    ResponseResult<DbModel> del(String id);

    ResponseResult<Page<PeopleModel>> find(int pageNow, int pageSize, String name);

    ResponseResult<DbModel> update(String id, int code);

    ResponseResult<DbModel> updates(Map<String, Integer> map);

}
