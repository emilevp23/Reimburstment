import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ERS_REIMBURSEMENT_TYPE_DAO_IMP implements ERS_REIMBURSEMENT_TYPE_DAO {
    private Logger log = Logger.getRootLogger();

    private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();


    public String Reimbursement_Type(int reimburesment_type_id) {
        Connection conn = connUtil.getConnection();
        log.trace("Reimbursement Type ");
        try  {
            PreparedStatement ps = conn.prepareStatement("select reimb_type from Ers_Reimbursement_type where Reimb_type_Id = ?");//find the statement
            ps.setInt(1,reimburesment_type_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("reimb_type");//find the statement
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
