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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView LayDanhSach() {
        List<Product> lst = dao.AllProduct();
        ModelAndView us = new ModelAndView("product/listProduct", "list", lst);
        return us;
    }

    @RequestMapping(value = "/detailproduct", produces = "text/plain;charset=UTF-8")
    public ModelAndView Detail(@RequestParam("id") int id) {
        Product b = dao.DetailProduct(id);
        return new ModelAndView("product/detail", "b", b);
    }

    @RequestMapping(value = "/edit", produces = "text/plain;charset=UTF-8")
    public ModelAndView CapNhat_Product(@RequestParam("id") int id) {
        Product b = dao.DetailProduct(id);
        return new ModelAndView("product/edit", "b", b);
    }

    @RequestMapping(value = "/listSearch", method = RequestMethod.GET)
    public ModelAndView Search_product(@RequestParam("name") String name) {
        List<Product> lst = dao.Search_Product(name);
        return new ModelAndView("product/listProduct", "list", lst);
    }

    @RequestMapping(value = "/delete")
    public String Xoa(@RequestParam("id") String id) {
        dao.Xoa(id);
        return "redirect:/list.html";
    }

    @RequestMapping(value = "/add")
    public ModelAndView Them_ui() {
        return new ModelAndView("product/add");
    }

    // cập nhật product xuống database khi sửa hoặc thêm mới
    //test up hình ành
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String Saves(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        Product b = new Product();
        // cách này lưu đc ảnh nhưng không lưu đc data
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
