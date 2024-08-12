package com.example.Inversion_Control;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobilesConfig {
	
	@Bean
	public color getColor()
	{
		return new color(); //return color object
	}

	@Bean
	public Mobiles getOnePlusObject(color getColor) //injecting dependency values
	{
		return new OnePlus(getColor);
	}
	
	@Bean
	public Mobiles getIphoneObject(color getColor)
	{
		return new Iphone(getColor);
	}
}
