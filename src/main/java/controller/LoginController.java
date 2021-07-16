/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Product;
import model.Login;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell 7450
 */
@Controller
public class LoginController {

    @Autowired
    UserDAO userdao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("user/login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String loginProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") Login login) throws IOException {
        ModelAndView u = null;
        User user = userdao.validateUser(login);
        if (null != user) {
            u = new ModelAndView("./product/header");
            u.addObject("phone", user.getPhone());
            u.addObject("password", user.getPassword());
            u.addObject("name", user.getName());
            //lưu cookie
            Cookie uc = new Cookie("phoneC", user.getPhone());
            Cookie pc = new Cookie("passC", user.getPassword());
            //lưu để xác định admin cho phân quyền
            Cookie nc = new Cookie("nameC", user.getName().replaceAll("\\s+",""));
            uc.setMaxAge(60 * 60 * 24 * 360);
            pc.setMaxAge(60 * 60 * 24 * 360);
            nc.setMaxAge(60 * 60 * 24 * 360);
            //lưu cookie lên chrome
            response.addCookie(uc);
            response.addCookie(pc);
            response.addCookie(nc);
//            return u;
            return "redirect:/list.html";
        }
        JOptionPane.showMessageDialog(null, "phone or password error");
            return "redirect:/login.html";
//        return u;
    }
}
