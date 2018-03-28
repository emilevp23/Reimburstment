import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ERS_REIMBURSEMENT_STATUS_DAO_IMP implements ERS_REIMBURSEMENT_STATUS_DAO {
    private Logger log = Logger.getRootLogger();

    private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();


    public String Reimbursement_Status(int reimbursement_status_id) {
        Connection conn = connUtil.getConnection();
        log.trace("Reimbursement Status ");
        try  {
            PreparedStatement ps = conn.prepareStatement("select reimb_status from Ers_Reimbursement_Status where Reimb_Status_Id = ?");//find the statement
            ps.setInt(1,reimbursement_status_id);
            ResultSet rs = ps.executeQuery();
            log.trace("Excute the result set ");
            if(rs.next()){
                String status = rs.getString("reimb_status");

                log.trace("Reimbursement Status ");


                return status;//find the statement
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
