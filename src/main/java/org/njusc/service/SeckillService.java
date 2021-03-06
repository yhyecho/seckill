package org.njusc.service;

import org.njusc.dto.Exposer;
import org.njusc.dto.SeckillExecution;
import org.njusc.entity.Seckill;
import org.njusc.exception.RepeatKillException;
import org.njusc.exception.SeckillCloseException;
import org.njusc.exception.SeckillException;

import java.util.List;

/**
 * Created by Echo on 17/8/15.
 * 业务接口: 站在"使用者"角度设计接口
 * 三个方面: 方法定义粒度,参数,返回类型(return 类型/异常)
 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启: 输出秒杀接口地址,
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, RepeatKillException;

    /**
     * 执行秒杀操作by 存储过程
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
