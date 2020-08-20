package pl.sda.partyka.last.servlets;

import pl.sda.partyka.last.dao.MaleNamesDao;
import pl.sda.partyka.last.dao.MaleNamesImpl;
import pl.sda.partyka.last.domain.MaleNames;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static pl.sda.partyka.last.servlets.NamesServlet.NO_NAME_SERVLET_ADDRESS;
import static pl.sda.partyka.third.FinalServlet.ATTRIBUTE;

@WebServlet ("/maleName")
public class MaleServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String attributeValue = (String) request.getAttribute(ATTRIBUTE);
        if (attributeValue==null){
            response.sendRedirect(NO_NAME_SERVLET_ADDRESS);
            return;
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h3>Witaj " + attributeValue + ", jestes mezczyzna</h3>");
        MaleNamesDao maleNamesController = new MaleNamesImpl();
        MaleNames maleName = new MaleNames();
        maleName.setName(attributeValue);
        maleNamesController.createOrUpdate(maleName);
        writer.println("<br><h3>Dodano do bazy imion meskich</h3>");
    }
}
