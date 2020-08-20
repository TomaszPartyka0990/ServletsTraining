package pl.sda.partyka.last.servlets;

import pl.sda.partyka.last.dao.FemaleNamesDao;
import pl.sda.partyka.last.dao.FemaleNamesImpl;
import pl.sda.partyka.last.domain.FemaleNames;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static pl.sda.partyka.last.servlets.NamesServlet.NO_NAME_SERVLET_ADDRESS;
import static pl.sda.partyka.third.FinalServlet.ATTRIBUTE;

@WebServlet ("/femaleName")
public class FemaleServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String attributeValue = (String) request.getAttribute(ATTRIBUTE);
        if (attributeValue==null){
            response.sendRedirect(NO_NAME_SERVLET_ADDRESS);
            return;
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h3>Witaj " + attributeValue + ", jestes kobieta</h3>");
        FemaleNamesDao femaleNamesController = new FemaleNamesImpl();
        FemaleNames femaleName = new FemaleNames();
        femaleName.setName(attributeValue);
        femaleNamesController.createOrUpdate(femaleName);
        writer.println("<br><h3>Dodano do bazy imion zenskich</h3>");
    }
}
