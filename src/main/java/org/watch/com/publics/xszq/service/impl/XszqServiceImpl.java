package org.watch.com.publics.xszq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.watch.com.online.xsdbry.mapper.XsdbryMapper;
import org.watch.com.publics.db.mapper.DbMapper;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.sxdzmax.mapper.sxdzmaxMapper;
import org.watch.com.publics.xszq.mapper.XszqMapper;
import org.watch.com.publics.xszq.model.XszqModel;
import org.watch.com.publics.xszq.service.XszqService;
import org.watch.com.publics.zb.mapper.ZbMapper;
import org.watch.com.publics.zbrysz.mapper.ZbryMapper;
import org.watch.com.util.resultJson.ResponseResult;
import org.watch.com.util.uuidUtil.GetUuid;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Service
@Transactional
public class XszqServiceImpl implements XszqService {

    @Resource
    private XszqMapper mapper;
    @Resource
    private DbMapper mapper3;
    @Resource
    private XsdbryMapper mapper4;
    @Resource
    private sxdzmaxMapper mapper5;
    @Resource
    private ZbMapper mapper6;
    @Resource
    private ZbryMapper mapper7;

    @Override
    public ResponseResult<XszqModel> save(XszqModel model) throws Exception {
        ResponseResult<XszqModel> result = new ResponseResult<>();
        model.setUuid(GetUuid.getUUID());
        int i = mapper.save(model);
        switch (i) {
            case 1:
                result.setSuccess(true);
                break;
            default:
                result.setSuccess(false);
                result.setMessage("失败");
        }
        return result;
    }

    @Override
    public ResponseResult<XszqModel> del(String id) {
        ResponseResult<XszqModel> result = new ResponseResult<>();
        int i = mapper.del(id);
        switch (i) {
            case 1:
                mapper4.del(id);
                mapper7.del(id);
                result.setSuccess(true);
                break;
            default:
                result.setSuccess(false);
                result.setMessage("失败");
        }
        return result;
    }

    @Override
    public ResponseResult<XszqModel> getById(String id) {
        ResponseResult<XszqModel> result = new ResponseResult<>();
        XszqModel model = mapper.getById(id);
        result.setSuccess(true);
        result.setData(model);
        return result;
    }

    @Override
    public ResponseResult<Page<XszqModel>> find(int pageNow, int pageSize) {
        ResponseResult<Page<XszqModel>> result = new ResponseResult<>();
        PageHelper.startPage(pageNow, pageSize);
        Page<XszqModel> page = mapper.find();
        result.setSuccess(true);
        result.setData(page);
        result.setCode(page.getPages());
        return result;
    }

    @Override
    public ResponseResult<Page<XszqModel>> find2(int pageNow, int pageSize) {
        ResponseResult<Page<XszqModel>> result = new ResponseResult<>();
        PageHelper.startPage(pageNow, pageSize);
        Page<XszqModel> page = mapper.find2();
        result.setSuccess(true);
        result.setData(page);
        result.setCode(page.getPages());
        return result;
    }

    @Override
    public ResponseResult<Page<XszqModel>> find3(int pageNow, int pageSize) {
        ResponseResult<Page<XszqModel>> result = new ResponseResult<>();
        PageHelper.startPage(pageNow, pageSize);
        Page<XszqModel> page = mapper.find3();
        result.setSuccess(true);
        result.setData(page);
        result.setCode(page.getPages());
        return result;
    }

    @Override
    public ResponseResult<List<PeopleModel>> query(String zqid) {
        List<PeopleModel> list = mapper4.query(zqid);
        ResponseResult<List<PeopleModel>> result = new ResponseResult<>();
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

}
