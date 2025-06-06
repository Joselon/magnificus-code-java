package util.values.fraction;

public class Fraction {

  private final int numerator;
  private final int denominator;

  public Fraction(int numerator, int denominator) {
    assert denominator != 0;

    if (denominator < 0) {
      numerator *= -1;
      denominator *= -1;
    }
    if (numerator != 0) {
      int gcd = Math.gcd(numerator > 0 ? numerator : -numerator, denominator);
      numerator = numerator / gcd;
      denominator = denominator / gcd;
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Fraction(int numerator) {
    this(numerator, 1);
  }

  public Fraction() {
    this(0);
  }

  public Fraction add(Fraction fraction) {
    assert fraction != null;

    return new Fraction(
        this.numerator * fraction.denominator + fraction.numerator * this.denominator,
        this.denominator * fraction.denominator);
  }

  public Fraction add(int integer) {
    return this.add(new Fraction(integer));
  }

  public Fraction subtract(Fraction fraction) {
    assert fraction != null;

    return this.add(fraction.opposite());
  }

  public Fraction subtract(int integer) {
    return this.subtract(new Fraction(-integer));
  }

  public Fraction opposite() {
    return new Fraction(-this.numerator, this.denominator);
  }

  public Fraction multiply(Fraction fraction) {
    assert fraction != null;

    return new Fraction(
        this.numerator * fraction.numerator,
        this.denominator * fraction.denominator);
  }

  public Fraction multiply(int integer) {
    return this.multiply(new Fraction(integer));
  }

  public Fraction divide(Fraction fraction) {
    assert fraction != null;

    return this.multiply(fraction.reverse());
  }

  public Fraction divide(int integer) {
    return this.divide(new Fraction(1, integer));
  }

  public Fraction reverse() {
    return new Fraction(this.denominator, this.numerator);
  }

  public Fraction power(int exponent) {
    assert exponent >= 0;

    Fraction power = new Fraction(1);
    for (int i = 0; i < exponent; i++) {
      power = power.multiply(this);
    }
    return power;
  }

  public int numerator() {
    return this.numerator;
  }

  public int denominator() {
    return this.denominator;
  }

  public double value() {
    return (double) this.numerator / this.denominator;
  }

  public Fraction clone() {
    return new Fraction(this.numerator, this.denominator);
  }

  public String toString() {
    return "Fraction (" + this.numerator + "/" + this.denominator + ")";
  }

  public boolean lesser(Fraction fraction) {
    return this.numerator() * fraction.denominator() < fraction.numerator() * this.denominator();
  }

  public boolean greater(Fraction fraction) {
    return this.numerator() * fraction.denominator() > fraction.numerator() * this.denominator();
  }

  public boolean equals(Fraction fraction) {
    if (this == fraction)
      return true;
    if (fraction == null)
      return false;
    if (this.numerator != fraction.numerator)
      return false;
    if (this.denominator != fraction.denominator)
      return false;
    return true;
  }

  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + numerator;
    result = prime * result + denominator;
    return result;
  }

}
