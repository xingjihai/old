package editor;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import editor.util.ReadFromFile;


/**
 * dipuse 项目中 根据实体类和模板去生成模型
 */
public class CreatePage2 {
    public static void main(String[] args) {
        // arg1:注释  arg2:表列名  arg3:实体类属性名  arg4:首字母大写
        String str=
//                "query.where(new Column(casesAlias, Case.T_arg2), caze.getarg3(), ExpressionType.CDT_Equal);\r\n";
//                " arg1:<input type=\"text\" name=\"arg3\"> \r\n";
                  " T_arg2,arg1  \r\n";
        
        
//        List<String[]> resultList=getClassPropertity("E:\\stsWorkspace\\wtfr\\weitu-dispuse-common\\src\\main\\java\\com\\weitu\\dispuse\\common\\entity\\Record.java");
//        List<String[]> resultList=getClassPropertity("E:\\stsWorkspace\\wtfr\\weitu-dispuse-common\\src\\main\\java\\com\\weitu\\dispuse\\common\\entity\\Mediate.java");
        List<String[]> resultList=getClassPropertity("C:\\develop\\workspace_idea\\guandu2\\src\\main\\java\\com\\weitu\\zhixing\\common\\entity\\entity\\ExecuteCase.java");
        String columnFilter="";   //数据库字段过滤器
        String commentFilter="";  //备注过滤器
        String commentSplit=" ";  //备注过滤器的分隔符
        String propertyFilter="";  //类属性过滤器
        //备注过滤器
        commentFilter="/案号 立案案由 承办人 案件类别 审判程序 适用程序 案件来源 案件涉及 收案人 诉状日期 立案日期 承办部门 审判长 书记员 诉讼费 诉讼标的金额 结案日期 结案方式" + 
                "";   
//        commentSplit=" ";
        //类属性 过滤器
//        propertyFilter="newcaseSource isLitigationPreservation caseDetail isPublicInterestLitigation caseRefer litigationType litigationAction sueCorpore sueAmount jurisdictionBases caseType litigationFee applicableProcedure isReferArmy isMediation isMajorCase regionRefer registerDept receiveDeptId registrant";
        
        fillHtml( resultList ,str ,columnFilter,commentFilter,commentSplit,propertyFilter);
    }
    
    /**
     * 将属性和注释注入页面模板
     */
    public static void fillHtml(List<String[]> properties,String htmlTemplate,String columnFilter,String commentFilter,String commentSplit,String propertyFilter){
        StringBuffer sb=new StringBuffer();
        for (String[] property : properties) {
            
            {  //表字段过滤
                if(columnFilter!=null&&columnFilter!=""&&!columnFilter.contains(property[1])){   //如果字段不包含列名则跳过
                    continue;
                }
            }
            
            {  //注释过滤
                String[] commentstr=commentFilter.split(commentSplit);
                boolean jump_flag=true;
                for (String str : commentstr) {
                    if(property[0]==null||(  str!=null&&str!=""&&!property[0].contains(str))    ){   //如果注释不包含字段则跳过
                    }else{
                        jump_flag=false;
                    }
                }
                if(jump_flag){
                    continue;
                }
            }
            {
                //类属性 过滤
                if(propertyFilter!=null&&propertyFilter!=""&&!propertyFilter.contains(property[2])){   //如果字段不包含 属性名则跳过
                    continue;
                }
            }
            
            String str=htmlTemplate;
            str=str.replaceAll("arg1", property[0]);  
            str=str.replaceAll("arg2", property[1] );
            str=str.replaceAll("arg3", property[2] );
            str=str.replaceAll("arg4", property[3] );
            sb.append(str);
        }
        System.out.println(sb);
    }
    
    
    /**
     * 获取实体类中的元素和注释
     * @return 
     * List中的item    ===> result[0]:注释  result[1]:表列名  result[2]实体类名
     * 
     * 如 起诉标的金额，SUE_AMOUNT，sueAmount
     */
    public static List<String[]> getClassPropertity(String file_path) {
        List<String[]> resultList=new ArrayList<String[]>();
        
        String file_str = ReadFromFile.readFileByLines(file_path);
//         System.out.println(file_str);
//        Pattern pattern = Pattern.compile("@RdColumn\\(name = (.*)\\)");
        Pattern pattern = Pattern.compile("//(.*)\\((.*)([\\s]*)public static final String (.*) = \"(.*)\";");
        Matcher matcher = pattern.matcher(file_str);
        while (matcher.find()) { 
            String[] result=new String[4];
            String group = matcher.group(0);
//            System.out.println(matcher.group(0));          //匹配到全部
//            System.out.println(matcher.group(1));           //匹配到注释  如：接收人 (NULL)
//            System.out.println(matcher.group(5));           //匹配到    如：  RECIPIENT
            
            result[0]=matcher.group(1);
            result[1]=matcher.group(5);
            result[2]= TurnToHump.toHump(matcher.group(5));
            result[3]=TurnToHump.firstToHump(result[2]);
//            System.out.println(result[2]);
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
