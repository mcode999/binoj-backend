package com.rsbin.binoj.model.dto.questionsubmit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {
    private static final long serialVersionUID = 3365618923840453395L;
    @ApiModelProperty(value = "编程语言")
    private String language;

    @ApiModelProperty(value = "用户代码")
    private String code;

    @ApiModelProperty(value = "题目id")
    private Long questionId;
}