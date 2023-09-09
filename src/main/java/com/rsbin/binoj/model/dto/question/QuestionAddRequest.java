package com.rsbin.binoj.model.dto.question;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建请求
 */
@ApiModel("添加题目请求体")
@Data
public class QuestionAddRequest implements Serializable {
    private static final long serialVersionUID = -1044275317909722640L;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "标签列表(json数组)")
    private List<String> tags;

    @ApiModelProperty(value = "题目答案")
    private String answer;

    @ApiModelProperty(value = "判题用例(json)数组")
    private List<JudgeCase> judgeCase;

    @ApiModelProperty(value = "判题配置(json)对象")
    private JudgeConfig judgeConfig;
}