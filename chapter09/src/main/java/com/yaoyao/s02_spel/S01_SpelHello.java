package com.yaoyao.s02_spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 使用SpEL提供表达式解析类
 *
 * Created by yaoyao on 2020-02-29.
 */
public class S01_SpelHello {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello' + ' World'");
        String message = (String) exp.getValue();
        System.out.println("输出：" + message);
    }

}
