package org.watch.com.publics.dbzbrssz.service;

import java.util.List;

import org.watch.com.publics.dbzbrssz.model.DbzbrsszModel;
import org.watch.com.util.resultJson.ResponseResult;

import com.github.pagehelper.Page;

public interface DbzbrsszService {
	
	ResponseResult<DbzbrsszModel> save(DbzbrsszModel model);

    ResponseResult<DbzbrsszModel> del(String id);

    ResponseResult<List<DbzbrsszModel>> findByDates(String strDate, String endDate);

    ResponseResult<Page<DbzbrsszModel>> find(int pageNow,int pageSize);
}
