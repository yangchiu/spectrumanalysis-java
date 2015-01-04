package echo.alich.testing;

import java.util.Arrays;
import echo.alich.spectrum.Spectrum;
import echo.alich.spectrum.SpectrumFactory;

public class Testing {
  public static void main(String[] args) {

    // double version
    double[] d = Sine.wave(7000.0);
    System.out.println(Arrays.toString(d));

    Spectrum sp = SpectrumFactory.getSpectrum(d);
    System.out.println(sp.getMaxFrequency());

    // short version
    short[] s = Sine.wave(15200);
    System.out.println(Arrays.toString(s));

    Spectrum sp1 = SpectrumFactory.getSpectrum(s);
    System.out.println(sp1.getMaxFrequency());
    // sp1.printSprectrum();

    // file input
    Spectrum sp2 = SpectrumFactory.getSpectrum("test.wav");
    System.out.println(sp2.getMaxFrequency());

    // file input
    Spectrum sp3 = SpectrumFactory.getSpectrum("test1.wav");
    System.out.println(sp3.getMaxFrequency());
    // sp3.printSprectrum();

  }
}
