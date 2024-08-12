package com.example.Inversion_Control;

public class OnePlus implements Mobiles {
	
	OnePlus()
	{
		System.out.println("OnePlus constructor triggered");
	}
	
	OnePlus(color colorobj)
	{
		this.color = colorobj;
	}
	
	
	
	
	color color;

	@Override
	public void getModelandColor() {
		// TODO Auto-generated method stub
		System.out.println("One Plus Model");
		color.getOnePlusColor();

	}

}
