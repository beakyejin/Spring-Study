package com.spring.view.controller;

//controller가 리턴한 view경로와 파일명 완성
public class ViewResolver {
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		System.out.println("getView: "+(prefix + viewName + suffix));
		return prefix + viewName + suffix;
	}
}
