package pl.sda.partyka.last.servlets;

import pl.sda.partyka.last.dao.ForbiddenNamesDao;
import pl.sda.partyka.last.dao.ForbiddenNamesImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static pl.sda.partyka.last.servlets.NamesServlet.NAME_PARAMETER;

@WebServlet ("/forbiddenNames")
public class ForbiddenNamesServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        ForbiddenNamesDao forbiddenNamesController = new ForbiddenNamesImpl();
        List<String> forbiddenNames = forbiddenNamesController.findAllNames();
        String nameFromRequest = request.getParameter(NAME_PARAMETER);
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        if (forbiddenNames.stream().anyMatch(nameFromRequest::equalsIgnoreCase)){
            writer.println(true);
        } else {
            writer.println(false);
        }
    }
}
