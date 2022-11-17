package com.ming.entity;

import com.ming.pdfbox.PdfBox;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public interface DllPerson extends Library {
    public static DllPerson dllPerson = Native.load("/DllPerson.dll", DllPerson.class);
    public static class Person extends Structure
    {
        public static class ByReference extends Person implements Structure.ByReference{}
        public static class ByValue extends Person implements Structure.ByValue{}
        public String name;
        public String birth;
        public int height;
        public String address;
        public String phone;
        public String education;
        public String site;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"name", "birth", "height", "address", "phone", "education", "site"});
        }
    }
    public int add(int a, int b);
}
