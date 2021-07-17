/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
public class ProductController {

    @Autowired
    ProductDAO dao;

    //lấy tất cả sản phẩm
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView LayDanhSach(HttpServletRequest request) {
        List<Product> lst = dao.AllProduct();
        String name = "";
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                name = o.getValue();
            }
        }
        ModelAndView us = new ModelAndView("product/listProduct", "list", lst);
        us.addObject("name", name);
        return us;
    }

    @RequestMapping(value = "/detailproduct", produces = "text/plain;charset=UTF-8")
    public ModelAndView Detail(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product b = dao.DetailProduct(id);
        String name = "";
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                name = o.getValue();
            }
        }
        ModelAndView detail = new ModelAndView("product/detail", "b", b);
        detail.addObject("name", name);
        return detail;
    }

    @RequestMapping(value = "/edit", produces = "text/plain;charset=UTF-8")
    public ModelAndView CapNhat_Product(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product b = dao.DetailProduct(id);
        String name = "";
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                name = o.getValue();
            }
        }
        ModelAndView edit = new ModelAndView("product/edit", "b", b);
        edit.addObject("name", name);
        return edit;
    }

    @RequestMapping(value = "/listSearch", method = RequestMethod.GET)
    public ModelAndView Search_product(HttpServletRequest request) {
        String name = request.getParameter("name");
        List<Product> lst = dao.Search_Product(name);
        String username = "";
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                username = o.getValue();
            }
        }
        ModelAndView search = new ModelAndView("product/listProduct", "list", lst);
        search.addObject("name", username);
        return search;
    }

    @RequestMapping(value = "/delete")
    public String Xoa(@RequestParam("id") String id) {
        dao.Xoa(id);
        return "redirect:/list.html";
    }

    @RequestMapping(value = "/add")
    public ModelAndView Them_ui(HttpServletRequest request) {
        String username = "";
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("nameC")) {
                username = o.getValue();
            }
        }
        ModelAndView add = new ModelAndView("product/add");
        add.addObject("name", username);
        return add;    
    }

    // cập nhật product xuống database khi sửa hoặc thêm mới
    //test up hình ảnh
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String Saves(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        Product b = new Product();
        //tạo nơi lưu ảnh
        String folderupload = request.getServletContext().getRealPath("/Allproduct");
        Path uploadpath = Paths.get(folderupload);
        //nếu null tạo file tự động
        if (!Files.exists(uploadpath)) {
            Files.createDirectory(uploadpath);
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> multiparts = upload.parseRequest(request);
        for (FileItem item : multiparts) {
            if (!item.isFormField()) {
                // Process form file field (input type="file").
                String image = item.getFieldName();
                if ("pic".equals(image)) {
                    String nametemp = new File(item.getName()).getName();
                    String path = request.getServletContext().getRealPath("/Allproduct" + File.separator + nametemp);
                    item.write(new File(path));
                    b.setPic(nametemp);
                }
            } else {
                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                String nameproduct = item.getFieldName();
                if ("id".equals(nameproduct)) {
                    b.setId(Integer.parseInt(item.getString()));
                }
                if ("name".equals(nameproduct)) {
                    b.setName(item.getString());
                }
                if ("price".equals(nameproduct)) {
                    b.setPrice(Float.parseFloat(item.getString()));
                }
                if ("specifications".equals(nameproduct)) {
                    b.setSpecifications(Integer.parseInt(item.getString()));
                }
                if ("discount".equals(nameproduct)) {
                    b.setDiscount(Double.parseDouble(item.getString()));
                }
            }
        }
        if (b.getId() == 0) {
            dao.Them(b);
        } else {
            dao.CapNhat_NoImage(b);
        }
        return "redirect:/list.html";
    }
}
