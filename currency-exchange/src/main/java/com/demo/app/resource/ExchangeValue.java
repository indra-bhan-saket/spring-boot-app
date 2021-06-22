package com.demo.app.resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {

	@Id
	private int id;
	
	@Column(name = "from_currency")
	private String from;
	
	@Column(name = "to_currency")
	private String to;
	
	private int conversionRate;
	
	private int port;

	public ExchangeValue() {
	}

	public ExchangeValue(int id, String from, String to, int conversionRate, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
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

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
