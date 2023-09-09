package com.rsbin.binoj.model.vo;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.google.gson.reflect.TypeToken;
import com.rsbin.binoj.model.dto.question.JudgeConfig;
import com.rsbin.binoj.model.entity.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 题目视图
 * </p>
 *
 * @author rsbin
 * @since 2023-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Question对象", description="题目")
public class QuestionVO implements Serializable {

    private static final long serialVersionUID = -6244068292675521959L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "标签列表(json数组)")
    private List<String> tags;

    @ApiModelProperty(value = "题目提交数")
    private Integer submitNum;

    @ApiModelProperty(value = "题目通过数")
    private Integer acceptedNum;


    @ApiModelProperty(value = "判题配置(json)对象")
    private JudgeConfig judgeConfig;

    @ApiModelProperty(value = "点赞数")
    private Integer thumbNum;

    @ApiModelProperty(value = "收藏数")
    private Integer favourNum;

    @ApiModelProperty(value = "创建用户id")
    private Long userId;

    @ApiModelProperty(value = "创建题目人信息")
    private UserVO userVO;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    /**
     * 包装类转对象
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tagList = questionVO.getTags();
        if (tagList != null) {
            question.setTags(JSONUtil.toJsonStr(tagList));
        }
        JudgeConfig voJudgeConfig = questionVO.getJudgeConfig();
        if (!Objects.isNull(voJudgeConfig)) {
            question.setJudgeConfig(JSONUtil.toJsonStr(voJudgeConfig));
        }
        return question;
    }

    /**
     * 对象转包装类
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        List<String> tagList = JSONUtil.toList(question.getTags(), String.class);
        questionVO.setTags(tagList);
        questionVO.setJudgeConfig(JSONUtil.toBean(question.getJudgeConfig(), JudgeConfig.class));
        return questionVO;
    }
}
