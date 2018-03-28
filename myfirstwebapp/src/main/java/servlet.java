import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/hello")
public class servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        ERS_REIMBURSEMENT_DAO_IMP ers_reimbursement_dao = new ERS_REIMBURSEMENT_DAO_IMP();





        String json = new Gson().toJson(ers_reimbursement_dao.list_of_Reimburstments());

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().write(json);

    }
}


