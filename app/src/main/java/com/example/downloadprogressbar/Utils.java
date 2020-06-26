package com.example.downloadprogressbar;

import android.content.Context;
import android.util.DisplayMetrics;

public class Utils {
    public static int convertDpToPixel(double dp, Context context) {
        return (int) dp * (context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
    public static int convertDpToPixel(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
