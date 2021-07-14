/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import dao.UserDAO;
import java.text.ParseException;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.DoanhThu;
import model.Order;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        us.addObject("name", name);
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

    //phần Admin Quản lý User 
    //list user 
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public ModelAndView ListUser(HttpServletRequest req) {
        List<User> lst = userdao.AllUser();
        String username = "";
        Cookie arr[] = req.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                username = o.getValue();
            }
        }
        ModelAndView listU = new ModelAndView("user/listUser", "list", lst);
        listU.addObject("name", username);
        return listU;
    }

    //xóa user
    @RequestMapping(value = "/deleteUser")
    public String Xoa(@RequestParam("id") String id) {
        userdao.Delete(id);
        return "redirect:/listUser.html";
    }

    //Sửa user
    @RequestMapping(value = "/editUser", produces = "text/plain;charset=UTF-8")
    public ModelAndView CapNhat_User(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        User u = userdao.DetailUser(id);
        String username = "";
        Cookie arr[] = req.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                username = o.getValue();
            }
        }
        ModelAndView edit = new ModelAndView("user/edit", "u", u);
        edit.addObject("name", username);
        return edit;
    }

    //Nạp tiền user
    @RequestMapping(value = "/addMoneyUser", produces = "text/plain;charset=UTF-8")
    public ModelAndView addMoneyUser(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        User u = userdao.DetailUser(id);
        String username = "";
        Cookie arr[] = req.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                username = o.getValue();
            }
        }
        ModelAndView addmoney = new ModelAndView("user/NapTien", "u", u);
        addmoney.addObject("name", username);
        return addmoney;
    }

    //xem lịch sử mua hàng
    @RequestMapping(value = "/purchseHistory", produces = "text/plain;charset=UTF-8")
    public ModelAndView purchseHistory(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        User u = userdao.DetailUser(id);
        String username = "";
        Cookie arr[] = req.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                username = o.getValue();
            }
        }
        List<Order> lst = userdao.AllOrder(u.getPhone());
        ModelAndView history = new ModelAndView("user/purchseHistory", "list", lst);
        history.addObject("name", username);
        return history;
    }

    //xác nhận nộp tiền
    @RequestMapping(value = "/XacNhan", method = RequestMethod.GET)
    public String NapTien(User u) {
        userdao.NapTaiKhoan(u);
        return "redirect:/listUser.html";
    }

    //thêm user 
    @RequestMapping(value = "/addUser")
    public ModelAndView Them_ui(HttpServletRequest req) {
        String username = "";
        Cookie arr[] = req.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                username = o.getValue();
            }
        }
        ModelAndView addU = new ModelAndView("user/add");
        addU.addObject("name", username);
        return addU;
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

    // hiên giao diên doanh thu:
    @RequestMapping(value = "/revenue")
    public ModelAndView DoanhThu(HttpServletRequest req) {
        String username = "";
        Cookie arr[] = req.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                username = o.getValue();
            }
        }
        ModelAndView addU = new ModelAndView("user/revenue");
        addU.addObject("name", username);
        return addU;
    }

    //xem thống kê:
    @RequestMapping(value = "/statistical", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public ModelAndView XemThongKe(HttpServletRequest req) throws ParseException {
//        string to java.sql.day
        ModelAndView history = new ModelAndView("user/revenue");
        if ("".equals(req.getParameter("startday")) && "".equals(req.getParameter("endday"))) {
            JFrame frame = new JFrame("Swing Tester");
            JOptionPane.showMessageDialog(frame,
                    "Vui lòng chọn ngày", "",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            Date startday = Date.valueOf(req.getParameter("startday"));
            Date enday = Date.valueOf(req.getParameter("endday"));
            //tạo list lưu số tiền trong ngày theo user(list doanh thu)
            List<DoanhThu> dthu = new ArrayList<>();
            //date1 < date2, trả về giá trị nhỏ hơn 0 
            int ss = startday.compareTo(enday);
            List<Date> dates = new ArrayList<>();
            if (ss < 0) {
                Date tempday = startday;
                while (tempday.compareTo(enday) <= 0) {
                    //add ngày vào list

                    dates.add(tempday);
                    //list order theo ngay 
                    List<Order> usday = userdao.Search_OrderDay(tempday);
                    //orderday là ds đặt hàng trong ngày
                    float money = 0;
                    for (int j = 0; j < usday.size(); j++) {
                        DoanhThu orderday = new DoanhThu();
                        java.sql.Date oday = new java.sql.Date(usday.get(j).getDay().getTime());
                        orderday.setNgay(oday);
                        orderday.setName(usday.get(j).getNameuser());
                        orderday.setTien(usday.get(j).getTotal());
                        //khỏi tạo phần tử đầu doah thu
                        if (dthu.isEmpty()) {
                            dthu.add(orderday);
                        }
                        //kiểm tra từng dòng trong list order theo ngày

                        for (int i = 0; i < dthu.size(); i++) {
                            java.sql.Date dtdate = new java.sql.Date(dthu.get(i).getNgay().getTime());
                            if (oday.equals(dtdate) == true) {
                                if (orderday.getName() == dthu.get(i).getName()) {
                                    money += orderday.getTien();
                                    DoanhThu newdt = new DoanhThu();
                                    newdt.setName(orderday.getName());
                                    newdt.setNgay(orderday.getNgay());
                                    newdt.setTien(money);
                                    dthu.set(i, newdt);
                                    continue;
                                }
                            }
//                            if (orderday.getName() != dthu.get(i).getName()) {
//                                dthu.add(orderday);
//                                break;
//                            }
                        }
                    }
                    tempday = userdao.addDays(tempday, 1);
                }
            }
            //xác đinh là admin đang truy cập trang
            String username = "";
            Cookie arr[] = req.getCookies();
            for (Cookie o : arr) {
                if (o.getName().equals("nameC")) {
                    username = o.getValue();
                }
            }
            history.addObject("name", username);
            history.addObject("list", dates);
            history.addObject("listUM", dthu);
        }
        return history;
    }

    //tìm user theo sđt
    @RequestMapping(value = "/SearchUser", method = RequestMethod.GET)
    public ModelAndView Search_User(HttpServletRequest req
    ) {
        String phone = req.getParameter("phone");
        List<User> u = userdao.Search_User(phone);
        String username = "";
        Cookie arr[] = req.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                username = o.getValue();
            }
        }
        ModelAndView search = new ModelAndView("user/listUser", "list", u);
        search.addObject("name", username);
        return search;
    }

}
