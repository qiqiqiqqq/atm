package cn.atm.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/checkBalance")
public class CheckBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date nowDate = new Date();
        DateFormat format = new SimpleDateFormat("\"yyyy年MM月dd日 HH:mm:ss\"");
        String now = format.format(nowDate);
        System.out.println("---------查询余额操作(时间点)---------");
        System.out.println(now);
        req.setAttribute("now_date", now.replace("\"", ""));

        req.getRequestDispatcher("jsps/atm/checkBalanceIndex2.jsp").forward(req, resp);

    }
}
