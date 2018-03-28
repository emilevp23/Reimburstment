import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ERS_USER_ROLES_DAO_IMP implements ERS_USER_ROLES_DAO{
    private Logger log = Logger.getRootLogger();

    private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

    public String Find_User_Role(int user_role_id) {
        Connection conn = connUtil.getConnection();
        log.trace("User Role ");
        try  {
            PreparedStatement ps = conn.prepareStatement("select user_role from Ers_User_Roles where Ers_User_Role_Id = ?");//find the statement
            ps.setInt(1,user_role_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("user_role");//find the statement
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


        return null;
    }
}
