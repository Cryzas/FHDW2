package common;

import java.math.BigInteger;

public class Fraction {

	private static final BigInteger BIZero = new BigInteger("0");
	private static final BigInteger BIOne = new BigInteger("1");
	private static final BigInteger BITwo = new BigInteger("2");
	private static final BigInteger BIFive = new BigInteger("5");
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
		int decimalPosition = 0;
		BigInteger denominator = this.getDenominator();
		BigInteger enumerator = this.getEnumerator();
		while (!denominator.equals(BIOne)) {
			BigInteger[] quoMod = denominator.divideAndRemainder(BITwo);
			if (quoMod[1].equals(BIZero)){
				decimalPosition++;
				enumerator = enumerator.multiply(BIFive);
				denominator = quoMod[0];
			} else {
				quoMod = denominator.divideAndRemainder(BIFive);
				if (quoMod[1].equals(BIZero)){
					decimalPosition++;
					enumerator = enumerator.multiply(BITwo);
					denominator = quoMod[0];
				} else {
					return this.getEnumerator().toString() + FractionStroke + this.getDenominator().toString(); 					
				}
			}
		}
		String result = enumerator.toString();
		while (result.length() <= decimalPosition) result = "0" + result;
		int separatorPosition = result.length() - decimalPosition;
		if (separatorPosition == result.length()) return result;
		return result.substring(0, separatorPosition) + Comma + result.substring(separatorPosition, result.length());  
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