package tyrael.android;

import org.junit.Test;

public class AndroidXmlParseTest {
    @Test
    public void test(){
        StringXmlParser parser = new StringXmlParser("F:\\SourceCode\\LearnAndroid\\app\\src\\main\\res\\values\\strings.xml");
        parser.parse();
        System.out.println(parser.get("hello_blank_fragment"));
    }
}
