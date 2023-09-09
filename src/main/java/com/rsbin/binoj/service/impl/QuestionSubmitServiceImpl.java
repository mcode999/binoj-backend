package com.rsbin.binoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rsbin.binoj.common.ErrorCode;
import com.rsbin.binoj.exception.BusinessException;
import com.rsbin.binoj.mapper.QuestionSubmitMapper;
import com.rsbin.binoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.rsbin.binoj.model.entity.Question;
import com.rsbin.binoj.model.entity.QuestionSubmit;
import com.rsbin.binoj.model.entity.User;
import com.rsbin.binoj.model.enums.QuestionSubmitLanguageEnum;
import com.rsbin.binoj.model.enums.QuestionSubmitStatusEnum;
import com.rsbin.binoj.service.QuestionService;
import com.rsbin.binoj.service.QuestionSubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 题目提交 服务实现类
 * </p>
 *
 * @author rsbin
 * @since 2023-09-09
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit> implements QuestionSubmitService {
    @Resource
    private QuestionService questionService;

    /**
     * 提交题目
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        // 校验编程语言是否支持
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (Objects.isNull(languageEnum)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言不支持");
        }
        // 判断实体是否存在，根据类别获取实体
        Long questionId = questionSubmitAddRequest.getQuestionId();
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已提交题目
        Long userId = loginUser.getId();
        // 是否已提交题目
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(questionSubmit.getLanguage());
        // 设置初始状态
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目插入失败");
        }
        return questionSubmit.getId();
    }

}
