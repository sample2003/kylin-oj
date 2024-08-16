package com.sample.kylinoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sample.kylinoj.model.dto.question.QuestionQueryRequest;
import com.sample.kylinoj.model.entity.Question;
import com.sample.kylinoj.model.entity.Question;
import com.sample.kylinoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author mianju
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2024-07-14 11:49:25
*/
public interface QuestionService extends IService<Question> {

    /**
     * 校验
     *
     * @param post
     * @param add
     */
    void validQuestion(Question post, boolean add);

    /**
     * 获取查询条件
     *
     * @param postQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest postQueryRequest);

    /**
     * 获取题目封装
     *
     * @param post
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question post, HttpServletRequest request);

    /**
     * 分页获取题目封装
     *
     * @param postPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> postPage, HttpServletRequest request);

}
