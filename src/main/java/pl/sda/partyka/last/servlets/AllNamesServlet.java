package pl.sda.partyka.last.servlets;

import pl.sda.partyka.last.dao.FemaleNamesDao;
import pl.sda.partyka.last.dao.FemaleNamesImpl;
import pl.sda.partyka.last.dao.MaleNamesDao;
import pl.sda.partyka.last.dao.MaleNamesImpl;
import pl.sda.partyka.last.domain.FemaleNames;
import pl.sda.partyka.last.domain.MaleNames;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet ("/showAllNames")
public class AllNamesServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        FemaleNamesDao femaleNamesController = new FemaleNamesImpl();
        List<FemaleNames> allFemaleNames = femaleNamesController.findAll();
        MaleNamesDao maleNamesController = new MaleNamesImpl();
        List<MaleNames> allMaleNames = maleNamesController.findAll();
        response.setContentType("text/html");
        Iterator<FemaleNames> femaleIterator = allFemaleNames.iterator();
        Iterator<MaleNames> maleIterator = allMaleNames.iterator();
        PrintWriter writer = response.getWriter();
        writer.println("<table border=\"1\">");
        writer.println("<tr>");
        writer.println("<th>Kobiety</th>");
        writer.println("<th>Mezczyzni</th>");
        writer.println("</tr>");
        while (femaleIterator.hasNext() || maleIterator.hasNext()){
            writer.println("<tr>");
            writer.println("<td>");
            writer.println((femaleIterator.hasNext())?femaleIterator.next():"");
            writer.println("</td>");
            writer.println("<td>");
            writer.println((maleIterator.hasNext())?maleIterator.next():"");
            writer.println("</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
    }
}
