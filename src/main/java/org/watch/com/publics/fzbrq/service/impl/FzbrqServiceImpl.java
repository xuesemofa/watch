package org.watch.com.publics.fzbrq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.watch.com.publics.fzbrq.mapper.FzbrqMapper;
import org.watch.com.publics.fzbrq.model.FzbrqModel;
import org.watch.com.publics.fzbrq.service.FzbrqService;
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
public class FzbrqServiceImpl implements FzbrqService {

    @Resource
    private FzbrqMapper mapper;

    @Override
    public ResponseResult<FzbrqModel> save(FzbrqModel model) {
        ResponseResult<FzbrqModel> result = new ResponseResult<>();
        List<FzbrqModel> list = mapper.findByDates(model.getDates(), model.getDates());
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
    public ResponseResult<FzbrqModel> del(String id) {
        ResponseResult<FzbrqModel> result = new ResponseResult<>();
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
    public ResponseResult<List<FzbrqModel>> findByDates(String strDate, String endDate) {
        ResponseResult<List<FzbrqModel>> result = new ResponseResult<>();
        List<FzbrqModel> list = mapper.findByDates(strDate, endDate);
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

    @Override
    public ResponseResult<Page<FzbrqModel>> find(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        Page<FzbrqModel> page = mapper.find();
        ResponseResult<Page<FzbrqModel>> result = new ResponseResult<>();
        result.setSuccess(true);
        result.setData(page);
        result.setCode(result.getData().getPages());
        return result;
    }
}
