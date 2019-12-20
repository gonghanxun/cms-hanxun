package com.gonghanxun.cms.common;

/**
 * 
 * @author hanxun
 *
 */
public class FileResult {
	
	public FileResult(int error, String url) {
		super();
		this.error = error;
		this.url = url;
	}
	
	int error=0;
	String url="";
	
	
	
	@Override
	public String toString() {
		return "FileResult [error=" + error + ", url=" + url + "]";
	}

	public FileResult() {
		super();
	}
	
	public int getError() {
		return error;
	}
	
	public void setError(int error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}

