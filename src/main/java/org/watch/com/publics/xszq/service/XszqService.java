package org.watch.com.publics.xszq.service;

import com.github.pagehelper.Page;
import org.watch.com.publics.xszq.model.XszqModel;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface XszqService {

    ResponseResult<XszqModel> save(XszqModel model) throws Exception;

    ResponseResult<XszqModel> del(String id);

    ResponseResult<XszqModel> getById(String id);

    ResponseResult<Page<XszqModel>> find(int pageNow, int pageSize);
    ResponseResult<Page<XszqModel>> find2(int pageNow, int pageSize);
    ResponseResult<Page<XszqModel>> find3(int pageNow, int pageSize);

    ResponseResult<List<PeopleModel>> query(String zqid);
}
