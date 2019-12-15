package cn.atm.controller;

import cn.atm.entity.Bank;
import cn.atm.entity.BankCard;
import cn.atm.entity.PageBean;
import cn.atm.entity.Record;
import cn.atm.service.BankCardService;
import cn.atm.service.impl.BankCardImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/showRecords")
public class ShowRecords extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BankCard bankCard = (BankCard) req.getSession().getAttribute("session_bankCard");
        String cardId = bankCard.getCardId();
        String currentPage = req.getParameter("currentPage");

        String rows = req.getParameter("rows");

        if(currentPage==null||"".equals(currentPage)){
            currentPage = "1";

        }
        if(rows == null ||"".equals(rows)){
            rows = "5";
        }
        BankCardService service = new BankCardImpl();
        PageBean<Record> pb = null;
        try {
            pb = service.findRecordsByPage(currentPage,rows,cardId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(pb);
        req.setAttribute("pb",pb);
        req.getRequestDispatcher("jsps/atm/recordList.jsp").forward(req,resp);
        return;

    }
}
