
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample {
    public static void main(String[] args) {
        // 创建一个 SpEL 解析器
        ExpressionParser parser = new SpelExpressionParser();

        // 创建一个示例对象
        Person person = new Person("Alice", 30);

        // 解析并计算 SpEL 表达式
        String name = parser.parseExpression("name").getValue(person, String.class);
        System.out.println("Name: " + name);  // 输出: Name: Alice

        Integer age = parser.parseExpression("age").getValue(person, Integer.class);
        System.out.println("Age: " + age);    // 输出: Age: 30
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
