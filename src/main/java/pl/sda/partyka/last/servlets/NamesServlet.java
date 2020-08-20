package pl.sda.partyka.last.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static pl.sda.partyka.third.FinalServlet.ATTRIBUTE;

@WebServlet ("/getName")
public class NamesServlet extends HttpServlet {

    static final String NAME_PARAMETER = "name";
    private static final String SERVER_ADDRESS = "http://localhost:8080/Server01/forbiddenNames";
    static final String NO_NAME_SERVLET_ADDRESS = "/Server01/noName";
    private static final String NAME_IS_FORBIDDEN_SERVLET_ADDRESS = "/Server01/nameIsForbidden";
    private static final String FEMALE_NAME_SERVLET = "/femaleName";
    private static final String MALE_NAME_SERVLET = "/maleName";

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nameFromRequest = request.getParameter(NAME_PARAMETER);
        response.setContentType("text/html");
        if (nameFromRequest==null || nameFromRequest.length()==0){
            response.sendRedirect(NO_NAME_SERVLET_ADDRESS);
            return;
        }
        if (checkIfForbidden(nameFromRequest)){
            response.sendRedirect(NAME_IS_FORBIDDEN_SERVLET_ADDRESS);
            return;
        }
        request.setAttribute(ATTRIBUTE, nameFromRequest);
        if (nameFromRequest.charAt(nameFromRequest.length()-1) == 'a') {
            request.getRequestDispatcher(FEMALE_NAME_SERVLET)
                    .forward(request, response);
        } else {
            request.getRequestDispatcher(MALE_NAME_SERVLET)
                    .forward(request, response);
        }
    }

    private boolean checkIfForbidden (String paramValue) throws IOException {
        URL url = new URL(SERVER_ADDRESS + "?" + NAME_PARAMETER + "=" + paramValue);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        connection.connect();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return "true".equals(bufferedReader.readLine());
    }
}
