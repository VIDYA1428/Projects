package com.example.Inversion_Control;

public class Iphone implements Mobiles {
	
	
	
	Iphone(color colorobj)
	{
		this.color = colorobj;
	}
	
	
	
	
	color color;

	@Override
	public void getModelandColor() {
		// TODO Auto-generated method stub
		System.out.println("Iphone Model");
		color.getIphoneColor();
	}

}
