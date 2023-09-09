package com.rsbin.binoj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rsbin.binoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.rsbin.binoj.model.entity.QuestionSubmit;
import com.rsbin.binoj.model.entity.User;

/**
 * <p>
 * 题目提交 服务类
 * </p>
 *
 * @author rsbin
 * @since 2023-09-09
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

}
