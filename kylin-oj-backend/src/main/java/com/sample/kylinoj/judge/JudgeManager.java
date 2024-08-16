package com.sample.kylinoj.judge;

import com.sample.kylinoj.judge.strategy.DefaultJudgeStrategy;
import com.sample.kylinoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.sample.kylinoj.judge.strategy.JudgeContext;
import com.sample.kylinoj.judge.strategy.JudgeStrategy;
import com.sample.kylinoj.judge.codesandbox.model.JudgeInfo;
import com.sample.kylinoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
