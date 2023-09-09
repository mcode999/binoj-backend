package com.rsbin.binoj.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * @author rs_bin
 * @version 1.0
 * @date 2023/9/9 14:56
 * @desc: 判题信息
 */
@Data
public class JudgeInfo implements Serializable {
    private static final long serialVersionUID = 8738512378675809948L;

    /**
     * 程序执行信息
     */
    private String message;
    /**
     * 消耗内存(kb)
     */
    private Long memory;
    /**
     * 消耗时间(ms)
     */
    private Long time;
}
