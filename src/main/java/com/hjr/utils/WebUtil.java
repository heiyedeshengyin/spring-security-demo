package com.hjr.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtil {

    public static String renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(string);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
