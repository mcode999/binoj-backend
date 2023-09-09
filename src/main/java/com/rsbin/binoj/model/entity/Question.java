package com.rsbin.binoj.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 题目
 * </p>
 *
 * @author rsbin
 * @since 2023-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("question")
@ApiModel(value="Question对象", description="题目")
public class Question implements Serializable {

    private static final long serialVersionUID = 7920965323344696984L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "标签列表(json数组)")
    @TableField("tags")
    private String tags;

    @ApiModelProperty(value = "题目答案")
    @TableField("answer")
    private String answer;

    @ApiModelProperty(value = "题目提交数")
    @TableField("submitNum")
    private Integer submitNum;

    @ApiModelProperty(value = "题目通过数")
    @TableField("acceptedNum")
    private Integer acceptedNum;

    @ApiModelProperty(value = "判题用例(json)数组")
    @TableField("judgeCase")
    private String judgeCase;

    @ApiModelProperty(value = "判题配置(json)对象")
    @TableField("judgeConfig")
    private String judgeConfig;

    @ApiModelProperty(value = "点赞数")
    @TableField("thumbNum")
    private Integer thumbNum;

    @ApiModelProperty(value = "收藏数")
    @TableField("favourNum")
    private Integer favourNum;

    @ApiModelProperty(value = "创建用户id")
    @TableField("userId")
    private Long userId;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;


}
