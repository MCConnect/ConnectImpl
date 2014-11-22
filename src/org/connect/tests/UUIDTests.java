package org.connect.tests;

import org.connect.impl.Util;

public class UUIDTests {

	public static void main(String[] args) {
		new UUIDTests();
	}

	private UUIDTests() {
		runTests();
	}

	private void runTests() {
		Util.getUUID("dentmaged");
	}

}
