package base.utils;

import base.helper.CourseState;

import java.text.*;
import java.util.*;

/**
 * Created by yugi on 2017/3/15.
 */
public class MyTool {

    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";

    public static CourseState courseStateCheck(Date begindate ,Date enddate ){
        SimpleDateFormat df = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT);
        Date datenow = new Date();
        int beginresult = datenow.compareTo(begindate);
        if (beginresult == -1){
            return CourseState.PRE;
        }

        int endresult = datenow.compareTo(enddate);
        if (endresult == 1){
            return CourseState.POST;
        }

        return CourseState.IN;
    }

}
