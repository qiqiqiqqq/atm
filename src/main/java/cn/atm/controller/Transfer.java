package cn.atm.controller;

import cn.atm.cherk.CheckBankCard;
import cn.atm.entity.Atm;
import cn.atm.entity.BankCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/transfer")
public class Transfer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardId = req.getParameter("cardId");
        String money = req.getParameter("money");

        Map<String, String> errors = new HashMap<String, String>();

        if (cardId == null || cardId.isEmpty()) {
            errors.put("bankCardId", "银行卡不能为空！");
        }else if (!CheckBankCard.checkBit(cardId)) {
            errors.put("bankCardId", "卡号位数无效！");
        }else if (!CheckBankCard.checkBankCard(cardId)) {
            errors.put("bankCardId", "卡号校验失败，无效银行卡！");
        }
        if (money == null || money.trim().isEmpty()) {
            errors.put("Money", "请输入要转账的金额");
        }else if (!money.matches("[0-9]*") || money.length() > 6) {// "/d" = "[0-9]"
            errors.put("Money", "请输入6位以下的人民币金额");
        }else if (Integer.parseInt(money) > 50000) {
            errors.put("Money", "最高支持50,000人民币转账");
        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
            req.setAttribute("money", money);
            req.setAttribute("cardId", cardId);
            req.getRequestDispatcher("jsps/atm/transferIndex.jsp").forward(req,resp);
            return;

        }

        try {
            AtmService atmService = new AtmService();
            BankCard bankCard = atmService.findCard(cardId);
            BankCard nowBankCard = (BankCard) req.getSession().getAttribute("session_bankCard");
            Atm atm = (Atm) req.getSession().getAttribute("session_atm");
            /*
             * 跨行收费0.5%
             */
            double outMoney = Double.parseDouble(money);
            double fee = 0;
            if (!bankCard.getBank().getBankId().equals(nowBankCard.getBank().getBankId())) {
                fee = outMoney*0.005 >= 50 ? 50 : outMoney*0.005;
            }
            if (nowBankCard.getCardBalance() < outMoney+fee) {
                req.setAttribute("msg", "账户余额不足");
                req.setAttribute("money", money);
                req.setAttribute("cardId", cardId);
                req.getRequestDispatcher("jsps/atm/transferIndex.jsp").forward(req,resp);
                return;
            }
            if (bankCard.getCardId().equals(nowBankCard.getCardId())) {
                req.setAttribute("msg", "暂不支持给自己用户转账");
                req.setAttribute("money", money);
                req.setAttribute("cardId", cardId);
                req.getRequestDispatcher("jsps/atm/transferIndex.jsp").forward(req,resp);
                return;
            }
            try {
                atmService.transfer(outMoney, fee, nowBankCard.getCardId(), cardId);
                nowBankCard.setCardBalance(nowBankCard.getCardBalance()-(outMoney+fee));
                req.getSession().setAttribute("seesion_bankCard", nowBankCard);

                atmService.record(nowBankCard.getCardId(),"转账业务", -1*outMoney,
                        "转账:" + money + ", TO:" + bankCard.getCardId() + ", 手续费：" + fee);

                req.setAttribute("msg", "成功给" + bankCard.getUser().getName() +
                        "(" + bankCard.getCardId() + ")"  + "转账 " + money +"元,业务手续费" + fee + "元。");
                req.getRequestDispatcher("jsps/msg.jsp").forward(req,resp);
                return;
            } catch (Exception e) {
                req.setAttribute("msg", "转账失败");
                req.setAttribute("Money", money);
                req.getRequestDispatcher("jsps/atm/transferIndex.jsp").forward(req,resp);
                return;
            }
        } catch (Exception e) {
            req.setAttribute("msg", e.getMessage());
            req.setAttribute("money", money);
            req.setAttribute("cardId", cardId);
            req.getRequestDispatcher("jsps/atm/transferIndex.jsp").forward(req,resp);
            return;
        }
    }
    }

