package editor;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import editor.util.ReadFromFile;


/**
 * dipuse 项目中 根据实体类和模板去生成模型
 */
public class CreatePage {
    public static void main(String[] args) {
        String str=
                "                <div>\r\n" + 
                "                    <label class='apply-label'>arg1：<font color='red'>*</font></label>\r\n" + 
                "                    <input type=\"text\" class='apply-input' name='arg2'>\r\n" + 
                "                </div>\r\n";
        fillHtml( getClassPropertity("E:\\stsWorkspace\\dipuse\\src\\main\\java\\com\\wt\\dipuse\\entity\\PartiesInfo.java") ,str );
    }
    
    /**
     * 将属性和注释注入页面模板
     */
    public static void fillHtml(List<String[]> properties,String htmlTemplate){
        StringBuffer sb=new StringBuffer();
        for (String[] property : properties) {
            String str=htmlTemplate;
            str=str.replaceAll("arg1", property[0]);
            str=str.replaceAll("arg2", property[1] );
            sb.append(str);
        }
        System.out.println(sb);
    }
    
    
    /**
     * 获取实体类中的元素和注释
     * @return 
     * List中的item    ===> result[0]:注释  result[1]:属性名
     */
    public static List<String[]> getClassPropertity(String file_path) {
        List<String[]> resultList=new ArrayList<String[]>();
        
        String file_str = ReadFromFile.readFileByLines(file_path);
        // System.out.println(file_str);
        Pattern pattern = Pattern.compile("/\\*\\*(.*)\\*/([\\s\\S]*?)public(.*);");
        Matcher matcher = pattern.matcher(file_str);
        while (matcher.find()) { // 第一次匹配获取 /** 调解纠纷id */  public Integer parties_id;
            String[] result=new String[2];
            
            String group = matcher.group(0);
             System.out.println("第一次匹配："+group);
            Pattern pattern2 = Pattern.compile("/\\*\\*(.*)\\*/");
            Matcher matcher2 = pattern2.matcher(group);
            while (matcher2.find()) { // 第二次匹配获取 /** 调解纠纷id */ 中的 “调解纠纷id”
//                System.out.println(matcher2.group(1).trim());
                result[0]=matcher2.group(1).trim();
            }
            Pattern pattern3 = Pattern.compile("public([\\s]*)([\\S]*)([\\s]*)([\\S]*);");
            Matcher matcher3 = pattern3.matcher(group);
            while (matcher3.find()) { // 第二次匹配获取 public Integer mediate_id; 中的 “mediate_id”
//                System.out.println(matcher3.group(4));
                result[1]=matcher3.group(4).trim();
            }
//            System.out.println("==========");
            resultList.add(result);
        }
        return resultList;
    }
    
    
    /**
     * 测试 匹配  
     */
    public static void test(){
        String file_str=ReadFromFile.readFileByLines("E:\\stsWorkspace\\dipuse\\src\\main\\java\\com\\wt\\dipuse\\entity\\Mediate.java");
        System.out.println(file_str);
        Pattern pattern = Pattern.compile("/\\*\\*(.*)\\*/");
        Matcher matcher = pattern.matcher(file_str);
        StringBuffer txt = new StringBuffer();
        while (matcher.find()) {            //第一次匹配获取 /** 调解纠纷id */
            String group = matcher.group(0);
            System.out.println(group);
            Pattern pattern2=Pattern.compile("/\\*\\*(.*)\\*/");
            Matcher matcher2=pattern2.matcher(group);
            while (matcher2.find()) {           //第二次匹配获取 /** 调解纠纷id */  中的 “调解纠纷id”
                System.out.println(matcher2.group(1).trim());
            }
        }
    }
}
