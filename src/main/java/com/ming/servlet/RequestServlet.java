package com.ming.servlet;

import com.ming.entity.DllPerson;
import com.ming.pdfbox.PdfBox;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //System.out.println("做get请求");
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String realPath = getServletContext().getRealPath("简历.pdf");
        DllPerson.Person.ByReference person = PdfBox.getPerson(realPath);
        String personInfo = "姓名:" + person.name + "," + "邮箱：" + person.address +"," + "生日：" +
                person.birth + "," + "学历：" + person.education + "," + "电话：" + person.phone + "," + "地址：" +
                person.site + "," + "身高：" + person.height;
        System.out.println(personInfo);
        writer.write("<!DOCTYPE html><head><meta charset=\"utf-8\" />" +
                "<title></title></head>" +
                "<body><center><font>"+ personInfo +"</font></center></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
