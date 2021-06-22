package com.demo.app.resource;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private int id;

	private String from;

	private String to;

	private int conversionRate;

	private BigDecimal convertedAmount;

	private int port;

	public CurrencyConversionBean() {
		// TODO Auto-generated constructor stub
	}

	public CurrencyConversionBean(int id, String from, String to, int conversionRate, BigDecimal convertedAmount,
			int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
		this.convertedAmount = convertedAmount;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(int conversionRate) {
		this.conversionRate = conversionRate;
	}

	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
