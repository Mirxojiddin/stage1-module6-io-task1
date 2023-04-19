package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
            String str = "";
            String name="";
            String email="";
            String[] newStr =  new String[4];
            int son = 0;
            int age=0;
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
            if (arrOfStr[0]!= null && arrOfStr[0].equals("Name") )
                name = arrOfStr[1];
            if (arrOfStr[0]!= null && arrOfStr[0].equals("Age"))
                age = Integer.parseInt(arrOfStr[1]);
            if (arrOfStr[0]!= null && arrOfStr[0].equals("Email"))
                email = arrOfStr[1];
            if (arrOfStr[0]!= null && arrOfStr[0].equals("Phone"))
                phone = Long.parseLong(arrOfStr[1]);
        }
        return new Profile(name,age,email,phone);
    }
}
