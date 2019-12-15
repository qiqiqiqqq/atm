package cn.atm.controller;

import cn.atm.Dao.BankCardDao;
import cn.atm.cherk.CheckBankCard;
import cn.atm.entity.Atm;
import cn.atm.entity.BankCard;
import cn.atm.entity.Record;
import cn.atm.entity.User;
import cn.atm.exception.BankCardException;
import cn.atm.service.BankCardService;
import cn.atm.service.impl.BankCardImpl;
import cn.itcast.commons.CommonUtils;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.commons.beanutils.BeanUtils;
import sun.security.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private BankCardDao bankCardDao = new BankCardDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



           doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");//处理响应编码
        req.setCharacterEncoding("UTF-8");
        HashMap<String, String> errors = new HashMap<>();
        Map erors = (Map)req.getAttribute("errors");
        System.out.println(erors);
        Map<String,String[]> map = req.getParameterMap();
        BankCard form = new BankCard();
        try {
            BeanUtils.populate(form,map);
            System.out.println(form);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String id = form.getCardId().trim();

        if(id == null || id.isEmpty()){
            errors.put("bankCarId","银行卡号不能为空");
        }else if (!CheckBankCard.checkBit(id)) {
            errors.put("bankCardId", "卡号位数无效！");
        } else if (!CheckBankCard.checkBankCard(id)) {
            errors.put("bankCardId", "卡号校验失败，无效银行卡！");
        }

        String password = form.getPassword().trim();
        if (password == null || password.isEmpty()) {
            errors.put("password1", "密码不能为空！");
        } else if (password.length() != 6) {
            errors.put("password", "无效的密码位数！");
        }

        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
            req.setAttribute("form", form);
            Map erorss = (Map)req.getAttribute("errors");
            System.out.println(erorss);
            req.getRequestDispatcher("views/login2.jsp").forward(req, resp);
        }

        try {
            BankCard bankCard = login(form);
            req.getSession().setAttribute("session_bankCard", bankCard);
            System.out.println("------登录用户-------");
            System.out.println(bankCard);
            resp.sendRedirect("jsps/atmIndex2.jsp");
        } catch (Exception e) {
            req.setAttribute("msg", e.getMessage());
            req.setAttribute("form", form);
            String erorss = (String)req.getAttribute("msg");
            System.out.println(erorss);
            req.getRequestDispatcher("views/login2.jsp").forward(req, resp);
        }
    }

//        if(errors!=null && !errors.isEmpty()){
//
//                req.setAttribute("errors",errors);
//                req.setAttribute("form", bankCard);
//
//                req.getRequestDispatcher("views/login2.jsp").forward(req, resp);
//
//        }else{
//            boolean bool = login(bankCard);
//            if(errors!=null && !errors.isEmpty()) {
//                req.setAttribute("errors", errors);
//                req.setAttribute("form", bankCard);
//                req.getRequestDispatcher("views/login2.jsp").forward(req, resp);
//            }else {
//                req.getSession().setAttribute("session_bankCard", bankCard);
//                resp.sendRedirect("jsps/atmIndex2.jsp");
//            }
//        }
//
//
//    }



    public BankCard login(BankCard form) throws BankCardException {
        BankCard bankCard = bankCardDao.findById(form.getCardId());
        if (bankCard.getCardId() == null) {
            throw new BankCardException("该银行卡账户不存在");
        }
        if (!bankCard.getPassword().equals(form.getPassword())) {
            if (bankCard.getErrorCount() > 0) {
                bankCardDao.updateCardErrcount(form.getCardId(), bankCard.getErrorCount()-1);
                throw new BankCardException("密码错误," + "还剩" + bankCard.getErrorCount() + "次输入机会");
            }else if (bankCard.getErrorCount() <= 0) {
                throw new BankCardException("该账户已被冻结");
            }
        }
        if (bankCard.getErrorCount() == 0) {
            throw new BankCardException("该账户已被冻结");
        }
        return bankCard;
    }


}

