package org.watch.com.publics.zbrysz.service;

import org.watch.com.publics.zbrysz.model.ZbryModel;
import org.watch.com.util.resultJson.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface ZbryService {
    ResponseResult<ZbryModel> save(String id) throws Exception;

    List<ZbryModel> query(String zqid);
}
