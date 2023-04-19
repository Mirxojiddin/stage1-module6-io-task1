
package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String str = "";
        String name = "";
        String email = "";
        String[] newStr = new String[4];
        int son = 0;
        int age = 0;
        long phone = 0;
        String ress="";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsoluteFile())))) {


            String line = br.readLine();
            while (line != null) {
				newStr[son++] = line;
				line = br.readLine();
			}
            // int ch = fileInputStream.read();
            // while (ch != -1) {
            //     if ((char) ch == '\n' || (char) ch == ' ') {
            //         if ((char) ch == '\n') {
            //             newStr[son++] = str;
            //             str = "";
            //         }
            //         ch = fileInputStream.read();
            //         continue;
            //     }
            //     str += (char) ch;
            //     ch = fileInputStream.read();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            // exception handling
        } catch (IOException e) {
            System.out.println("I/O error");
        }
        String[] arrOfStr= newStr[0].split(":");
        arrOfStr[1] = arrOfStr[1].trim();
        name = arrOfStr[1];
        arrOfStr = newStr[1].split(":");
        arrOfStr[1] = arrOfStr[1].trim();
        age = Integer.valueOf(arrOfStr[1]);
        arrOfStr = newStr[2].split(":");
        arrOfStr[1] = arrOfStr[1].trim();
        email = arrOfStr[1];
        arrOfStr = newStr[3].split(":", 2);
        arrOfStr[1] = arrOfStr[1].trim();
        phone = Long.parseLong(arrOfStr[1]);

        return new Profile(name, age, email, phone);
    }
}
