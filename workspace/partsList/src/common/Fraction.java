package common;

import java.math.BigInteger;

public class Fraction {

	private static final BigInteger BIZero = new BigInteger("0");
	private static final BigInteger BIOne = new BigInteger("1");
	private static final BigInteger BIMinusOne = new BigInteger("-1");
	private static final BigInteger Ten = new BigInteger("10");
	
	public static final Fraction Null = new Fraction(BIZero, BIOne);
	
	private static final String FractionStroke = "/";
	private static final String Comma =",";

	public static Fraction parse(String fraction) {
		BigInteger denominator = BIOne;
		BigInteger enumerator = BIOne;
		if (fraction == null) return Fraction.Null;
		int fractionStrokePosition = fraction.indexOf(FractionStroke);
		if (fractionStrokePosition >= 0) {
			String enumeratorText = fraction.substring(0,fractionStrokePosition);
			if (enumeratorText.length() > 0) enumerator = new BigInteger(enumeratorText);
			String denominatorText = fraction.substring(fractionStrokePosition + FractionStroke.length(), fraction.length());
			if (denominatorText.length() > 0) denominator = new BigInteger(denominatorText);
		} else {
			int commaPosition = fraction.indexOf(Comma);
			if (commaPosition >= 0) {
				String inFrontOfComma = fraction.substring(0, commaPosition);
				String behindComma = fraction.substring(commaPosition + Comma.length(), fraction.length());
				enumerator = new BigInteger(inFrontOfComma + behindComma);
				denominator = Ten.pow(behindComma.length());
			} else {
				enumerator = new BigInteger(fraction);
			}
		}
		if (denominator.equals(BIZero)) throw new NumberFormatException("Denominator must not be zero!");
		return new Fraction(enumerator,denominator);
	}

	private BigInteger enumerator;
	private BigInteger getEnumerator() {
		return enumerator;
	}
	private BigInteger getDenominator() {
		return denominator;
	}

	private BigInteger denominator;

	public Fraction(BigInteger enumerator, BigInteger denominator) {
		BigInteger gcd = enumerator.gcd(denominator);
		boolean negativeDenominator = denominator.compareTo(BIZero) < 0;
		this.enumerator = enumerator.divide(gcd).multiply(negativeDenominator ? BIMinusOne : BIOne);
		this.denominator = denominator.divide(gcd).multiply(negativeDenominator ? BIMinusOne : BIOne);
	}
	@Override
	public String toString(){
		return this.getEnumerator().toString() + (this.getDenominator().equals(BIOne) ? "" : (FractionStroke + this.getDenominator().toString())); 
	}

	public Fraction add(Fraction argument) {
		return new Fraction(this.getEnumerator().multiply(argument.getDenominator()).add(argument.getEnumerator().multiply(this.getDenominator())), 
				            this.getDenominator().multiply(argument.getDenominator()));
	}
	public Fraction mul(Fraction argument) {
		return new Fraction(this.getEnumerator().multiply(argument.getEnumerator()), 
				            this.getDenominator().multiply(argument.getDenominator()));
	}
	public Fraction mul(Long argument) {
		return new Fraction(this.getEnumerator().multiply(new BigInteger(argument.toString())),this.getDenominator());
	}
	@Override
	public boolean equals(Object argument){
		if (argument instanceof Fraction){
			Fraction argumentAsFraction = (Fraction) argument;
			return this.getEnumerator().equals(argumentAsFraction.getEnumerator()) && this.getDenominator().equals(argumentAsFraction.getDenominator());
		} else {
			return false;
		}
	}
	@Override
	public int hashCode(){
		return this.getEnumerator().multiply(this.getDenominator()).hashCode();
	}
}