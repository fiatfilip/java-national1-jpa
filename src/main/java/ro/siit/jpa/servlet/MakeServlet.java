package ro.siit.jpa.servlet;

import ro.siit.jpa.entity.Make;
import ro.siit.jpa.listener.LocalEntityManagerFactory;
import ro.siit.jpa.service.DBMakesStore;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = {"/makes"})
public class MakeServlet extends HttpServlet {
    private DBMakesStore dbMakesStore;
    @Override
    public void init() throws ServletException {
        super.init();
        dbMakesStore = new DBMakesStore();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsps/makes/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String makeName = req.getParameter("make_name");
        Make make = new Make();
        make.setId(UUID.randomUUID());
        make.setName(makeName);

        dbMakesStore.addMake(make);

        List<Make> makes = dbMakesStore.getMakes();
        req.setAttribute("makes", makes);
        req.getRequestDispatcher("/jsps/makes/list.jsp").forward(req, resp);
    }
}
