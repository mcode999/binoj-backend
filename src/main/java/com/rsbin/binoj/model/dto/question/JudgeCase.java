package com.rsbin.binoj.model.dto.question;

import lombok.Data;

import java.io.Serializable;

/**
 * @author rs_bin
 * @version 1.0
 * @date 2023/9/9 14:54
 * @desc: 判题用例对象
 */
@Data
public class JudgeCase implements Serializable {
    private static final long serialVersionUID = 6734248474280759348L;

    private String input;
    private String output;
}
