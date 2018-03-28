import com.google.gson.Gson;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/login")
public class Login_Servlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();

        Login_Credentials login_credentials = (Login_Credentials) new Gson().fromJson(reader, Login_Credentials.class);

        ERS_USERS_DAO_IMP ers_users_dao_imp = new ERS_USERS_DAO_IMP();
        if(ers_users_dao_imp.Find_User(login_credentials.getUsername(),login_credentials.getPassword())) {
            String json = new Gson().toJson(ers_users_dao_imp.getUser_by_User_name(login_credentials.getUsername()));

            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(json);
        }
        else {
            response.setStatus(400);
            response.getWriter().write("Invalid login");
        }


    }

}