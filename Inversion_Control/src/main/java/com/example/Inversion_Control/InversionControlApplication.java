package com.example.Inversion_Control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class InversionControlApplication {

	public static void main(String[] args) {
		
		//Spring Container
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MobilesConfig.class);
		
		
		
		Mobiles obj = context.getBean("getIphoneObject", Mobiles.class);
		obj.getModelandColor();
	}

}
