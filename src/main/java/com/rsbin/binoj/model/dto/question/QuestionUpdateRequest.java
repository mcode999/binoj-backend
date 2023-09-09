package com.rsbin.binoj.model.dto.question;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 更新请求
 */
@Data
public class QuestionUpdateRequest implements Serializable {
    private static final long serialVersionUID = 7725764059972476107L;
    @ApiModelProperty(value = "id")
    private Long id;

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