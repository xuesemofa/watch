package org.watch.com.publics.db.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.watch.com.publics.db.mapper.DbMapper;
import org.watch.com.publics.db.model.DbModel;
import org.watch.com.publics.db.service.DbService;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.util.resultJson.ResponseResult;
import org.watch.com.util.uuidUtil.GetUuid;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Service
@Transactional
public class DbServiceImpl implements DbService {

    @Resource
    private DbMapper mapper;

    @Override
    public ResponseResult<DbModel> add(DbModel model) {
        ResponseResult<DbModel> result = new ResponseResult<>();
        DbModel model1 = mapper.getByPId(model.getPeople_id());
        if (model1 != null) {
            result.setSuccess(false);
            result.setMessage("此人已存在");
            return result;
        }
        model.setUuid(GetUuid.getUUID());
        int i = mapper.add(model);
        switch (i) {
            case 1:
                result.setSuccess(true);
                break;
            default:
                result.setSuccess(false);
                result.setMessage("添加失败");
        }
        return result;
    }

    @Override
    public ResponseResult<DbModel> del(String id) {
        ResponseResult<DbModel> result = new ResponseResult<>();
        int i = mapper.del(id);
        switch (i) {
            case 1:
                result.setSuccess(true);
                break;
            default:
                result.setSuccess(false);
                result.setMessage("删除失败");
        }
        return result;
    }

    @Override
    public ResponseResult<Page<PeopleModel>> find(int pageNow, int pageSize, String name) {
        ResponseResult<Page<PeopleModel>> result = new ResponseResult<>();
        PageHelper.startPage(pageNow, pageSize);
        Page<PeopleModel> page;
        if (name == null || name.isEmpty())
            page = mapper.find();
        else
            page = mapper.findByName("%" + name + "%");
        result.setData(page);
        if (page.size() > 0) {
            result.setSuccess(true);
            result.setCode(page.getPages());
        } else {
            result.setSuccess(false);
            result.setCode(500);
            result.setMessage("没有数据");
        }
        return result;
    }

    @Override
    public ResponseResult<DbModel> update(String id, int code) {
        ResponseResult<DbModel> result = new ResponseResult<>();
        int i = mapper.update(id, code);
        switch (i) {
            case 1:
                result.setSuccess(true);
                break;
            default:
                result.setSuccess(false);
                result.setMessage("设置失败");
        }
        return result;
    }

    @Override
    public ResponseResult<DbModel> updates(Map<String, Integer> map) {
        ResponseResult<DbModel> result = new ResponseResult<>();
        int i = mapper.updates(map);
        switch (i) {
            case 1:
                result.setSuccess(true);
                break;
            default:
                result.setSuccess(false);
                result.setMessage("设置失败");
        }
        return result;
    }
}
