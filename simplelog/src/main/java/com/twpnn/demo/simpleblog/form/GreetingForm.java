package com.twpnn.demo.simpleblog.form;

import com.twpnn.demo.simpleblog.entity.Color;
import com.twpnn.demo.simpleblog.entity.Greeting;

public class GreetingForm {
	// the domain model persistent data
	private Greeting greeting;

	// the other non persistent data ... used in user interface only
	private Color color;

	public Greeting getGreeting() {
		return greeting;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
