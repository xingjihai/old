package editor;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用场景： 将java大纲中的属性复制到excel中
 * @author wu.y.j
 */
public class JavaToExcel {
    public static void main(String[] args) {
        String javaProperties=
                "accept_body_name : String\r\n" + 
                "accept_body_no : String\r\n" + 
                "address : String\r\n" + 
                "address_id : Integer\r\n" + 
                "calltimes : Integer\r\n" + 
                "career : String\r\n" + 
                "case_content : String\r\n" + 
                "case_id : Integer\r\n" + 
                "cat_id : Integer\r\n" + 
                "cat_name : String\r\n" + 
                "check_body_name : String\r\n" + 
                "check_body_no : String\r\n" + 
                "check_time : Long\r\n" + 
                "city : String\r\n" + 
                "city_id : Integer\r\n" + 
                "consultTime : Long\r\n" + 
                "crttime : Long\r\n" + 
                "evalContent : String\r\n" + 
                "evalLevel : Integer\r\n" + 
                "firm : String\r\n" + 
                "id : Integer\r\n" + 
                "idnumber : String\r\n" + 
                "is_edit : Integer\r\n" + 
                "is_typical_case : Integer\r\n" + 
                "isopen : Integer\r\n" + 
                "lit_address : String\r\n" + 
                "messageList : List<MessageView>\r\n" + 
                "mobile : String\r\n" + 
                "name : String\r\n" + 
                "open_id : String\r\n" + 
                "province : String\r\n" + 
                "province_id : Integer\r\n" + 
                "quality_review : String\r\n" + 
                "recordfilename : String\r\n" + 
                "region : String\r\n" + 
                "region_id : Integer\r\n" + 
                "score : Integer\r\n" + 
                "sex : Integer\r\n" + 
                "source : Integer\r\n" + 
                "status : Integer\r\n" + 
                "tel : String\r\n" + 
                "title : String\r\n" + 
                "usid : String\r\n" + 
                "wx_address : String\r\n" + 
                "wx_nickname : String\r\n" + 
                "wx_no : String\r\n" + 
                "wx_sex : Integer" ;
        
        String element[]=javaProperties.split("\\r\\n");
        List<String> typeList=new ArrayList<String>();
        List<String> nameList=new ArrayList<String>();
        for (String string : element) {
            String[] el=string.split(":");
            typeList.add(el[1].trim());
            nameList.add(el[0].trim());
        }
        for (String string : typeList) {
            System.out.println(string);
        }
        System.out.println("====================");
        for (String string : nameList) {
//            System.out.println(string);
            System.out.print(string+",");
        }
    }
}
