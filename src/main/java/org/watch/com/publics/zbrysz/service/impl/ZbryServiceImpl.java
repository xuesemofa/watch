package org.watch.com.publics.zbrysz.service.impl;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.watch.com.publics.db.mapper.DbMapper;
import org.watch.com.publics.dbzbrssz.mapper.DbzbrsszMapper;
import org.watch.com.publics.dbzbrssz.model.DbzbrsszModel;
import org.watch.com.publics.fzbrq.mapper.FzbrqMapper;
import org.watch.com.publics.fzbrq.model.FzbrqModel;
import org.watch.com.publics.people.model.PeopleModel;
import org.watch.com.publics.sxdzmax.mapper.sxdzmaxMapper;
import org.watch.com.publics.sxdzmax.model.sxdzmax;
import org.watch.com.publics.xszq.mapper.XszqMapper;
import org.watch.com.publics.xszq.model.XszqModel;
import org.watch.com.publics.zb.mapper.ZbMapper;
import org.watch.com.publics.zbrysz.mapper.ZbryMapper;
import org.watch.com.publics.zbrysz.model.ZbryModel;
import org.watch.com.publics.zbrysz.service.ZbryService;
import org.watch.com.util.date.Dates2;
import org.watch.com.util.resultJson.ResponseResult;
import org.watch.com.util.uuidUtil.GetUuid;

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
public class ZbryServiceImpl implements ZbryService {

    @Resource
    private ZbryMapper mapper;
    @Resource
    private DbMapper mapper3;
    @Resource
    private sxdzmaxMapper mapper2;
    @Resource
    private ZbMapper mapper6;
    @Resource
    private XszqMapper mapper8;
    @Resource
    private FzbrqMapper fzbrqMapper;
    @Resource
    private DbzbrsszMapper dbzbrsszMapper;

    @Override
    public ResponseResult<ZbryModel> save(String id) throws Exception {
        ResponseResult<ZbryModel> result = new ResponseResult<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        Map<String, ZbryModel> map = new HashMap<>();

        List<ZbryModel> query = mapper.query(id);
        if (query.size() > 0) {
            result.setSuccess(false);
            result.setMessage("已经设置过值班");
            return result;
        }
        XszqModel model = mapper8.getById(id);
        Page<PeopleModel> modelsM = mapper6.findByName2("Z", "M");
        int ma = 1;
        for (PeopleModel p : modelsM) {
            if (p.getCode() >= ma)
                ma = p.getCode();
        }
        Page<PeopleModel> modelsF = mapper6.findByName2("Z", "F");
        int ma2 = 1;
        for (PeopleModel p : modelsF) {
            if (p.getCode() >= ma2)
                ma2 = p.getCode();
        }
//                值班最大值
        List<sxdzmax> max = mapper2.finds();
        int codeM = 1;
        int codeF = 1;
        for (sxdzmax m : max) {
            if (m.getDorz().equals("21") && m.getSorx().equals("2")) {
                codeM = Integer.parseInt(m.getMax());
            }
            if (m.getDorz().equals("22") && m.getSorx().equals("2")) {
                codeF = Integer.parseInt(m.getMax());
            }
        }
        Date date = sdf.parse(model.getStrDate());
        Date date1 = sdf.parse(model.getEndDate());
        List<Date> dates = Dates2.findDates(date, date1);
        for (Date d : dates) {
//        非值班日期
            List<FzbrqModel> fzbrqModelList = fzbrqMapper.findByDates2(sdf.format(d));
            if (fzbrqModelList.size() > 0) {
                ZbryModel zb = new ZbryModel();
                zb.setAmid("");
                zb.setPmid("");
                zb.setZwid("");
                zb.setZqid(model.getUuid());
                zb.setZbrq(sdf.format(d));
                map.put(GetUuid.getUUID(), zb);
                continue;
            }

//            当日值班人数
            List<DbzbrsszModel> dbzbrsszModelList = dbzbrsszMapper.findByDates2(sdf.format(d));
            int r = 1;
            if (dbzbrsszModelList.size() > 0)
                r = Integer.parseInt(dbzbrsszModelList.get(0).getRs());

            if (Dates2.dateToWeek(sdf.format(d)) == 0 || Dates2.dateToWeek(sdf.format(d)) == 6) {
//                周六日
//                    一天三班
                ZbryModel zb = new ZbryModel();
                for (int i = 0; i < 3; i++) {
//                        一班n个人
                    peo:
                    for (int j = 0; j < r; j++) {

                        for (PeopleModel p : modelsF) {
                            if (p.getCode() == codeF) {
                                if (i == 0) {
                                    String s = zb.getAmid() == null ? "" : ("," + zb.getAmid());
                                    zb.setAmid(p.getName() + s);
                                } else if (i == 1) {
                                    String s = zb.getPmid() == null ? "" : ("," + zb.getPmid());
                                    zb.setPmid(p.getName() + s);
                                } else {
                                    String s = zb.getZwid() == null ? "" : ("," + zb.getZwid());
                                    zb.setZwid(p.getName() + s);
                                }
                                codeF = (p.getCode() + 1) > ma2 ? 1 : (p.getCode() + 1);
                                continue peo;
                            }
                        }
                    }
                }
                zb.setZqid(model.getUuid());
                zb.setZbrq(sdf.format(d));
                map.put(GetUuid.getUUID(), zb);
            } else {
                ZbryModel zb = new ZbryModel();
                peo:
                for (int j = 0; j < r; j++) {

                    for (PeopleModel p : modelsM) {
                        if (p.getCode() == codeM) {
                            String s = zb.getZwid() == null ? "" : ("," + zb.getZwid());
                            zb.setZwid(p.getName() + s);
                            codeM = (p.getCode() + 1) > ma ? 1 : (p.getCode() + 1);
                            continue peo;
                        }
                    }
                }
                zb.setZqid(model.getUuid());
                zb.setZbrq(sdf.format(d));
                map.put(GetUuid.getUUID(), zb);
            }
        }

        mapper.save(map);
        mapper2.update(codeM + "", "2", "21");
        mapper2.update(codeF + "", "2", "22");
        result.setSuccess(true);
        result.setMessage(null);
        return result;
    }

    @Override
    public List<ZbryModel> query(String zqid) {
        return mapper.query(zqid);
    }

}
