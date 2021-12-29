package com.qa.hubspot.tests;

import java.util.Random;

import com.github.javafaker.Faker;

public class TestTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		Faker faker = new Faker();
		String email = "av1987@gmail.com";
		System.out.println(email.substring(0,email.indexOf("@")) + random.nextInt(999999) + email.substring(email.length()-10));
		
		//System.out.println(email.substring(email.length()-10));
		
		
		//System.out.println(random.nextInt(999999));
		
		String[] s = {"your", "array", "of", "strings"};

		Random ran = new Random();
		String s_ran = s[ran.nextInt(s.length)];
		
		System.out.println(s_ran);
		
		System.out.println(faker.phoneNumber().cellPhone());

	}

}
