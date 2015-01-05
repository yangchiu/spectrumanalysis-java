# sound-wave-spectrum-analysis
- Perform a fast Fourier transform on an input sound wave, and find the highest frequency content.
- Only for sampling rate 44100 Hz, 16bits sound waves.
- Based on Princeton University's FFT.java and Complex.java, and Evan X. Merz's wavIO.java.

##### Usage
```java
// generate a 7000Hz sine wave for testing, and its length is 144.
double[] d = Sine.wave(7000.0, 144);

// get spectrum instance
Spectrum sp = SpectrumFactory.getSpectrum(d);
System.out.println(sp.getMaxFrequency());
// print 7062.890625
System.out.println(sp.toString());
// print 
// Frequency  :  Power
// ----------------
// ...
// 6890.625Hz : 1700042.1632794542
// 7062.890625Hz : 1977663.0627275368
// 7235.15625Hz : 592296.5430651765
// ...
```