package org.watch.com.online.xsdbry.service.impl;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.watch.com.online.xsdbry.mapper.XsdbryMapper;
import org.watch.com.online.xsdbry.model.XsdbryModel;
import org.watch.com.online.xsdbry.service.XsdbryService;
import org.watch.com.publics.db.mapper.DbMapper;
import org.watch.com.publics.dbzbrssz.mapper.DbzbrsszMapper;
import org.watch.com.publics.fzbrq.mapper.FzbrqMapper;
import org.watch.com.publics.fzbrq.model.FzbrqModel;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.sxdzmax.mapper.sxdzmaxMapper;
import org.watch.com.publics.sxdzmax.model.sxdzmax;
import org.watch.com.publics.xszq.mapper.XszqMapper;
import org.watch.com.publics.xszq.model.XszqModel;
import org.watch.com.util.date.Dates2;
import org.watch.com.util.resultJson.ResponseResult;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Service
@Transactional
public class XsdbryServiceImpl implements XsdbryService {

    @Resource
    private XsdbryMapper mapper;
    @Resource
    private sxdzmaxMapper mapper2;
    @Resource
    private DbMapper mapper3;
    @Resource
    private XsdbryMapper mapper4;
    @Resource
    private XszqMapper mapper8;
    @Resource
    private FzbrqMapper mapper9;
    @Resource
    private DbzbrsszMapper dbzbrsszMapper;

    @Override
    public ResponseResult<XsdbryModel> save(String id) throws Exception {
        ResponseResult<XsdbryModel> result = new ResponseResult<>();
        List<PeopleModel> query = mapper4.query(id);
        if (query.size() > 0) {
            result.setSuccess(false);
            result.setMessage("已经设置过带班");
            return result;
        }
        XszqModel model = mapper8.getById(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        Map<String, String> map = new HashMap<>();
        Page<PeopleModel> modelsM = mapper3.findByName2("M", "D");
        int ma = 1;
        for (PeopleModel p : modelsM) {
            if (p.getCode() >= ma)
                ma = p.getCode();
        }
        Page<PeopleModel> modelsF = mapper3.findByName2("F", "D");
        int ma2 = 1;
        for (PeopleModel p : modelsF) {
            if (p.getCode() >= ma2)
                ma2 = p.getCode();
        }
//                带班值班最大值
        List<sxdzmax> max = mapper2.finds();
        int codeM = 1;
        int codeF = 1;
        for (sxdzmax m : max) {
            if (m.getDorz().equals("11") && m.getSorx().equals("1")) {
                codeM = Integer.parseInt(m.getMax());
            }
            if (m.getDorz().equals("12") && m.getSorx().equals("1")) {
                codeF = Integer.parseInt(m.getMax());
            }
        }
        Date date = sdf.parse(model.getStrDate());
        Date date1 = sdf.parse(model.getEndDate());
        List<Date> dates = Dates2.findDates(date, date1);
//        有无
        for (Date d : dates
                ) {
//            跳过非值班日期
            List<FzbrqModel> fzbrqModelList = mapper9.findByDates2(sdf.format(d));
            if (fzbrqModelList.size() <= 0) {
//                值班人数
//                List<DbzbrsszModel> dbzbrsszModelList = dbzbrsszMapper.findByDates2(sdf.format(d));
                int r = 1;
//                if (dbzbrsszModelList.size() > 0)
//                    r = Integer.parseInt(dbzbrsszModelList.get(0).getRs());

                if (Dates2.dateToWeek(sdf.format(d)) == 0 || Dates2.dateToWeek(sdf.format(d)) == 6) {
//                        六日
                    for (int i = 0; i < r; i++) {
                        for (PeopleModel p : modelsF) {
                            if (p.getCode() == codeF) {
                                map.put(sdf.format(d), p.getUuid());
                                codeF = (p.getCode() + 1) > ma2 ? 1 : (p.getCode() + 1);
                                break;
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < r; i++) {
                        for (PeopleModel p : modelsM) {
                            if (p.getCode() == codeM) {
                                map.put(sdf.format(d), p.getUuid());
                                codeM = (p.getCode() + 1) > ma ? 1 : (p.getCode() + 1);
                                break;
                            }
                        }
                    }
                }
            } else {
                map.put(sdf.format(d), "");
            }
        }
        map.put("0", model.getUuid());
        mapper4.save(map);
        mapper2.update(codeM + "", "1", "11");
        mapper2.update(codeF + "", "1", "12");
        result.setSuccess(true);
        return result;
    }

}
