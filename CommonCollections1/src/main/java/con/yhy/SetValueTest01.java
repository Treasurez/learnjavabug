package con.yhy;

import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.util.HashMap;
import java.util.Map;

public class SetValueTest01 {
    public static void main(String[] args) {
        String calc = "/System/Applications/Calculator.app/Contents/MacOS/Calculator";

        Runtime runtime = Runtime.getRuntime();
        InvokerTransformer invokerTransformer = new InvokerTransformer("exec"
                , new Class[]{String.class}, new Object[]{calc});
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("key", "value");
        Map<Object, Object> decorateMap = TransformedMap.decorate(hashMap, null, invokerTransformer);
        for (Map.Entry entry:decorateMap.entrySet()){
            entry.setValue(runtime);
        }
    }
}

