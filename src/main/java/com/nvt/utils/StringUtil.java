package com.nvt.utils;

public class StringUtil{
    public static String makeBeautiful(String str){
        return str.trim().replaceAll("\\s+", " ");
    }
}