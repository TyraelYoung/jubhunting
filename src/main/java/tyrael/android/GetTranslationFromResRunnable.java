package tyrael.android;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.util.*;

public class GetTranslationFromResRunnable {
    private static final List<String> keyOrder = Arrays.asList("default");

    private final List<String> resDirs;
    private final List<String> stringNames;
    private final String outputPath;

    //每个语言的解析器，目前只考虑一个语言一个文件
    private final Map<String, StringXmlParser> stringXmlParserMap = new HashMap<>();

    /**
     * @param resDirs    考虑存在多个文件的情况
     */
    public GetTranslationFromResRunnable(List<String> resDirs, List<String> stringNames, String outputPath) {
        this.resDirs = resDirs;
        this.stringNames = stringNames;
        this.outputPath = outputPath;
    }

    public void run() {
        readClientXml();
        write();
    }

    private void readClientXml() {
        //读取语言文件夹
        for (String dirString : resDirs) {
            File resDirFile = new File(dirString);
            File[] valuesDirs = resDirFile.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.startsWith("values");
                }
            });
            assert valuesDirs != null;
            for (File valuesDir : valuesDirs) {
                File[] stringsXml = valuesDir.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.equals("strings.xml");
                    }
                });
                if (stringsXml == null || stringsXml.length != 1) {
                    continue;
                }
                stringXmlParserMap.put(getLanguage(valuesDir.getName()),
                        new StringXmlParser(stringsXml[0].getAbsolutePath()).parse());
            }
        }
    }

    private String getLanguage(String name) {
        if (name.equals("values")) {
            return "default";
        } else {
            int index = name.indexOf("-");
            return name.substring(index + 1);
        }
    }

    private void write() {
        try {
            PrintStream printStream = new PrintStream(outputPath);
            List<String> orderedLanguageKeys = new ArrayList<>(keyOrder);
            Set<String> languageKeys = new HashSet<>(stringXmlParserMap.keySet());
            orderedLanguageKeys.forEach(languageKeys::remove);
            orderedLanguageKeys.addAll(languageKeys);

            stringNames.forEach(stringName -> {
                orderedLanguageKeys.forEach(key -> {
                    printStream.print(key + ": ");
                    StringXmlParser parser = stringXmlParserMap.get(key);
                    if (parser == null) {
                        printStream.print("[]");
                    } else {
                        printStream.printf("[%s]", parser.get(stringName));
                    }
                    printStream.println();
                });
                printStream.println();
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
