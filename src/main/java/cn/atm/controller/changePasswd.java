package cn.atm.controller;

import cn.atm.entity.Atm;
import cn.atm.entity.BankCard;
import cn.atm.exception.BankCardException;
import cn.atm.service.BankCardService;
import cn.atm.service.impl.BankCardImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/changePasswd")
public class changePasswd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("session_bankCard") == null) {
            req.getRequestDispatcher("views/login2.jsp");

        }
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");

        Map<String, String> errors = new HashMap<String, String>();

        BankCard bankCard = (BankCard) req.getSession().getAttribute("session_bankCard");


        if (password == null) {
            errors.put("password", "密码不能为空");
        } else if (password.length() != 6) {
            errors.put("password", "密码位数不合法");
        }

        if (rePassword == null) {
            errors.put("password", "重新输入密码");
        } else if (!password.equals(rePassword)) {
            errors.put("rePassword", "两次输入密码不同");
        }

        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
            req.setAttribute("Password", password);
            req.setAttribute("RePassword", rePassword);
            req.getRequestDispatcher("/jsps/user/changePasswdIndex.jsp").forward(req,resp);
            return;

        }

        System.out.println("*********需要修改密码的银行卡对象(session)***********");
        System.out.println(bankCard);
        String cardId = bankCard.getCardId();

        BankCardService bankCardService = new BankCardImpl();
        try {
            bankCardService.changePasswd(cardId, password);
            req.getSession().removeAttribute("session_bankCard");
            resp.sendRedirect("views/login2.jsp");

        } catch (BankCardException e) {
            req.setAttribute("passwd_msg", e.getMessage());
            req.setAttribute("Password", password);
            req.setAttribute("RePassword", rePassword);
            req.getRequestDispatcher("jsps/user/changePasswdIndex.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
