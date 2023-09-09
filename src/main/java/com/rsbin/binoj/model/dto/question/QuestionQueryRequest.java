package com.rsbin.binoj.model.dto.question;

import com.rsbin.binoj.common.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 查询请求
 */
@ApiModel("查询题目请求")
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {
    private static final long serialVersionUID = 1465446911859877148L;

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

    @ApiModelProperty(value = "创建用户id")
    private Long userId;
}