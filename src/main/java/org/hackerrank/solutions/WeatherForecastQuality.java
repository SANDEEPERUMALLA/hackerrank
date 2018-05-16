package org.hackerrank.solutions;

public class WeatherForecastQuality {

    static int totalForecastInaccuracy(int[] t, int[] f) {

        int totalDiff = 0;
        for (int i = 0; i < t.length; i++) {
            totalDiff += Math.abs(t[i] - f[i]);
        }

        return totalDiff;

    }

}
