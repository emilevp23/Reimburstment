

import java.util.ArrayList;

public interface ERS_REIMBURSEMENT_DAO {
    Reimbursement Get_Reimburstment(int reimburstment_id);
    ArrayList<Reimbursement> list_of_Reimburstments();
    ArrayList<Reimbursement> employee_pending_Reimburstments(int employee_id);
    ArrayList<Reimbursement> fm_past_Reimburtments(int fm_id);
    ArrayList<Reimbursement> fm_pending_Reimburstments(int fm_id);
    ArrayList<Reimbursement> filter_last_name(String lastname, boolean past);
    ArrayList<Reimbursement> filter_type(int type, boolean past);
    ArrayList<Reimbursement> filter_first_name(String firstname, boolean past);
    ArrayList<Reimbursement> filter_email(String email, boolean past);
    ArrayList<Reimbursement> filter_status(int status, boolean past);
    void addReimburstment(Reimbursement reimb);
    void update(Reimbursement reimb);

}
