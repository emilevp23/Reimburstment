import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ERS_USERS_DAO_IMP implements ERS_USERS_DAO {

    private Logger log = Logger.getRootLogger();

    private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();


    @Override
    public boolean Find_User(String username, String password) {
        Connection conn = connUtil.getConnection();
        log.trace("Check if user name ");
        try  {
            PreparedStatement ps = conn.prepareStatement("select * from ERS_USERS where ERS_Username = ? and ERS_Password =?");//find the statement
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
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



        return false;
    }

    @Override
    public Users getUser_by_First_name(String data) {
        return null;
    }

    @Override
    public Users getUser_by_User_name(String username) {
        Connection conn = connUtil.getConnection();
        log.trace("Add user id and userrole ");
        Users users = new Users();
        ERS_USER_ROLES_DAO_IMP ers_user_roles_dao_imp = new ERS_USER_ROLES_DAO_IMP();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from ERS_USERS where ERS_Username = ?");//find the statement
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                users.setUserid(rs.getInt("ERS_USERs_ID"));
                users.setUserroleid(rs.getInt("User_Role_ID"));
            }
                users.setUser_role_id_name(ers_user_roles_dao_imp.Find_User_Role(users.getUserid()));
        }
            catch (SQLException e) {
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

        return users;
    }

    @Override
    public Users getUser(int userid) {
        Connection conn = connUtil.getConnection();
        log.trace("Add user id and userrole ");
        Users users = new Users();
        ERS_USER_ROLES_DAO_IMP ers_user_roles_dao_imp = new ERS_USER_ROLES_DAO_IMP();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from ERS_USERS where ERS_users_id = ?");//find the statement
            ps.setInt(1,userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                users.setUsername(rs.getString("ERS_Username"));
                users.setFirstname(rs.getString("User_First_Name"));
                users.setLastname(rs.getString("User_Last_Name"));
                users.setUserroleid(rs.getInt("User_Role_ID"));
            }
            users.setUser_role_id_name(ers_user_roles_dao_imp.Find_User_Role(users.getUserid()));
        }
        catch (SQLException e) {
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

        return users;
    }
}
