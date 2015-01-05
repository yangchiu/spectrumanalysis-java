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

// in addition to a double array,
// the input sound wave can be a short array, too.

// generate a 15200Hz sine wave for testing, and its length is 5000.
short[] s = Sine.wave(15200, 5000);

// get spectrum instance
Spectrum sp1 = SpectrumFactory.getSpectrum(s);
System.out.println(sp1.getMaxFrequency());
// print 15202.44140625

// in addition to an array,
// you can pass the path of a .wav file to SpectrumFactory, too.

Spectrum sp2 = SpectrumFactory.getSpectrum("test.wav");
System.out.println(sp2.getMaxFrequency());
// print 19437.500953674316

```