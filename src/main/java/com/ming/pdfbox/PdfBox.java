package com.ming.pdfbox;

import com.ming.entity.DllPerson;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PdfBox {
    public static DllPerson.Person.ByReference  getPerson(String path){

            try {
                PDDocument pdDocument = PDDocument.load(new File(path));
                PDPage page = pdDocument.getPage(0);
                PDFTextStripper pdfTextStripper = new PDFTextStripper();
                String text = pdfTextStripper.getText(pdDocument);

                String name = text.substring(0, 3);
                int index = text.indexOf("生日：");

                String birth = text.substring(index + 3, index + 13);
                index = text.indexOf("身高：");
                int height = Integer.parseInt(text.substring(index + 3, index + 6));
                index = text.indexOf("学历：");
                String education = text.substring(index + 3, index + 5);
                index = text.indexOf("地址：");
                String site = text.substring(index + 3, index + 20);
                index = text.indexOf("电话：");
                String phone = text.substring(index + 3, index + 14);
                index = text.indexOf("邮箱：");
                String address = text.substring(index + 3, index + 20);
                DllPerson.Person.ByReference person = new DllPerson.Person.ByReference();
                person.name = name;
                person.height = height;
                person.education = education;
                person.site = site;
                person.phone = phone;
                person.address = address;
                person.birth = birth;
                return person;
            } catch (IOException e) {
                System.out.println(e.toString());
                return null;
            }

    }

    public static void main(String[] args) {
        DllPerson.Person.ByReference person = PdfBox.getPerson("简历.pdf");

        String personInfo = "姓名:" + person.name + "," + "邮箱：" +
                person.address +"," + "生日：" + person.birth + "," + "学历：" + person.education + "," + "电话：";
        System.out.println(personInfo);
    }
}
