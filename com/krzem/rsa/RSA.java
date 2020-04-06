package com.krzem.rsa;



import java.math.BigInteger;
import java.security.SecureRandom;



public class RSA{
	private static SecureRandom _sr=new SecureRandom();



	public static String[] generate_keypair(int sz){
		BigInteger p=new BigInteger(sz,15,RSA._sr);
		BigInteger q=new BigInteger(sz,15,RSA._sr);
		BigInteger n=p.multiply(q);
		BigInteger phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		BigInteger e=BigInteger.valueOf(65537);
		// while (e==null||e.compareTo(phi)!=1||e.gcd(phi).compareTo(BigInteger.ONE)!=0){
		// 	e=new BigInteger(2*sz,RSA._sr);
		// }
		return new String[]{n.toString(),e.toString(),e.modInverse(phi).toString()};
	}



	public static String encrypt(String txt,String k,String n){
		return new BigInteger(txt.getBytes()).modPow(new BigInteger(k),new BigInteger(n)).toString();
	}



	public static String decrypt(String txt,String k,String n){
		return new String(new BigInteger(txt).modPow(new BigInteger(k),new BigInteger(n)).toByteArray());
	}
}