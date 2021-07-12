/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import model.Product;
import model.Cart;
import model.User;
import dao.UserDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell 7450
 */
public class ProductDAO {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<Product> AllProduct() {
        return template.query("select * from product", new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product b = new Product();
                b.setId(rs.getInt(1));
                b.setName(rs.getNString(2));
                b.setSpecifications(rs.getInt(3));
                b.setPrice(rs.getFloat(4));
                b.setPic(rs.getNString(5));
                return b;
            }
        });
    }

    public void Them(Product b) {
        String sql = String.format("insert into product (name,specifications, price, pic) values('%s','%d','%f','%s')",
                b.getName(), b.getSpecifications(), b.getPrice(), b.getPic());
        template.update(sql);
    }

    public int CapNhat(Product b) {
        String sql = String.format("update product set price='%f',specifications='%d',pic='%s' where name=%s",
                b.getPrice(), b.getSpecifications(), b.getPic(), b.getName());
        return template.update(sql);
    }

    public int CapNhat_NoImage(Product b) {
        String sql = String.format("update product set name='%s' ,price='%f',specifications='%d' where id ='%d' ",
                b.getName(), b.getPrice(), b.getSpecifications(), b.getId());
        return template.update(sql);
    }

    public int Xoa(String id) {
        String sql = "delete from product where id = ?";
        return template.update(sql, id);
    }

    public Product DetailProduct(int id) {
        String sql = "select * from product where id = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> Search_Product(String name) {
        String sql = "select * from product where name like ?";
        return template.query(sql, new Object[]{"%" + name + "%"}, new BeanPropertyRowMapper<>(Product.class));
    }
}
