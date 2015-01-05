# sound-wave-spectrum-analysis
- Perform a fast Fourier transform on an input sound wave, and find the highest frequency content.
- Only for sampling rate 44100 Hz, 16bits sound waves.
- Based on Princeton University's FFT.java and Complex.java, and Evan X. Merz's wavIO.java.

#### Usage
Sine.java is a testing class could generate sine wave. 
```java
// generate a 7000Hz sine wave for testing, and its length is 144.
double[] d = Sine.wave(7000.0, 144);
// generate a 15200Hz sine wave for testing, and its length is 5000.
short[] s = Sine.wave(15200, 5000);
```
Use SpectrumFactory to get spectrum instance.
SpectrumFactory can take short[] or double[] as input.
```java
Spectrum sp = SpectrumFactory.getSpectrum(d);
System.out.println(sp.getMaxFrequency()); // print 7062.890625
System.out.println(sp.toString());
// print 
// Frequency  :  Power
// ----------------
// ...
// 6890.625Hz : 1700042.1632794542
// 7062.890625Hz : 1977663.0627275368
// 7235.15625Hz : 592296.5430651765
// ...

Spectrum sp1 = SpectrumFactory.getSpectrum(s);
System.out.println(sp1.getMaxFrequency()); // print 15202.44140625
System.out.println(sp1.toString());
// print 
// Frequency  :  Power
// ----------------
// ...
// 15191.6748046875Hz : 4370942.933990619
// 15197.05810546875Hz : 6.09374780517657E7
// 15202.44140625Hz : 6.477688652496028E7
// 15207.82470703125Hz : 9199349.095677244
// 15213.2080078125Hz : 1.5681220933112206E7
// ...
```
In addition to an array, you can pass the path of a .wav file to SpectrumFactory, too.
```java
Spectrum sp2 = SpectrumFactory.getSpectrum("test.wav");
System.out.println(sp2.getMaxFrequency()); // print 19437.500953674316
System.out.println(sp2.toString());
// print 
// Frequency  :  Power
// ...
// 19437.16449737549Hz : 1.4710080850219736E8
// 19437.248611450195Hz : 8.507037367724767E7
// 19437.332725524902Hz : 2.2422675262277237E8
// 19437.41683959961Hz : 1.593377680933934E8
// 19437.500953674316Hz : 7.842938989794059E8
// 19437.585067749023Hz : 1.4648378261883026E8
// 19437.66918182373Hz : 2.2384439900906795E8
// 19437.753295898438Hz : 7.255469188774545E7
// ...
```