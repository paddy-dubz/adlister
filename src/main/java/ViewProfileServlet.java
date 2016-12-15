import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        HttpSession session=request.getSession(false);

        if(session!=null){
            String username = (String)session.getAttribute("user");
            out.print("Hello, "+username+" Welcome to Profile");
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }
        else{
            out.print("Please login first");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        }

    }
}
