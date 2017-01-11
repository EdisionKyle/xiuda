/**
 *  工程名：xiuda
 *  文件名：ServiceProvider.java
 *  包名：com.miles.xiuda.pojo
 *  创建时间：2017年1月10日 下午2:30:06
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 */
package com.miles.xiuda.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *  类名：ServiceProvider
 *  说明：服务商
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2017年1月10日 下午2:32:38
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author pengcheng.tian
 */
public class ServiceProvider implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fwsId;
	private String fwsNo;
	private String fwsName;
	private String fwsShortName;
	private String leibie;
	private String csBianhao;
	private String addr;
	private BigDecimal jingdu;
	private BigDecimal weidu;
	private String logo;
	private Byte status;

	public Long getFwsId() {
		return fwsId;
	}

	public void setFwsId(Long fwsId) {
		this.fwsId = fwsId;
	}

	public String getFwsNo() {
		return fwsNo;
	}

	public void setFwsNo(String fwsNo) {
		this.fwsNo = fwsNo;
	}

	public String getFwsName() {
		return fwsName;
	}

	public void setFwsName(String fwsName) {
		this.fwsName = fwsName;
	}

	public String getFwsShortName() {
		return fwsShortName;
	}

	public void setFwsShortName(String fwsShortName) {
		this.fwsShortName = fwsShortName;
	}

	public String getLeibie() {
		return leibie;
	}

	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}

	public String getCsBianhao() {
		return csBianhao;
	}

	public void setCsBianhao(String csBianhao) {
		this.csBianhao = csBianhao;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public BigDecimal getJingdu() {
		return jingdu;
	}

	public void setJingdu(BigDecimal jingdu) {
		this.jingdu = jingdu;
	}

	public BigDecimal getWeidu() {
		return weidu;
	}

	public void setWeidu(BigDecimal weidu) {
		this.weidu = weidu;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}
