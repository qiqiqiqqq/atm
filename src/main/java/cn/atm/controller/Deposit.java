package cn.atm.controller;

import cn.atm.entity.BankCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/deposit")
public class Deposit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BankCard bankCard = (BankCard) req.getSession().getAttribute("session_bankCard");

        if (bankCard == null) {
            resp.sendRedirect("views/login.jsp");
            return;
        }

        String money = req.getParameter("money");
        Map<String, String> errors = new HashMap<String, String>();
        if (money == null || money.trim().isEmpty()) {
            errors.put("Money", "请放入要存取的人民币");
        }else if (!money.matches("[0-9]*") || money.length() > 9) {// "/d" = "[0-9]"
            errors.put("Money", "请放入完整的人民币");
        }else if (Integer.parseInt(money) > 20000 || Integer.parseInt(money) < 100
                || Integer.parseInt(money)%100 != 0) {
            errors.put("Money", "请放入100-20000的整百人民币");
        }

        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
            req.setAttribute("Money", money);
           req.getRequestDispatcher("jsps/atm/depositIndex.jsp").forward(req,resp);
           return;
        }

        try {
            AtmService atmService = new AtmService();
            atmService.deposit(Double.parseDouble(money), bankCard.getCardId());
            bankCard.setCardBalance(bankCard.getCardBalance()+Double.parseDouble(money));


            req.getSession().setAttribute("seesion_bankCard", bankCard);


            atmService.record(bankCard.getCardId(), "存款业务", Double.parseDouble(money),
                    "存款:" + money);

            req.setAttribute("msg", "存款 " + money +"元");
            req.getRequestDispatcher("jsps/msg.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("money_msg", "存款失败，已回滚事务");
            req.setAttribute("Money", money);
            req.getRequestDispatcher("jsps/atm/depositIndex.jsp").forward(req,resp);
        }
    }


}
