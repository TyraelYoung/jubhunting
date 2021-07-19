package tyrael.xml;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Dom4jUtil {
    //保存XML文件
    private static void write(Document doc, String path) {
        //格式化为缩进格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置编码格式
        format.setEncoding("UTF-8");
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileWriter(path),format);
            //写入数据
            writer.write(doc);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
