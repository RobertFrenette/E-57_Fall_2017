package edu.hes.e57.demo;

public class ErrorBean {
	public void errorProneMethod() throws Exception {
		throw new Exception("Foo");
	}

	public void otherErrorProneMethod() throws IllegalArgumentException {
		throw new IllegalArgumentException("Bar");
	}
}
