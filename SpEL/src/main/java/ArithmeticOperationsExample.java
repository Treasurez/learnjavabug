import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ArithmeticOperationsExample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        // 简单的加法运算
        int sum = parser.parseExpression("10 + 5").getValue(Integer.class);
        System.out.println("Sum: " + sum);  // 输出: Sum: 15

        // 访问对象属性并进行加法运算
        Person person = new Person("Bob", 25);
        int newAge = parser.parseExpression("age + 1").getValue(person, Integer.class);
        System.out.println("New Age: " + newAge);  // 输出: New Age: 26
    }
}
