package org.watch.com.publics.dbzbrssz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.watch.com.publics.dbzbrssz.mapper.DbzbrsszMapper;
import org.watch.com.publics.dbzbrssz.model.DbzbrsszModel;
import org.watch.com.publics.dbzbrssz.service.DbzbrsszService;
import org.watch.com.util.resultJson.ResponseResult;
import org.watch.com.util.uuidUtil.GetUuid;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
@Service
@Transactional
public class DbzbrsszServiceImpl implements DbzbrsszService {
	@Autowired
	private DbzbrsszMapper mapper;
	@Override
    public ResponseResult<DbzbrsszModel> save(DbzbrsszModel model) {
        ResponseResult<DbzbrsszModel> result = new ResponseResult<>();
        List<DbzbrsszModel> list = mapper.findByDates(model.getDates(), model.getDates());
        if (list.size() > 0) {
            result.setSuccess(false);
            result.setMessage("时间重复");
            return result;
        }
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
    public ResponseResult<DbzbrsszModel> del(String id) {
        ResponseResult<DbzbrsszModel> result = new ResponseResult<>();
        int i = mapper.del(id);
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
    public ResponseResult<List<DbzbrsszModel>> findByDates(String strDate, String endDate) {
        ResponseResult<List<DbzbrsszModel>> result = new ResponseResult<>();
        List<DbzbrsszModel> list = mapper.findByDates(strDate, endDate);
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

    @Override
    public ResponseResult<Page<DbzbrsszModel>> find(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        Page<DbzbrsszModel> page = mapper.find();
        ResponseResult<Page<DbzbrsszModel>> result = new ResponseResult<>();
        result.setSuccess(true);
        result.setData(page);
        result.setCode(result.getData().getPages());
        return result;
    }
}
