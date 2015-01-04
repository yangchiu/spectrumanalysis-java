package echo.alich.spectrum;

import echo.alich.utils.ArrayUtils;
import evan.x.merz.wavIO;

public class SpectrumFactory {

  public static Spectrum<?> getSpectrum(short[] wave) {
    return new Spectrum<Short>(ArrayUtils.toObject(wave));
  }

  public static Spectrum<?> getSpectrum(double[] wave) {
    return new Spectrum<Double>(ArrayUtils.toObject(wave));
  }

  public static Spectrum<?> getSpectrum(String wavFilePath) {
    wavIO wav = new wavIO(wavFilePath);
    wav.read();
    byte[] wavData = wav.myData;
    short[] shortData = ArrayUtils.byte2Short(wavData);
    int shortLen = shortData.length;
    // System.out.println("before concat : " + shortLen);
    int i = 0;
    while (true) {
      if (Math.pow(2, i) == shortLen || Math.pow(2, i + 1) == shortLen)
        break;
      else if (Math.pow(2, i) < shortLen && Math.pow(2, i + 1) > shortLen) {
        int padding = (int) (Math.pow(2, i + 1) - shortLen);
        short[] paddingArray = new short[padding];
        shortData = ArrayUtils.concat(shortData, paddingArray);
        // System.out.println("concat : " + Math.pow(2, i+1));
        break;
      }
      i++;
    }
    // System.out.println("after concat : " + shortData.length);
    return new Spectrum<Short>(ArrayUtils.toObject(shortData));
  }

}
