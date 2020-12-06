package com.airbnb.crud;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestUtils {

    public static String readTextFile(String filePath){
        StringBuffer sb = new StringBuffer();
        File file = null;
        Scanner scanner = null;
        try {
            file = ResourceUtils.getFile("classpath:"+filePath);
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                sb.append(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
