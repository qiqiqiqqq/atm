package cn.atm.controller;

import cn.atm.entity.Atm;
import cn.atm.entity.BankCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/weithdraw")
public class Weithdraw extends HttpServlet {
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
        if (money == null || money.trim().isEmpty()) {
            req.setAttribute("errors_Money", "输入金额不能为空");
           req.getRequestDispatcher("jsps/atm/withdrawIndex.jsp").forward(req,resp);
           return;
        }
        if (!money.matches("[0-9]*") || money.length() > 9) {// "/d" = "[0-9]"
            req.setAttribute("errors_Money", "请输入合法的数字金额");
            req.setAttribute("Money", money);
            req.getRequestDispatcher("jsps/atm/withdrawIndex.jsp").forward(req,resp);
            return;
        }

        double outMoney = Double.parseDouble(money);



        if (outMoney > 5000 || outMoney < 100 || outMoney%100 != 0) {
            req.setAttribute("errors_Money", "请输入100-5000的整百数");
            req.setAttribute("Money", money);
            req.getRequestDispatcher("jsps/atm/withdrawIndex.jsp").forward(req,resp);
            return;
        }

        if (bankCard.getCardBalance() < outMoney) {
            req.setAttribute("errors_Money", "账户余额不足");
            req.setAttribute("Money", money);
            req.getRequestDispatcher("jsps/atm/withdrawIndex.jsp").forward(req,resp);
            return;
        }


        try {

            bankCard.setCardBalance(bankCard.getCardBalance()-outMoney);


            req.getSession().setAttribute("seesion_bankCard", bankCard);

                AtmService atmService = new AtmService();
            atmService.record(bankCard.getCardId(),"取款业务", -1*outMoney, "取款:" + money);

            req.setAttribute("msg", "取款 " + money +"元");
            req.getRequestDispatcher("jsps/msg.jsp").forward(req, resp);
            return;
        } catch (Exception e) {
            req.setAttribute("errors_Money", "取款失败，已回滚事务");
            req.setAttribute("Money", money);
            req.getRequestDispatcher("jsps/atm/withdrawIndex.jsp").forward(req, resp);
            return;

        }

    }

}

