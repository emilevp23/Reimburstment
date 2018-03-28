import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;



@WebServlet("/update")
public class Update_Reimbursement_Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();

        Reimbursement reimbursement = (Reimbursement) new Gson().fromJson(reader, Reimbursement.class);
        ERS_REIMBURSEMENT_DAO_IMP ers_reimbursement_dao_imp = new ERS_REIMBURSEMENT_DAO_IMP();
        ers_reimbursement_dao_imp.update(reimbursement);
        response.getWriter().write("Database updated");


    }


}
