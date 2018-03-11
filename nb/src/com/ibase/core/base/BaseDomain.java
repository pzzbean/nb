package com.ibase.core.base;

import java.io.Serializable;

import com.gg.yp.bean.PaginationBean;

public class BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8514179969555440981L;
	
	private PaginationBean page = new PaginationBean(0,1,10);

	public PaginationBean getPage() {
		return page;
	}

	public void setPage(PaginationBean page) {
		this.page = page;
	}
	


}
