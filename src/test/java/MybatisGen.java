package test.java;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MybatisGen {
    //xmlConfigure.xml
    public static void generator() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //项目根路径不要有中文,我的有中文,所以使用绝对路径
        //String classpath =
        File configFile = new File("D:\\Users\\Administrator\\minnkill\\src\\main\\resources\\xmlConfigure.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
    /*public String getRootPath() {

        String classPath = CustomerTemplateLoginServiceImpl.class.getClassLoader().getResource("/").getPath();
        System.out.println("classPath-----"+classPath);
        String rootPath = "";
        //windows下
        if("\\".equals(File.separator)){
//			System.out.println("windows");
            rootPath = classPath.substring(1,classPath.indexOf("/WEB-INF/classes"));
            rootPath = rootPath.replace("/", "\\");
        }
        //linux下
        if("/".equals(File.separator)){
//			System.out.println("linux");
            rootPath = classPath.substring(0,classPath.indexOf("/WEB-INF/classes"));
            rootPath = rootPath.replace("\\", "/");
        }
        return rootPath;
    }*/
    public static void main(String[] args) {

        try {
            generator();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}