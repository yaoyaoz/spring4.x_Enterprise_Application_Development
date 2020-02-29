package com.yaoyao.s02_spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 文本字符解析
 *
 * Created by yaoyao on 2020-02-29.
 */
public class S03_LiteralExprSample {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //解析字符串
        String helloWorld = (String) parser.parseExpression("\"Hello World\"").getValue();
        //解析双精度浮点型
        double doubleNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
        //解析整型
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        //解析布尔型
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        //解析空值
        Object nullValue = parser.parseExpression("null").getValue();

        StringBuffer sb = new StringBuffer();
        sb.append("\n字符串:" + helloWorld);
        sb.append("\n双精度浮点型:" + doubleNumber);
        sb.append("\n整型:" + maxValue);
        sb.append("\n布尔型:" + trueValue);
        sb.append("\n空值:" + nullValue);
        System.out.println("输出：" + sb.toString());
    }

}
