package mts.student.servlet;

import mts.student.domain.University;
import mts.student.service.UniversityService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * JSP пример. Сервлет, который вызывает сервлет с JSP 
 */

@WebServlet(name = "UniversityListServlet", urlPatterns = {"/universityList"})
public class UniversityListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // контекст сервлета.  Позволяет спрингу и сервлету узнать друг о друге
        // контекст - описание того, что это за сервлет и где он существует, с чем работает
        ServletContext ctx = getServletContext();
        WebApplicationContext webAppCtx = WebApplicationContextUtils.getWebApplicationContext(ctx);
        UniversityService service = webAppCtx.getBean(UniversityService.class);
        List<University> universities = service.findUniversities();

        universities.forEach(
                uni -> System.out.println(
                        uni.getUniversityId()
                                + " : " + uni.getUniversityName()
                                + " : " + uni.getFaculties().size()));

        // с помощью метода forward передатёся управление в сервелт JSP
        getServletContext().getRequestDispatcher("/universityList.jsp").forward(req, resp);

    }
}
