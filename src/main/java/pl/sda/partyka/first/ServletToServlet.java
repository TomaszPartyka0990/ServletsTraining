package pl.sda.partyka.first;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/servletToServlet", "/servletsCommunication"})
public class ServletToServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ServletToServlet.class.getSimpleName());
    private static final String QUERRY_PARAMETER = "giveRandomNumber";
    private static final String EXPECTED_VALUE = "true";
    private static final String SERVER_ADDRESS = "http://localhost:8080/Server01/randomJson";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String giveRandomNumber = request.getParameter(QUERRY_PARAMETER);

        PrintWriter writer = response.getWriter();
        if (EXPECTED_VALUE.equals(giveRandomNumber)) {
            writer.println("<h1>" + getRandomNumber() + "</h1");
        } else {
            writer.println("<h2>Done!</h2>");
        }
    }

    private String getRandomNumber() throws IOException {
        URL url = new URL(SERVER_ADDRESS);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        connection.connect();
        LOGGER.info("Response code: " + connection.getResponseCode());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return bufferedReader.readLine();
    }
}
