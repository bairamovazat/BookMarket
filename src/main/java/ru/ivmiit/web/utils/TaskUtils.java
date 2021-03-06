package ru.ivmiit.web.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskUtils {

    public static List<Integer> getPageList(int current, int count, int maxPage){
        List<Integer> result = new ArrayList<>();
        int start = current - count/2;
        start = start < 0 ? 0 : start;
        int end = start + count;

        for (int i = start; i < end; i ++){
            if(i <= maxPage){
                result.add(i);
            }
        }

        return result;
    }

    public static String getFullPath(String relativePath){
        File theDir = new File(relativePath);
        if(theDir.exists()){
            return theDir.getAbsolutePath();
        }else {
            throw new IllegalArgumentException("Path " + relativePath + " not exists");
        }
    }

}
