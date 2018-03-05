package org.watch.com.publics.people.service;

import com.github.pagehelper.Page;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.util.resultJson.ResponseResult;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface PeopleService {
    /**
     * 新增人员
     *
     * @param model
     * @return
     */
    ResponseResult<PeopleModel> save(PeopleModel model);

    /**
     * 删除人员
     *
     * @param id
     * @return
     */
    ResponseResult<PeopleModel> del(String id);

    /**
     * 更改人员
     *
     * @param model
     * @return
     */
    ResponseResult<PeopleModel> update(PeopleModel model);

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    ResponseResult<PeopleModel> getById(String id);

    /**
     * 分页查询
     *
     * @return
     */
    ResponseResult<Page<PeopleModel>> find(int pageNow,int pageSize,String search);

}
