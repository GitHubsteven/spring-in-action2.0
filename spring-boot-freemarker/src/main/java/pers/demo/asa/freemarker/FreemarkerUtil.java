package pers.demo.asa.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FreemarkerUtil {
    public Template getTemplate(String name) {
        Template temp = null;
        try {
            // 通过Freemarker的Configuration读取相应的Ftl
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
            // 设定去哪里读取相应的ftl模板
            cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/");
            // 在模板文件目录中寻找名称为name的模板文件
            temp = cfg.getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * 控制台输出文件内容
     *
     * @param name    名字
     * @param rootMap 信息map
     */
    public void print(String name, Map<String, Object> rootMap) {
        try {
            // 通过Template类可以将模板文件输出到相应的文件
            Template temp = this.getTemplate(name);
            temp.process(rootMap, new PrintWriter(System.out));
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将替换后的模板内容输出到文件
     *
     * @param name    名字
     * @param rootMap 信息map
     * @param outFile 输出文件夹
     */
    public void fprint(String name, Map<String, Object> rootMap, String outFile) {
        try (FileWriter out = new FileWriter(new File("D:\\freemarker\\ftl\\html\\"
                + outFile))) {
            Template template = this.getTemplate(name);
            template.process(rootMap, out);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}