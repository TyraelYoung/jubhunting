package tyrael.android;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.util.List;

public class StringXmlParser {
    private final String path;

    private List<Element> stringElements;

    public StringXmlParser(String path) {
        System.out.println("path = " + path);
        this.path = path;
    }

    public StringXmlParser parse() {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(path));
            Element resources = document.getRootElement();
            stringElements = resources.elements("string");
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Nullable
    public String get(@Nonnull String key) {
        for (Element stringElement : stringElements) {
            if (key.equals(stringElement.attributeValue("name"))){
                return stringElement.getStringValue();
            }
        }
        return null;
    }
}
