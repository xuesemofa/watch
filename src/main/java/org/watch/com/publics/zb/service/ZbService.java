package org.watch.com.publics.zb.service;

import java.util.Map;

import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.zb.model.ZbModel;
import org.watch.com.util.resultJson.ResponseResult;

import com.github.pagehelper.Page;

public interface ZbService {
	ResponseResult<ZbModel> add(ZbModel model);

    ResponseResult<ZbModel> del(String id);

    ResponseResult<Page<PeopleModel>> find(int pageNow, int pageSize, String name);

    ResponseResult<ZbModel> update(String id, int code);

    ResponseResult<ZbModel> updates(Map<String, Integer> map);
}
