package tyrael.android;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class StringXmlWriter {
    private final String path;
    private final Map<String, String> stringNameValueMap;

    public StringXmlWriter(String path, Map<String, String> stringNameValueMap) {
        this.path = path;
        this.stringNameValueMap = stringNameValueMap;
    }

    public void run(){
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(path));
            Element resources = document.getRootElement();
            stringNameValueMap.forEach((key, value) -> {
                append(resources, key, value);
            });
            write(document, path);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

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

    private static void append(Element resources, String key, String value) {
        Element newStringElement = resources.addElement("string");
        newStringElement.addAttribute("name", key);
        newStringElement.addText(value);
    }
}
