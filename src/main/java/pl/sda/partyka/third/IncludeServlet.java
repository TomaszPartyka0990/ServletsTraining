package pl.sda.partyka.third;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static pl.sda.partyka.third.FinalServlet.ATTRIBUTE;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<h1>Strona przekierowana po stronie serwera - include</h1>");

        request.setAttribute(ATTRIBUTE, "Tomasz");
        request.getRequestDispatcher("/finalServlet")
                .include(request, response);
    }
}
