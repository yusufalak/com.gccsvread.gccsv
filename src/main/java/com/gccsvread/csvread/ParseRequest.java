package com.gccsvread.csvread;

import java.io.Serializable;

public class ParseRequest implements Serializable {

	private static final long serialVersionUID = 2241395162528106193L;

	private String sourceFile;

	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}

}
