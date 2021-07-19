package tyrael.android;

import com.sun.org.apache.xpath.internal.operations.And;

import java.io.File;
import java.util.Map;

public class MultiStringXmlWriter {
    private final String resDir;
    private final Map<String, Map<String, String>> languageStringMap;

    public MultiStringXmlWriter(String resDir, Map<String, Map<String, String>> languageStringMap) {
        this.resDir = resDir;
        this.languageStringMap = languageStringMap;
    }

    public void run() {
        languageStringMap.forEach((language, stringValueMap) -> {
            File valueDirFile = new File(resDir, AndroidStringFileNameUtil.getValueDirName(language));
            File stringXmlFile = new File(valueDirFile, "strings.xml");
            if (!stringXmlFile.exists()) {
                return;
            }
            new StringXmlWriter(stringXmlFile.getAbsolutePath(), stringValueMap);
        });
    }
}
