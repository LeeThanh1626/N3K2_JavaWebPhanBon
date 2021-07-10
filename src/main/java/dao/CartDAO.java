///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import java.util.List;
//import model.Cart;
//import model.User;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// *
// * @author Dell 7450
// */
//public class CartDAO {
//
//    JdbcTemplate carttemplate;
//
//    public void setTemplate(JdbcTemplate carttemplate) {
//        this.carttemplate = carttemplate;
//    }
//
//    //gio hang
//    public List<Cart> AllCart(String phone) {
//        String sql = "select * from cart where phone=?";
//        return carttemplate.query(sql, new Object[]{phone}, new BeanPropertyRowMapper<>(Cart.class));
//    }
//
//    public void ThemCart(Cart cart) {
//        int Idexist = IsExit(cart.getPhone(), cart.getName(), cart.getSpecifications());
//        if (Idexist != 0) {
//            Cart product = searchCart(cart.getPhone(), cart.getName(), cart.getSpecifications());
//            int sl = product.getAmount() + 1;
//            UpdateCart(sl, product.getId());
//        } else {
//            String sql = String.format("insert into cart (phone,name, specifications,pic, price, amount) values('%s','%s','%d','%s','%f','%d')",
//                    cart.getPhone(), cart.getName(), cart.getSpecifications(), cart.getPic(), cart.getPrice(), cart.getAmount());
//            carttemplate.update(sql);
//        }
//
//    }
//
//    //kiểm tra giỏ hàng của người dùng có sp hay chưa
//    public int IsExit(String phone, String name, int specifications) {
//        String sql = "select count(*) from cart where specifications=? and name = ? and phone = ?";
//        int temp = carttemplate.queryForObject(sql, new Object[]{specifications, name, phone}, Integer.class);
//        return temp;
//    }
//
//    //lấy thông tin của sp nếu tồn tại 
//    public Cart searchCart(String phone, String name, int specifications) {
//        String sql = "select * from cart where specifications=? and name = ? and phone = ?";
//        Cart temp = carttemplate.queryForObject(sql, new Object[]{specifications, name, phone}, new BeanPropertyRowMapper<>(Cart.class));
//        return temp;
//    }
//
//    public Cart searchCart(int id) {
//        String sql = "select * from cart where id=?";
//        return carttemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Cart.class));
//    }
//
//    public int UpdateCart(int sl, int id) {
//        if (sl == 0) {
//            return Delete(id);
//        } else {
//            String sub = "update cart set amount=? where id=?";
//            return carttemplate.update(sub, sl, id);
//        }
//
//    }
//
//    //Cập nhât giỏ hàng khi tăng giảm số lượng
//    public int Sub(int id) {
//        Cart c = searchCart(id);
//        int sl = c.getAmount() - 1;
//        return UpdateCart(sl, id);
//    }
//
//    public int Add(int id) {
//        Cart c = searchCart(id);
//        int sl = c.getAmount() + 1;
//        return UpdateCart(sl, id);
//    }
//
//    public int Delete(int id) {
//        String sql = "delete from cart where id = ?";
//        return carttemplate.update(sql, id);
//    }
//
//    public User Search_User(String phone) {
//        String sql = "select * from users where phone = ?";
//        return carttemplate.queryForObject(sql, new Object[]{phone}, new BeanPropertyRowMapper<>(User.class));
//    }
//
//    public void Buy(float totalmoney, String phone) {
//        User u = Search_User(phone);
//        if (u.getId() != 0) {
//            float newmoney = (float) (u.getMoney() - totalmoney);
//            if (newmoney < 0) {
//                JFrame frame = new JFrame("Swing Tester");
//                JOptionPane.showMessageDialog(frame,
//                        "Tài Khoản Không Đủ", "",
//                        JOptionPane.INFORMATION_MESSAGE);
//                ModelAndView v = new ModelAndView("book/listSach");
//            } else {
//                String sub = "update users set money=? where phone=?";
//                carttemplate.update(sub, newmoney, phone);
//                Dele(phone);
//            }
//
//        }
//    }
//
//    public void Dele(String phone) {
//        String sql = "delete from cart where phone = ?";
//        carttemplate.update(sql, phone);
//    }
//}
