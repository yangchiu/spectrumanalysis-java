package echo.alich.spectrum;

import edu.princeton.cs.Complex;
import edu.princeton.cs.FFT;

public class Spectrum<T extends Number> {

  private T[] wave;
  private double[] frequencyBins;
  private double[] spectrum;
  private double maxFrequency;
  private double maxPower;

  public double[] getFrequencyBins() {
    return frequencyBins;
  }

  public double[] getSpectrum() {
    return spectrum;
  }

  public double getMaxFrequency() {
    return maxFrequency;
  }

  public double getMaxPower() {
    return maxPower;
  }

  private void computeFrequencyBins() {

    int n = wave.length;
    int[] k = new int[n];

    for (int i = 0; i < n; i++) {
      k[i] = i;
    }

    double T = (double) n / 44100;
    frequencyBins = new double[n / 2];

    for (int i = 0; i < n / 2; i++) {
      frequencyBins[i] = k[i] / T;
    }

  }

  private void fft() {

    int n = wave.length;

    Complex[] cWave = new Complex[n];
    for (int i = 0; i < n; i++) {
      cWave[i] = new Complex(wave[i].doubleValue(), 0);
    }

    Complex[] fWave = FFT.fft(cWave);

    spectrum = new double[n / 2];
    for (int i = 0; i < n / 2; i++) {
      spectrum[i] = fWave[i].abs();
    }

    // find max frequency
    int index = 0;
    double max = -1;
    for (int i = 0; i < spectrum.length; i++) {
      if (spectrum[i] > max) {
        index = i;
        max = spectrum[i];
      }
    }

    maxFrequency = frequencyBins[index];
    maxPower = max;
  }

  public Spectrum(T[] wave) {

    this.wave = wave;
    computeFrequencyBins();
    fft();

  }

  public String toString() {
    StringBuilder sb = new StringBuilder("Frequency  :  Power\r\n----------------\r\n");
    for (int i = 0; i < frequencyBins.length; i++) {
      sb.append(frequencyBins[i] + "Hz : " + spectrum[i] + "\r\n");
    }
    return sb.toString();
  }

}
