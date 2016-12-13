import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        List<String> names = new ArrayList<>();
        names.add("tito");
        names.add("britt");
        names.add("lloyd");
        names.add("eunice");

        req.setAttribute( "names", names);

        req.getRequestDispatcher("hello-world.jsp").forward(req, res);
    }
}
