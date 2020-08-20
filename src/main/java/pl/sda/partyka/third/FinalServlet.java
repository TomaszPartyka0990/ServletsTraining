package pl.sda.partyka.third;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/finalServlet")
public class FinalServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(FinalServlet.class.getSimpleName());
    public static final String ATTRIBUTE = "name";

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String attributeValue = (String) request.getAttribute(ATTRIBUTE);
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        if (attributeValue != null) {
            writer.println("<h1>Hello, " + attributeValue + "!</h1>");
        } else {
            LOGGER.warning("Unauthorized access from: " + request.getRemoteAddr());
            writer.println("Unauthorized access!</h1>");
        }
    }
}
