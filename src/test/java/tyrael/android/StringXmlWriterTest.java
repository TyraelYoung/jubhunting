package tyrael.android;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StringXmlWriterTest {
    @Test
    public void test(){
        Map<String, String> stringNameValueMap = new HashMap<>();
        stringNameValueMap.put("test", "测试");
        new StringXmlWriter("F:\\SourceCode\\LearnAndroid\\app\\src\\main\\res\\values\\strings.xml", stringNameValueMap).run();
    }
}
