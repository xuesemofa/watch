package org.watch.com.publics.fzbrq.service;

import com.github.pagehelper.Page;
import org.watch.com.publics.fzbrq.model.FzbrqModel;
import org.watch.com.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface FzbrqService {

    ResponseResult<FzbrqModel> save(FzbrqModel model);

    ResponseResult<FzbrqModel> del(String id);

    ResponseResult<List<FzbrqModel>> findByDates(String strDate, String endDate);

    ResponseResult<Page<FzbrqModel>> find(int pageNow,int pageSize);
}
