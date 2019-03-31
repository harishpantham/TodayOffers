package com.today.offers.utils;

import java.sql.Timestamp;
import java.util.Date;

public class OffersResponse {
	
	private long timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	private Object payLoad;
	
	public OffersResponse() {
		this.timestamp = new Timestamp(new Date().getTime()).getTime();
	}

	public OffersResponse(long timestamp, int status, String error, String message, String path, Object payLoad) {
		super();
		this.timestamp = new Timestamp(new Date().getTime()).getTime();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.payLoad = payLoad;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Object getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(Object payLoad) {
		this.payLoad = payLoad;
	}

	@Override
	public String toString() {
		return "YanResponse [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", path=" + path + ", payLoad=" + payLoad + "]";
	}
	
	

}