package pl.sda.partyka.second;

import com.google.common.base.Throwables;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/logger", "/log"})
public class LoggingServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoggingServlet.class.getSimpleName());
    private static final String PARAMETER = "valid";
    private static final String EXPECTED_VALUE = "hello";

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String parameterValue = request.getParameter(PARAMETER);

        PrintWriter writer = response.getWriter();
        if (parameterValue == null) {
            LOGGER.warning("Client used servlet incorrectly !");
        } else if (parameterValue.equals(EXPECTED_VALUE)) {
            LOGGER.info("Parameter value is " + parameterValue);
        } else {
            tryParameterValue(parameterValue, writer);
        }

        writer.println("Test logowania");
    }

    private void tryParameterValue(String parameterValue, PrintWriter writer) {
        try {
            Integer integer = Integer.valueOf(parameterValue);
            int result = 30 / integer;
            writer.println("Wynik: " + result);
            LOGGER.info("Result: " + result + " from parameterValue: " + parameterValue);
        } catch (Exception e) {
            LOGGER.warning("Exception from: " + parameterValue);
            LOGGER.warning(Throwables.getStackTraceAsString(e));
        }
    }
}
