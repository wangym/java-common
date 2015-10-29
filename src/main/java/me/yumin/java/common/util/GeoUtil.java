package me.yumin.java.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chinawym@gmail.com
 * @since 2015-07-28
 */
public final class GeoUtil {
    private GeoUtil() {
    }

    private static final double PI = 3.14159265358979324 * 3000.0 / 180.0;

    /**
     * BD09转GCJ02(百度坐标转高德坐标)
     *
     * @param baiduLat 百度坐标纬度
     * @param baiduLog 百度坐标经度
     * @return
     */
    public static double[] convertBD09ToGCJ02(double baiduLat, double baiduLog) throws Exception {
        double[] result = {};

        if (0 != baiduLat && 0 != baiduLog) {
            double y = baiduLat - 0.006;
            double x = baiduLog - 0.0065;
            double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * PI);
            double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * PI);
            double lat = z * Math.sin(theta);
            double log = z * Math.cos(theta);

            if (0 != lat && 0 != log) {
                result = new double[2];
                result[0] = new BigDecimal(lat).setScale(6, RoundingMode.HALF_EVEN).doubleValue();
                result[1] = new BigDecimal(log).setScale(6, RoundingMode.HALF_EVEN).doubleValue();
            }
        }

        return result;
    }

    /**
     * 市一级模糊
     * example: 330100 -> 3301*
     *
     * @param cityCode
     * @return
     */
    public static String getFuzzyCityCode(String cityCode) {
        return appendCityCodeTail(cityCode, 0, 4, "*");
    }

    /**
     * 取两点距离(返回公里)
     * 基于Google Android SDK内原生算法封装
     *
     * @param startLatLog 起点纬经度(纬前经后逗号间隔)
     * @param endLatLog   终度纬经度(纬前经后逗号间隔)
     * @return
     */
    public static float getDistanceBetween(String startLatLog, String endLatLog) throws Exception {
        float result = -1;

        if (StringUtil.isNotEmpty(startLatLog, endLatLog)) {
            if (startLatLog.contains(",") && endLatLog.contains(",")) {
                String[] start = startLatLog.split(",");
                String[] end = endLatLog.split(",");
                if ((null != start && 2 == start.length) && (null != end && 2 == end.length)) {
                    Double startLatitude = NumberUtil.parseDouble(start[0]);
                    Double startLongitude = NumberUtil.parseDouble(start[1]);
                    Double endLatitude = NumberUtil.parseDouble(end[0]);
                    Double endLongitude = NumberUtil.parseDouble(end[1]);

                    if (NumberUtil.isNotEmpty(startLatitude, startLongitude, endLatitude, endLongitude) &&
                            (0 != startLatitude && 0 != startLongitude && 0 != endLatitude && 0 != endLongitude)) {
                        float[] results = new float[1];
                        distanceBetween(startLatitude, startLongitude, endLatitude, endLongitude, results);
                        if (null != results && 0 < results.length) {
                            // 从米转为公里且用银行家模式舍位
                            result = new BigDecimal(results[0] * 0.001).setScale(2, RoundingMode.HALF_EVEN).floatValue();
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @param results
     */
    public static void computeDistanceAndBearing(double lat1, double lon1,
                                                 double lat2, double lon2, float[] results) {
        // Based on http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf
        // using the "Inverse Formula" (section 4)

        int MAXITERS = 20;
        // Convert lat/long to radians
        lat1 *= Math.PI / 180.0;
        lat2 *= Math.PI / 180.0;
        lon1 *= Math.PI / 180.0;
        lon2 *= Math.PI / 180.0;

        double a = 6378137.0; // WGS84 major axis
        double b = 6356752.3142; // WGS84 semi-major axis
        double f = (a - b) / a;
        double aSqMinusBSqOverBSq = (a * a - b * b) / (b * b);

        double L = lon2 - lon1;
        double A = 0.0;
        double U1 = Math.atan((1.0 - f) * Math.tan(lat1));
        double U2 = Math.atan((1.0 - f) * Math.tan(lat2));

        double cosU1 = Math.cos(U1);
        double cosU2 = Math.cos(U2);
        double sinU1 = Math.sin(U1);
        double sinU2 = Math.sin(U2);
        double cosU1cosU2 = cosU1 * cosU2;
        double sinU1sinU2 = sinU1 * sinU2;

        double sigma = 0.0;
        double deltaSigma = 0.0;
        double cosSqAlpha = 0.0;
        double cos2SM = 0.0;
        double cosSigma = 0.0;
        double sinSigma = 0.0;
        double cosLambda = 0.0;
        double sinLambda = 0.0;

        double lambda = L; // initial guess
        for (int iter = 0; iter < MAXITERS; iter++) {
            double lambdaOrig = lambda;
            cosLambda = Math.cos(lambda);
            sinLambda = Math.sin(lambda);
            double t1 = cosU2 * sinLambda;
            double t2 = cosU1 * sinU2 - sinU1 * cosU2 * cosLambda;
            double sinSqSigma = t1 * t1 + t2 * t2; // (14)
            sinSigma = Math.sqrt(sinSqSigma);
            cosSigma = sinU1sinU2 + cosU1cosU2 * cosLambda; // (15)
            sigma = Math.atan2(sinSigma, cosSigma); // (16)
            double sinAlpha = (sinSigma == 0) ? 0.0 :
                    cosU1cosU2 * sinLambda / sinSigma; // (17)
            cosSqAlpha = 1.0 - sinAlpha * sinAlpha;
            cos2SM = (cosSqAlpha == 0) ? 0.0 :
                    cosSigma - 2.0 * sinU1sinU2 / cosSqAlpha; // (18)

            double uSquared = cosSqAlpha * aSqMinusBSqOverBSq; // defn
            A = 1 + (uSquared / 16384.0) * // (3)
                    (4096.0 + uSquared *
                            (-768 + uSquared * (320.0 - 175.0 * uSquared)));
            double B = (uSquared / 1024.0) * // (4)
                    (256.0 + uSquared *
                            (-128.0 + uSquared * (74.0 - 47.0 * uSquared)));
            double C = (f / 16.0) *
                    cosSqAlpha *
                    (4.0 + f * (4.0 - 3.0 * cosSqAlpha)); // (10)
            double cos2SMSq = cos2SM * cos2SM;
            deltaSigma = B * sinSigma * // (6)
                    (cos2SM + (B / 4.0) *
                            (cosSigma * (-1.0 + 2.0 * cos2SMSq) -
                                    (B / 6.0) * cos2SM *
                                            (-3.0 + 4.0 * sinSigma * sinSigma) *
                                            (-3.0 + 4.0 * cos2SMSq)));

            lambda = L +
                    (1.0 - C) * f * sinAlpha *
                            (sigma + C * sinSigma *
                                    (cos2SM + C * cosSigma *
                                            (-1.0 + 2.0 * cos2SM * cos2SM))); // (11)

            double delta = (lambda - lambdaOrig) / lambda;
            if (Math.abs(delta) < 1.0e-12) {
                break;
            }
        }

        float distance = (float) (b * A * (sigma - deltaSigma));
        results[0] = distance;
        if (results.length > 1) {
            float initialBearing = (float) Math.atan2(cosU2 * sinLambda,
                    cosU1 * sinU2 - sinU1 * cosU2 * cosLambda);
            initialBearing *= 180.0 / Math.PI;
            results[1] = initialBearing;
            if (results.length > 2) {
                float finalBearing = (float) Math.atan2(cosU1 * sinLambda,
                        -sinU1 * cosU2 + cosU1 * sinU2 * cosLambda);
                finalBearing *= 180.0 / Math.PI;
                results[2] = finalBearing;
            }
        }
    }

    /**
     * @param cityCode
     * @param beginIndex
     * @param endIndex
     * @param tail
     * @return
     * http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201504/t20150415_712722.html
     */
    private static String appendCityCodeTail(String cityCode, int beginIndex, int endIndex, String tail) {
        String result = cityCode;

        if (StringUtil.isNotEmpty(cityCode) && 6 == cityCode.length()) {
            result = new StringBuffer(cityCode.substring(beginIndex, endIndex)).append(tail).toString();
        }

        return result;
    }

    /**
     * Computes the approximate distance in meters between two
     * locations, and optionally the initial and final bearings of the
     * shortest path between them.  Distance and bearing are defined using the
     * WGS84 ellipsoid.
     * <p/>
     * <p> The computed distance is stored in results[0].  If results has length
     * 2 or greater, the initial bearing is stored in results[1]. If results has
     * length 3 or greater, the final bearing is stored in results[2].
     *
     * @param startLatitude  the starting latitude
     * @param startLongitude the starting longitude
     * @param endLatitude    the ending latitude
     * @param endLongitude   the ending longitude
     * @param results        an array of floats to hold the results
     * @throws IllegalArgumentException if results is null or has length < 1
     */
    private static void distanceBetween(double startLatitude, double startLongitude,
                                        double endLatitude, double endLongitude, float[] results) {
        if (results == null || results.length < 1) {
            throw new IllegalArgumentException("results is null or has length < 1");
        }
        computeDistanceAndBearing(startLatitude, startLongitude,
                endLatitude, endLongitude, results);
    }
}
