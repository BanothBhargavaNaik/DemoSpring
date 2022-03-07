package com.example.demo.entity;

public class AppError {
	
	private Integer errocode;
	
	public Integer getErrocode() {
		return errocode;
	}

	public void setErrocode(Integer errocode) {
		this.errocode = errocode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	private String description;
	
	private Throwable exception;

	@Override
	public String toString() {
		return "Error [errocode=" + errocode + ", description=" + description + ", exception=" + exception + "]";
	}

}
