package org.watch.com.publics.people.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.watch.com.publics.db.mapper.DbMapper;
import org.watch.com.publics.people.mapper.PeopleMapper;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.people.service.PeopleService;
import org.watch.com.util.resultJson.ResponseResult;
import org.watch.com.util.uuidUtil.GetUuid;

import javax.annotation.Resource;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {

    @Resource
    private PeopleMapper mapper;
    @Resource
    private DbMapper mapper2;
    @Autowired
    ResponseResult<PeopleModel> result;

    @Override
    public ResponseResult<PeopleModel> save(PeopleModel model) {
        model.setUuid(GetUuid.getUUID());
        Page<PeopleModel> page = mapper.findByName(model.getName());
        if (page.size() > 0) {
            result.setSuccess(false);
            result.setCode(201);
            result.setData(null);
            result.setMessage("姓名重复");
            return result;
        }
        int i = mapper.save(model);
        switch (i) {
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                result.setData(null);
                result.setMessage(null);
                break;
            default:
                result.setSuccess(false);
                result.setCode(500);
                result.setData(null);
                result.setMessage("添加失败");
        }
        return result;
    }

    @Override
    public ResponseResult<PeopleModel> del(String id) {
        int i = mapper.del(id);
        switch (i) {
            case 1:
                mapper2.del(id);
                result.setSuccess(true);
                result.setCode(200);
                result.setData(null);
                break;
            default:
                result.setSuccess(false);
                result.setCode(500);
                result.setData(null);
        }
        return result;
    }

    @Override
    public ResponseResult<PeopleModel> update(PeopleModel model) {
        int i = mapper.update(model);
        switch (i) {
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                result.setData(null);
                break;
            default:
                result.setSuccess(false);
                result.setCode(500);
                result.setData(null);
        }
        return result;
    }

    @Override
    public ResponseResult<PeopleModel> getById(String id) {
        PeopleModel model = mapper.getById(id);
        if (model == null) {
            result.setSuccess(false);
            result.setCode(404);
            result.setData(null);
        } else {
            result.setSuccess(true);
            result.setCode(200);
            result.setData(model);
        }
        return result;
    }

    @Override
    public ResponseResult<Page<PeopleModel>> find(int pageNow, int pageSize, String search) {
        ResponseResult<Page<PeopleModel>> result = new ResponseResult<>();
        PageHelper.startPage(pageNow, pageSize);
        Page<PeopleModel> page;
        if (search == null || search.isEmpty()) {
            page = mapper.find();
        } else {
            page = mapper.findByName("%" + search + "%");
        }
        if (page.size() <= 0) {
            result.setSuccess(false);
            result.setCode(404);
            result.setData(null);
            result.setMessage("未找到数据");
        } else {
            result.setSuccess(true);
            result.setCode(page.getPages());
            result.setData(page);
            result.setMessage(null);
        }
        return result;
    }
}
