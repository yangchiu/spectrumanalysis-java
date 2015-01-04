package echo.alich.utils;

public class ArrayUtils {

  public static Short[] toObject(short[] arr) {
    Short[] res = new Short[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  public static Double[] toObject(double[] arr) {
    Double[] res = new Double[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  public static short[] byte2Short(byte[] b) {
    short[] s = new short[b.length / 2];
    for (int i = 0; i < s.length; i++) {
      s[i] = (short) ((b[i * 2] & 0xff) | (b[i * 2 + 1] << 8));
    }
    return s;
  }

  public static short[] concat(short[] a, short[] b) {
    int aLen = a.length;
    int bLen = b.length;
    short[] c = new short[aLen + bLen];
    System.arraycopy(a, 0, c, 0, aLen);
    System.arraycopy(b, 0, c, aLen, bLen);
    return c;
  }
  
  public static double[] concat(double[] a, double[] b) {
    int aLen = a.length;
    int bLen = b.length;
    double[] c = new double[aLen + bLen];
    System.arraycopy(a, 0, c, 0, aLen);
    System.arraycopy(b, 0, c, aLen, bLen);
    return c;
  }

}
