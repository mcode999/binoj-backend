package com.rsbin.binoj.controller;


import com.rsbin.binoj.common.BaseResponse;
import com.rsbin.binoj.common.ErrorCode;
import com.rsbin.binoj.common.ResultUtils;
import com.rsbin.binoj.exception.BusinessException;
import com.rsbin.binoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.rsbin.binoj.model.entity.User;
import com.rsbin.binoj.service.QuestionSubmitService;
import com.rsbin.binoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 题目提交 前端控制器
 * </p>
 *
 * @author rsbin
 * @since 2023-09-09
 */
@Slf4j
@RestController
@RequestMapping("/questionSubmit")
public class QuestionSubmitController {
    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                         HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        Long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }
}
