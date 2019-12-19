package editor;

/**
 *   去除java中的转义符,获取sql (其实就是直接输出到控制台)
 */
public class SeeSql {
    public static void main(String[] args) {
        String sql="select \r\n" + 
                "     pmr.id as pmr_id,m.*,pi.name as parties_name, pi.tel as parties_tel, u.name as user_name\r\n" + 
                " from\r\n" + 
                "    wt_mediate m\r\n" + 
                "        left join\r\n" + 
                "    wt_user u on  m.mediate_user_id=u.id\r\n" + 
                "        left join\r\n" + 
                "    wt_parties_mediate_rel pmr ON m.mediate_id = pmr.mediate_id\r\n" + 
                "        left join\r\n" + 
                "    wt_parties_info pi ON pi.parties_id = pmr.parties_id \r\n" + 
                " where 1=1  and litigation_status=? and is_agent=? group by m.mediate_id";
        System.out.println(sql);
        
        Integer type=null;
        if(3==type){
            System.out.println("success");
        }
    }
}
