package common;

import java.math.BigInteger;

import model.*;
import persistence.Grade4Public;
import persistence.GradesInThird4Public;
import persistence.PersistenceException;

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
	
	public boolean lessOrEquals(Fraction argument) {
		if(argument.equals(this)){
			return true;
		}
		return this.enumerator.multiply(argument.denominator).intValue() <= argument.enumerator.multiply(this.denominator).intValue();
	}
	public boolean less(Fraction argument) {
		return this.enumerator.multiply(argument.denominator).intValue() < argument.enumerator.multiply(this.denominator).intValue();
	}
	public Fraction div(Fraction argument) {
		return new Fraction(this.enumerator.multiply(argument.denominator), this.denominator.multiply(argument.enumerator));
	}
	public Fraction sub(Fraction argument) {
		return new Fraction(this.getEnumerator().multiply(argument.getDenominator()).subtract(argument.getEnumerator().multiply(this.getDenominator())), 
	            this.getDenominator().multiply(argument.getDenominator()));
	}
	
	public GradesInThird4Public toGradeinThird() throws PersistenceException {
		if(this.less(new Fraction(BigInteger.valueOf(3), BigInteger.valueOf(3)))){
			return NoGrade.getTheNoGrade();
		} else if (this.less(new Fraction(BigInteger.valueOf(4), BigInteger.valueOf(3)))) {
			return T_1_0.getTheT_1_0();
		} else if (this.less(new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(3)))) {
			return T_1_3.getTheT_1_3();
		} else if (this.less(new Fraction(BigInteger.valueOf(6), BigInteger.valueOf(3)))) {
			return T_1_7.getTheT_1_7();
		} else if (this.less(new Fraction(BigInteger.valueOf(7), BigInteger.valueOf(3)))) {
			return T_2_0.getTheT_2_0();
		} else if (this.less(new Fraction(BigInteger.valueOf(8), BigInteger.valueOf(3)))) {
			return T_2_3.getTheT_2_3();
		} else if (this.less(new Fraction(BigInteger.valueOf(9), BigInteger.valueOf(3)))) {
			return T_2_7.getTheT_2_7();
		} else if (this.less(new Fraction(BigInteger.valueOf(10), BigInteger.valueOf(3)))) {
			return T_3_0.getTheT_3_0();
		} else if (this.less(new Fraction(BigInteger.valueOf(11), BigInteger.valueOf(3)))) {
			return T_3_3.getTheT_3_3();
		} else if (this.less(new Fraction(BigInteger.valueOf(12), BigInteger.valueOf(3)))) {
			return T_3_7.getTheT_3_7();
		} else if (this.lessOrEquals(new Fraction(BigInteger.valueOf(9), BigInteger.valueOf(2)))) {
			return T_4_0.getTheT_4_0();
		} else if (this.lessOrEquals(new Fraction(BigInteger.valueOf(15), BigInteger.valueOf(3)))) {
			return T_5_0.getTheT_5_0();
		} else {
			return NoGrade.getTheNoGrade();
		}
	}
	
	public Grade4Public toGradeinTenth() throws PersistenceException {
		if(this.less(new Fraction(BigInteger.valueOf(3), BigInteger.valueOf(3)))){
			return NoGrade.getTheNoGrade();
		} else if (this.less(new Fraction(BigInteger.valueOf(11), BigInteger.valueOf(10)))) {
			return Z_1_0.getTheZ_1_0();
		} else if (this.less(new Fraction(BigInteger.valueOf(12), BigInteger.valueOf(10)))) {
			return Z_1_1.getTheZ_1_1();
		} else if (this.less(new Fraction(BigInteger.valueOf(13), BigInteger.valueOf(10)))) {
			return Z_1_2.getTheZ_1_2();
		} else if (this.less(new Fraction(BigInteger.valueOf(14), BigInteger.valueOf(10)))) {
			return Z_1_3.getTheZ_1_3();
		} else if (this.less(new Fraction(BigInteger.valueOf(15), BigInteger.valueOf(10)))) {
			return Z_1_4.getTheZ_1_4();
		} else if (this.less(new Fraction(BigInteger.valueOf(16), BigInteger.valueOf(10)))) {
			return Z_1_5.getTheZ_1_5();
		} else if (this.less(new Fraction(BigInteger.valueOf(17), BigInteger.valueOf(10)))) {
			return Z_1_6.getTheZ_1_6();
		} else if (this.less(new Fraction(BigInteger.valueOf(18), BigInteger.valueOf(10)))) {
			return Z_1_7.getTheZ_1_7();
		} else if (this.less(new Fraction(BigInteger.valueOf(19), BigInteger.valueOf(10)))) {
			return Z_1_8.getTheZ_1_8();
		} else if (this.less(new Fraction(BigInteger.valueOf(20), BigInteger.valueOf(10)))) {
			return Z_1_9.getTheZ_1_9();
		} else if (this.less(new Fraction(BigInteger.valueOf(21), BigInteger.valueOf(10)))) {
			return Z_2_0.getTheZ_2_0();
		} else if (this.less(new Fraction(BigInteger.valueOf(22), BigInteger.valueOf(10)))) {
			return Z_2_1.getTheZ_2_1();
		} else if (this.less(new Fraction(BigInteger.valueOf(23), BigInteger.valueOf(10)))) {
			return Z_2_2.getTheZ_2_2();
		} else if (this.less(new Fraction(BigInteger.valueOf(24), BigInteger.valueOf(10)))) {
			return Z_2_3.getTheZ_2_3();
		} else if (this.less(new Fraction(BigInteger.valueOf(25), BigInteger.valueOf(10)))) {
			return Z_2_4.getTheZ_2_4();
		} else if (this.less(new Fraction(BigInteger.valueOf(26), BigInteger.valueOf(10)))) {
			return Z_2_5.getTheZ_2_5();
		} else if (this.less(new Fraction(BigInteger.valueOf(27), BigInteger.valueOf(10)))) {
			return Z_2_6.getTheZ_2_6();
		} else if (this.less(new Fraction(BigInteger.valueOf(28), BigInteger.valueOf(10)))) {
			return Z_2_7.getTheZ_2_7();
		} else if (this.less(new Fraction(BigInteger.valueOf(29), BigInteger.valueOf(10)))) {
			return Z_2_8.getTheZ_2_8();
		} else if (this.less(new Fraction(BigInteger.valueOf(30), BigInteger.valueOf(10)))) {
			return Z_2_9.getTheZ_2_9();
		} else if (this.less(new Fraction(BigInteger.valueOf(31), BigInteger.valueOf(10)))) {
			return Z_3_0.getTheZ_3_0();
		} else if (this.less(new Fraction(BigInteger.valueOf(32), BigInteger.valueOf(10)))) {
			return Z_3_1.getTheZ_3_1();
		} else if (this.less(new Fraction(BigInteger.valueOf(33), BigInteger.valueOf(10)))) {
			return Z_3_2.getTheZ_3_2();
		} else if (this.less(new Fraction(BigInteger.valueOf(34), BigInteger.valueOf(10)))) {
			return Z_3_3.getTheZ_3_3();
		} else if (this.less(new Fraction(BigInteger.valueOf(35), BigInteger.valueOf(10)))) {
			return Z_3_4.getTheZ_3_4();
		} else if (this.less(new Fraction(BigInteger.valueOf(36), BigInteger.valueOf(10)))) {
			return Z_3_5.getTheZ_3_5();
		} else if (this.less(new Fraction(BigInteger.valueOf(37), BigInteger.valueOf(10)))) {
			return Z_3_6.getTheZ_3_6();
		} else if (this.less(new Fraction(BigInteger.valueOf(38), BigInteger.valueOf(10)))) {
			return Z_3_7.getTheZ_3_7();
		} else if (this.less(new Fraction(BigInteger.valueOf(39), BigInteger.valueOf(10)))) {
			return Z_3_8.getTheZ_3_8();
		} else if (this.less(new Fraction(BigInteger.valueOf(40), BigInteger.valueOf(10)))) {
			return Z_3_9.getTheZ_3_9();
		} else if (this.lessOrEquals(new Fraction(BigInteger.valueOf(9), BigInteger.valueOf(2)))) {
			return Z_4_0.getTheZ_4_0();
		} else if (this.lessOrEquals(new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(1)))) {
			return Z_5_0.getTheZ_5_0();
		} else {
			return NoGrade.getTheNoGrade();
		}
	}
}