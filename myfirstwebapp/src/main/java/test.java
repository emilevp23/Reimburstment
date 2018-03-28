import com.google.gson.Gson;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ERS_REIMBURSEMENT_DAO_IMP ers_reimbursement_dao_imp = new ERS_REIMBURSEMENT_DAO_IMP();
        ArrayList<Reimbursement> yeah  =  ers_reimbursement_dao_imp.list_of_Reimburstments();
        ERS_REIMBURSEMENT_DAO_IMP ers_reimbursement_dao = new ERS_REIMBURSEMENT_DAO_IMP();
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAuthor(2);
        reimbursement.setAmount(200);
        reimbursement.setType(1);
        ers_reimbursement_dao_imp.addReimburstment(reimbursement);





        String json = new Gson().toJson(ers_reimbursement_dao.list_of_Reimburstments());
        System.out.println(json);
    }
}
