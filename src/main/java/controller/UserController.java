/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import dao.UserDAO;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Login;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell 7450
 */
@Controller
public class UserController {

    @Autowired
    UserDAO userdao;

    @RequestMapping(value = "/TrangCaNhan", method = RequestMethod.GET)
    public ModelAndView TrangCaNhan(HttpServletRequest request, HttpServletResponse response) {
        String phone = "";
        String name = "";
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            //xác đinh 1 user, lấy thông tin cá nhân
            if (o.getName().equals("phoneC")) {
                phone = o.getValue();
            }
            if (o.getName().equals("nameC")) {
                name = o.getValue();
            }
        }
        User u = userdao.Search_phone(phone);
        ModelAndView us = new ModelAndView("user/TrangCaNhan", "u", u);
        //xác định user hay admin để hiển thị cho view
        us.addObject("name",name);
        return us;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private String eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        return "redirect:./";
    }

    //Quản lý User 
    //list user 
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public ModelAndView ListUser() {
        List<User> lst = userdao.AllUser();
        return new ModelAndView("user/listUser", "list", lst);
    }

    //xóa user
    @RequestMapping(value = "/deleteUser")
    public String Xoa(@RequestParam("id") String id) {
        userdao.Delete(id);
        return "redirect:/listUser.html";
    }

    //Sửa user
    @RequestMapping(value = "/editUser", produces = "text/plain;charset=UTF-8")
    public ModelAndView CapNhat_User(@RequestParam("id") int id) {
        User u = userdao.DetailUser(id);
        return new ModelAndView("user/edit", "u", u);
    }

    //Nạp tiền user
    @RequestMapping(value = "/addMoneyUser", produces = "text/plain;charset=UTF-8")
    public ModelAndView addMoneyUser(@RequestParam("id") int id) {
        User u = userdao.DetailUser(id);
        return new ModelAndView("user/NapTien", "u", u);

    }

    //xác nhận nộp tiền
    @RequestMapping(value = "/XacNhan", method = RequestMethod.GET)
    public String NapTien(User u) {
        userdao.NapTaiKhoan(u);
        return "redirect:/listUser.html";
    }

    //thêm user 
    @RequestMapping(value = "/addUser")
    public ModelAndView Them_ui() {
        return new ModelAndView("user/add");
    }

    // cập nhật user xuống database khi sửa hoặc thêm mới
    @RequestMapping(value = "/Save", method = RequestMethod.POST)
    public String Save_User(User u) {
        if (u.getId() == 0) {
            userdao.register(u);
        } else {
            userdao.CapNhat_NoImage(u);
        }
        return "redirect:/listUser.html";
    }

    //tìm user theo sđt
    @RequestMapping(value = "/SearchUser", method = RequestMethod.GET)
    public ModelAndView Search_User(@RequestParam("phone") String phone) {
        List<User> u = userdao.Search_User(phone);
        return new ModelAndView("user/listUser", "list", u);
    }

}
