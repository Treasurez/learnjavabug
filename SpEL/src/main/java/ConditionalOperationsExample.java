//import com.sun.tools.example.debug.expr.ExpressionParser;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//
//public class ConditionalOperationsExample {
//    public static void main(String[] args) {
//        ExpressionParser parser = new SpelExpressionParser();
//
//        // 使用条件运算符
//        boolean condition = true;
//        String result = parser.parseExpression("'Yes' ?: 'No'").getValue(condition, String.class);
//        System.out.println("Result: " + result);  // 输出: Result: Yes
//
//        // 使用 if-then-else 语句
//        result = parser.parseExpression("if (#condition) { 'Yes' } else { 'No' }").getValue(condition, String.class);
//        System.out.println("Result: " + result);  // 输出: Result: Yes
//    }
//}
