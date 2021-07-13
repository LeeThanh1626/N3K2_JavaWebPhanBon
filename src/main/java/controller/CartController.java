/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import cartdao.CartDAO;
import dao.CartDAO;
import dao.CartExcelExporter;
import dao.ProductDAO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Cart;
import model.Order;
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
public class CartController {

    @Autowired
    CartDAO cartdao;
    @Autowired
    ProductDAO dao;

    @RequestMapping(value = "/listcart")
    public ModelAndView ShowCart(HttpServletRequest request, HttpServletResponse response) {
        String phone = "";
        String name = "";
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("phoneC")) {
                phone = o.getValue();
            }
            if (o.getName().equals("nameC")) {
                name = o.getValue();
            }
        }
        List<Cart> lst = cartdao.AllCart(phone);
        ModelAndView cart = new ModelAndView("product/cart", "list", lst);
        cart.addObject("name", name);
        
        float total = 0;
        for (Cart i : lst) {
            //lấy giá theo 1kg
            float price = i.getPrice() / i.getSpecifications();
            //lấy số kg đc mua 
            int amount = i.getAmount();
            //thành tiền
            total += price * amount;
            cart.addObject("money", total);
            cart.addObject("phone", i.getPhone());
        }
        return cart;
    }

    //thêm và xử lý giỏ hàng
    @RequestMapping(value = "/addcart", method = RequestMethod.GET)
    public String AddCart(HttpServletRequest request, HttpServletResponse response) {
        String ids = request.getParameter("id");
        int id = Integer.parseInt(ids);
        Product b = dao.DetailProduct(id);
        Cart cart = new Cart();
        cart.setName(b.getName());
        cart.setPic(b.getPic());
        cart.setPrice(b.getPrice());
        cart.setSpecifications(b.getSpecifications());
        //mặc định mua đúng bằng số kg của quy cách
        cart.setAmount(b.getSpecifications());
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("phoneC")) {
                cart.setPhone(o.getValue());
            }
        }
        cartdao.ThemCart(cart);
        return "redirect:/list.html";
    }

    //Xử lý button cart
    @RequestMapping(value = "/subproductcart")
    public String Sub(@RequestParam("id") int id) {
        int cart = cartdao.Sub(id);
        ModelAndView subcart = new ModelAndView("product/cart");
        return "redirect:/listcart.html";
    }

    @RequestMapping(value = "/addproductcart")
    public String Add(@RequestParam("id") int id) {
        int cart = cartdao.Add(id);
        ModelAndView add = new ModelAndView("product/cart");
        return "redirect:/listcart.html";
    }

    @RequestMapping(value = "/deleteproductcart")
    public String Detele(@RequestParam("id") int id) {
        int cart = cartdao.Delete(id);
        ModelAndView de = new ModelAndView("product/cart");
        return "redirect:/listcart.html";
    }

    @RequestMapping(value = "/buy")
    public String Buy(@RequestParam("totalmoney") float totalmoney, @RequestParam("phone") String phone) {
        
        cartdao.Buy(totalmoney, phone);
//        ModelAndView list = new ModelAndView("product/listProduct");
        return "redirect:/report.html";
    }
       @RequestMapping(value = "/report")
    public ModelAndView userListReport(HttpServletRequest req, HttpServletResponse res) {

        String phone = "";
        String name = "";
        Cookie arr[] = req.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("phoneC")) {
                phone = o.getValue();
            }
            if (o.getName().equals("nameC")) {
                name = o.getValue();
            }
        }
        List<Order> lst = cartdao.AllOrder(phone);

        return new ModelAndView("product/report","cart", lst);
    }
    
    @RequestMapping(value = "/export",method=RequestMethod.GET)
    public void exportToExcel(HttpServletRequest req,HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
          DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        String phone = "";
//        String name = "";
        Cookie arr[] = req.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("phoneC")) {
                phone = o.getValue();
            }
//            if (o.getName().equals("nameC")) {
//                name = o.getValue();
//            }
        }
        
        List<Order> lst = cartdao.AllOrder(phone);
////        List<Order> lst = cartdao.AllOrder();
        CartExcelExporter excelExporter = new CartExcelExporter(lst);

        excelExporter.export(response);
        cartdao.DeleCart(phone);

    }

}
