/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import dao.CartDAO;
import dao.ProductDAO;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Cart;
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
    ProductDAO dao;
//    CartDAO cartdao;

    @RequestMapping(value = "/listcart")
    public ModelAndView LayCart(HttpServletRequest request, HttpServletResponse response) {
        String phone = "";
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("phoneC")) {
                phone = o.getValue();
            }
        }
        List<Cart> lst = dao.AllCart(phone);
        ModelAndView cart = new ModelAndView("product/cart", "list", lst);
        float total = 0;
        for (Cart i : lst) {
            float price = i.getPrice();
            int amount = i.getAmount();
            total += price * amount;
            cart.addObject("money", total);
            cart.addObject("phone", i.getPhone());
        }
        return cart;
    }

    //thêm và xử lý giỏ hàng
    @RequestMapping(value = "/addcart", method = RequestMethod.GET)
    public String AddCart(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        Product b = dao.DetailProduct(id);
        Cart cart = new Cart();
        cart.setName(b.getName());
        cart.setPic(b.getPic());
        cart.setPrice(b.getPrice());
        cart.setSpecifications(b.getSpecifications());
        cart.setAmount(1);
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("phoneC")) {
                cart.setPhone(o.getValue());
            }
        }
        dao.ThemCart(cart);
        return "redirect:/list.html";
    }

    //Xử lý button cart
    @RequestMapping(value = "/subproductcart")
    public String Sub(@RequestParam("id") int id) {
        int cart = dao.Sub(id);
        ModelAndView subcart = new ModelAndView("product/cart");
        return "redirect:/listcart.html";
    }

    @RequestMapping(value = "/addproductcart")
    public String Add(@RequestParam("id") int id) {
        int cart = dao.Add(id);
        ModelAndView add = new ModelAndView("product/cart");
        return "redirect:/listcart.html";
    }

    @RequestMapping(value = "/deleteproductcart")
    public String Detele(@RequestParam("id") int id) {
        int cart = dao.Delete(id);
        ModelAndView de = new ModelAndView("product/cart");
        return "redirect:/listcart.html";
    }

    @RequestMapping(value = "/buy")
    public String Buy(@RequestParam("totalmoney") float totalmoney, @RequestParam("phone") String phone) {
        dao.Buy(totalmoney, phone);
        ModelAndView list = new ModelAndView("product/listProduct");
        return "redirect:/list.html";
    }
}
