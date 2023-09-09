package com.rsbin.binoj.model.dto.question;

import lombok.Data;

import java.io.Serializable;

/**
 * @author rs_bin
 * @version 1.0
 * @date 2023/9/9 14:56
 * @desc: 判题配置
 */
@Data
public class JudgeConfig implements Serializable {
    private static final long serialVersionUID = -8136883344228079740L;

    /**
     * 时间限制(ms)
     */
    private Long timeLimit;
    /**
     * 内存限制(kb)
     */
    private Long memoryLimit;
    /**
     * 堆栈限制(kb)
     */
    private Long stackLimit;
}
