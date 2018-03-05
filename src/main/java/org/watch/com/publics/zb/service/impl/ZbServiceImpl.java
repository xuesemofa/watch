package org.watch.com.publics.zb.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.zb.mapper.ZbMapper;
import org.watch.com.publics.zb.model.ZbModel;
import org.watch.com.publics.zb.service.ZbService;
import org.watch.com.util.resultJson.ResponseResult;
import org.watch.com.util.uuidUtil.GetUuid;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class ZbServiceImpl implements ZbService{
	@Resource
    private ZbMapper mapper;

    @Override
    public ResponseResult<ZbModel> add(ZbModel model) {
        ResponseResult<ZbModel> result = new ResponseResult<>();
        ZbModel model1 = mapper.getByPId(model.getPeople_id());
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
    public ResponseResult<ZbModel> del(String id) {
        ResponseResult<ZbModel> result = new ResponseResult<>();
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
    public ResponseResult<ZbModel> update(String id, int code) {
        ResponseResult<ZbModel> result = new ResponseResult<>();
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
    public ResponseResult<ZbModel> updates(Map<String, Integer> map) {
        ResponseResult<ZbModel> result = new ResponseResult<>();
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
