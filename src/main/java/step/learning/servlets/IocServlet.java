package step.learning.servlets;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import step.learning.services.hash.HashService;
import step.learning.services.random.RandomService;

import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class IocServlet extends HttpServlet {

    private final HashService hashService;
    private final RandomService randomService;

    @Inject
    public IocServlet(@Named("Digest-Hash") HashService hashService, RandomService randomService) {
        this.hashService = hashService;
        this.randomService = randomService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hash", hashService.hash("123"));
        req.setAttribute("random", randomService.randomHex(8)); // передаем длину строки, которую мы хотим сгенерировать
        req.setAttribute("page-body", "ioc.jsp");
        req.getRequestDispatcher("WEB-INF/_layout.jsp").forward(req, resp);
    }
}