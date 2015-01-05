package echo.alich.testing;

public class Sine {
  private static double sine(double frequency, double time, double samplerate) {
    return 32767 * 0.9 * Math.sin(2 * Math.PI * frequency * time / samplerate);
  }

  public static double[] wave(double frequency, int length) {
    double[] res = new double[length];
    for (int i = 0; i < length; i++) {
      res[i] = sine(frequency, i, 44100);
    }
    return res;
  }

  // overloading
  public static short[] wave(int frequency, int length) {
    short[] res = new short[length];
    for (int i = 0; i < length; i++) {
      res[i] = (short) sine(frequency, i, 44100);
    }
    return res;
  }
}
