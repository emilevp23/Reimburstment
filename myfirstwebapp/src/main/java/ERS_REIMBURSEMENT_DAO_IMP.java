import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ERS_REIMBURSEMENT_DAO_IMP implements ERS_REIMBURSEMENT_DAO {
    private Logger log = Logger.getRootLogger();

    private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();



    public Reimbursement Get_Reimburstment(int reimburstment_id) {
        Connection conn = connUtil.getConnection();
        log.trace("Get the reimbursement data ");
        Reimbursement reimbursement = new Reimbursement();
        ERS_USERS_DAO_IMP ers_users_dao_imp = new ERS_USERS_DAO_IMP();
        ERS_REIMBURSEMENT_STATUS_DAO_IMP ers_reimbursement_status_dao_imp = new ERS_REIMBURSEMENT_STATUS_DAO_IMP();
        ERS_REIMBURSEMENT_TYPE_DAO_IMP ers_reimbursement_type_dao_imp = new ERS_REIMBURSEMENT_TYPE_DAO_IMP();
        try  {
            PreparedStatement ps = conn.prepareStatement("select * from Ers_Reimbursement where Reimb_Id = ?");//find the statement
            ps.setInt(1,reimburstment_id);// set the id of the reimbursement amount
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Users author = new Users();
                Users resolver = new Users();
                log.trace("populate the reimbursement");
                reimbursement.setId(rs.getInt("reimb_id"));
                reimbursement.setAmount(rs.getDouble("reimb_amount"));
                reimbursement.setSubmitted(rs.getTimestamp("reimb_submitted"));
                reimbursement.setResolved(rs.getTimestamp("reimb_resolved"));
                reimbursement.setDescription(rs.getString("reimb_Description"));
                reimbursement.setReceipt(rs.getBlob("reimb_receipt"));
                reimbursement.setAuthor(rs.getInt("reimb_author"));
                reimbursement.setResolver(rs.getInt("reimb_resolver"));
                reimbursement.setStatus(rs.getInt("reimb_status_id"));
                reimbursement.setType(rs.getInt("reimb_type_id"));
                reimbursement.setDescription(rs.getString("reimb_description"));
                resolver = ers_users_dao_imp.getUser(reimbursement.getResolver());
                author = ers_users_dao_imp.getUser(reimbursement.getAuthor());
                reimbursement.setAuthor_first_name(author.getFirstname());
                reimbursement.setAuthor_last_name(author.getLastname());
                reimbursement.setResolver_first_name(resolver.getFirstname());
                reimbursement.setResolver_last_name(resolver.getLastname());
                reimbursement.setStatus_name(ers_reimbursement_status_dao_imp.Reimbursement_Status(reimbursement.getStatus()));
                reimbursement.setType_name(ers_reimbursement_type_dao_imp.Reimbursement_Type(reimbursement.getType()));


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


        return reimbursement;
    }


    public ArrayList<Reimbursement> list_of_Reimburstments() {
        Connection conn = connUtil.getConnection();
        log.trace("Get the reimbursement data ");
        Reimbursement reimbursement = new Reimbursement();
        ArrayList<Reimbursement> arrayList = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Ers_Reimbursement");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                arrayList.add(Get_Reimburstment(rs.getInt("Reimb_id")));
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


        return arrayList;
    }


    public ArrayList<Reimbursement> employee_pending_Reimburstments(int employee_id) {
        return null;
    }


    public ArrayList<Reimbursement> fm_past_Reimburtments(int fm_id) {
        return null;
    }

    public ArrayList<Reimbursement> fm_pending_Reimburstments(int fm_id) {
        return null;
    }


    public ArrayList<Reimbursement> filter_last_name(String lastname, boolean past) {
        return null;
    }

    public ArrayList<Reimbursement> filter_type(int type, boolean past) {
        return null;
    }


    public ArrayList<Reimbursement> filter_first_name(String firstname, boolean past) {
        return null;
    }


    public ArrayList<Reimbursement> filter_email(String email, boolean past) {
        return null;
    }


    public ArrayList<Reimbursement> filter_status(int status, boolean past) {
        return null;
    }


    public void addReimburstment(Reimbursement reimb) {
        Connection conn = connUtil.getConnection();
        log.trace("Input a new a reimburstment ");
        try  {
            PreparedStatement ps = conn.prepareStatement("insert into Ers_Reimbursement( Reimb_Id, Reimb_Amount, Reimb_submitted, Reimb_Description,  Reimb_author, Reimb_type_id, Reimb_status_id) values(reimb_id_updater.nextval, ?, systimestamp, ?, ?,?,1)");//find the statement
            ps.setDouble(1,reimb.getAmount());// get the amount
            ps.setString(2,reimb.getDescription());
            ps.setInt(3,reimb.getAuthor());
            ps.setInt(4,reimb.getType());
            ResultSet rs = ps.executeQuery();


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

    }


    public void update(Reimbursement reimb) {
        Connection conn = connUtil.getConnection();
        log.trace("Change the status of a reimburstment ");
        try  {
            PreparedStatement ps = conn.prepareStatement("update Ers_Reimbursement set reimb_resolved = systimestamp, Reimb_Resolver = ?, Reimb_Status_Id = ? where Reimb_Id = ?");//find the statement
            ps.setInt(1,reimb.getResolver());
            ps.setInt(2,reimb.getStatus());
            ps.setInt(3,reimb.getId());
            ResultSet rs = ps.executeQuery();


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
    }
}
