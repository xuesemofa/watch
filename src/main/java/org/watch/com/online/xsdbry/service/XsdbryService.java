package org.watch.com.online.xsdbry.service;

import org.watch.com.online.xsdbry.model.XsdbryModel;
import org.watch.com.util.resultJson.ResponseResult;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface XsdbryService {

    ResponseResult<XsdbryModel> save(String id) throws Exception;
}
