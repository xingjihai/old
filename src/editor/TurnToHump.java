package editor;


/**
 * 驼峰命名转换
 * @author wuyijia
 *
 */
public class TurnToHump {
    public static void main(String[] args) {
        String str="DEPT_ID JUDGE";
        String split_str=" ";
        String result_str="";
        String [] column = str.split(split_str);
        for (String columnName : column) {
//            result_str+=toHump(columnName)+split_str;
            result_str+="\""+toHump(columnName)+"\""+split_str+",";
        }
        System.out.println(result_str);
    }
    
    
    /**
     * 将 litigant_name 形式的 列名转换成  litigantName 驼峰形式
     */
    public static String toHump(String columnName){
        String [] names = columnName.split("_");
        StringBuffer sb = new StringBuffer(names[0].toLowerCase());
        for(int i = 1; i < names.length; i++){
            String n = names[i];
            sb.append(n.substring(0,1).toUpperCase());
            sb.append(n.substring(1).toLowerCase());
        }
        return sb.toString();
    }
    
    /**
     * 首字母大写
     */
    public static String firstToHump(String columnName){
        char[] charArray=columnName.toCharArray();
        charArray[0]-=32;
        return columnName.valueOf(charArray);
    }
}
