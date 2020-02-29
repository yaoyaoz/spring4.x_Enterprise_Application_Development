package com.yaoyao.s02_spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * SpelCompiler适用于表达式不经常发生变动且重复调用频率较高的场景
 * <p>
 * Created by yaoyao on 2020-02-29.
 */
public class S02_CompilerSample {

    public static void main(String[] args) {
        User user = new User();
        //创建解析配置
        SpelParserConfiguration configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
                S02_CompilerSample.class.getClassLoader());
        //创建解析器
        SpelExpressionParser parser = new SpelExpressionParser(configuration);
        //创建取值上下文
        EvaluationContext context = new StandardEvaluationContext(user);
        //表达式
        String expression = "isVipMember('tom') && isVipMember('jony')";
        //解析表达式
        SpelExpression spelExpression = parser.parseRaw(expression);
        //通过表达式求和
        System.out.println(spelExpression.getValue(context)); //第一次调用
        System.out.println(spelExpression.getValue(context)); //第二次调用
    }

}

class User {
    private String userName;
    private int credits;

    public boolean isVipMember(String userName){
        return "tom".equals(userName) || "jony".equals(userName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
