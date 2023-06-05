package ru.hsse.reversecompatibility;

public class QueryConverter {
    public static String LikeToRegex(String expression){
        return (expression == null) ? "." :
                expression
                .toLowerCase()
                .replace(".","\\.")
                .replace("?",".")
                .replace("%",".*");
    }
}
