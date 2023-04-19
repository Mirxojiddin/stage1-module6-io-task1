package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
            String str = "", name="",email="";
            String[] newStr =  new String[4];
            int son = 0, age=0;
            long phone=0;
        try(FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath())) {
            int ch = fileInputStream.read();
            
            while(ch != -1) {
                if ((char)ch=='\n'){
                    newStr[son++] = str;
                    str = "";
                    ch = fileInputStream.read();
                    continue;
                }
                if ((char)ch==' '){
                    ch = fileInputStream.read();
                    continue;
            
                }
                str += (char)ch;
                ch = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            // exception handling
        } catch (IOException e) {
            System.out.println("I/O error");
        }
        for (int i=0; i<4; i++){
            String[] arrOfStr = str.split(":", 2);
            if (arrOfStr[0] == "Name")
                name = arrOfStr[1];
            if (arrOfStr[0] == "Age")
                age = Integer.parseInt(arrOfStr[1]);
            if (arrOfStr[0] == "Email")
                email = arrOfStr[1];
            if (arrOfStr[0] == "Phone")
                phone = Long.parseLong(arrOfStr[1]);
        }
        return new Profile(name,age,email,phone);
    }
}
