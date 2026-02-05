package com.cyan.arch.common.util;

/**
 * 雪花算法
 *
 * @author cy.Y
 * @since 1.0.0
 */
public class Snowflake {
    private static final long epoch = 1609430400000L; // 2020-01-01
    private static final long workerIdBits = 10L;
    private static final long seqBits = 12L;
    private static final long maxWorkerId = ~(-1L << workerIdBits); // 1023
    private static final long workerIdShift = seqBits;
    private static final long tsShift = seqBits + workerIdBits;

    private static final long workerId = 1;
    private static long sequence = 0L;
    private static long lastTs = -1L;

//    public static Snowflake(long workerId) {
//        if (workerId > maxWorkerId || workerId < 0)
//            throw new IllegalArgumentException("workerId");
//        this.workerId = workerId;
//    }

    public static synchronized long nextId() {
        long ts = System.currentTimeMillis();
        if (ts < lastTs) {          // 时钟回拨
            throw new RuntimeException("Clock moved backwards");
        }
        if (ts == lastTs) {
            sequence = (sequence + 1) & 4095;
            if (sequence == 0) {    // 本毫秒序号用完，自旋等下一毫秒
                while (ts <= lastTs) ts = System.currentTimeMillis();
            }
        } else {
            sequence = 0;
        }
        lastTs = ts;
        return ((ts - epoch) << tsShift)
             | (workerId << workerIdShift)
             | sequence;
    }

}