/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Array;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Product;
import model.Login;
import model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell 7450
 */
public class UserDAO {

    JdbcTemplate jdbctemplate;

    public void setJdbctemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    //đăng ký user
    public void register(User user) {
        String sql1 = "select * from users where phone='" + user.getPhone() + "'";
        List<User> users = jdbctemplate.query(sql1, new UserMapper());
        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Đăng ký thành công!!");
            String sql = String.format("insert into users(name, password,phone, money) values('%s','%s','%s','%f')", user.getName(), user.getPassword(), user.getPhone(), 0.0);
            jdbctemplate.update(sql);
        } else {
            user.setId(-1);
            JFrame frame = new JFrame("Swing Tester");
            JOptionPane.showMessageDialog(frame,
                    "phone đã tồn tại", "",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<User> Search_User(String phone) {
        String sql = "select * from users where phone like ?";
        return jdbctemplate.query(sql, new Object[]{"%" + phone + "%"}, new BeanPropertyRowMapper<>(User.class));
    }

    public void NapTaiKhoan(User user) {
        User u = Search_phone(user.getPhone());
        if (u.getId() != 0) {
            float newmoney = (float) (u.getMoney() + user.getMoney());
            String sql = String.format("UPDATE users set money='%f' where id='%d'", newmoney, u.getId());
            jdbctemplate.update(sql);
        }
    }

    public User validateUser(Login login) {
        String sql = "select * from users where phone='" + login.getPhone() + "' and password='" + login.getPassword()
                + "'";

        List<User> users = jdbctemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;
    }

    public List<User> AllUser() {
        String sql = "select * from users ";
        return jdbctemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    //xóa user
    public int Delete(String id) {
        String sql = "delete from users where id = ?";
        return jdbctemplate.update(sql, id);
    }

    //chi tiết khách hàng
    public User DetailUser(int id) {
        String sql = "select * from users where id = ?";
        return jdbctemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public int CapNhat_NoImage(User u) {
        String sql = String.format("update users set name='%s' ,password='%s', phone='%s' where id ='%d' ",
                u.getName(), u.getPassword(), u.getPhone(), u.getId());
        return jdbctemplate.update(sql);
    }

    /// xác định user nạp tài khoản
    public User Search_phone(String phone) {
        String sql = "select * from users where phone = ?";
        return jdbctemplate.queryForObject(sql, new Object[]{phone}, new BeanPropertyRowMapper<>(User.class));
    }

    //lấy danh sách order theo phone
    public List<Order> AllOrder(String phone) {
        String sql = "select * from orders where phone = ?";
        return jdbctemplate.query(sql, new Object[]{phone}, new BeanPropertyRowMapper<>(Order.class));
    }

    public List<Order> Search_OrderDay(Date tempday) {
        String sql = "select * from orders where day = ?";
        return jdbctemplate.query(sql, new Object[]{tempday}, new BeanPropertyRowMapper<>(Order.class));
    }

    /**
     *
     * @param date
     * @param days
     * @return
     */
    //hàm tăng 1 ngày
    public Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }

    //lấy đơn hàng trong ngày của user
    public Order Search_OrderDay(Date tempday, String nameuser) {
        String sql = "select * from orders where day = ? and nameuser = ?";
        return jdbctemplate.queryForObject(sql, new Object[]{tempday, nameuser}, new BeanPropertyRowMapper<>(Order.class)); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Order> ListOrder() {
        String sql = "select * from orders";
        return jdbctemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }

}

class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setMoney(rs.getDouble("money"));
        user.setId(rs.getInt("id"));
        user.setPhone(rs.getString("phone"));
        return user;
    }
}
