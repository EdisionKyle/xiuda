package com.miles.xiuda.pojo;

public class City {

	private String bianhao;
	private String chengshi;
	private String shengfen;
	private String quxian;

	public City() {
		super();
	}

	public City(String bianhao, String chengshi, String shengfen, String quxian) {
		super();
		this.bianhao = bianhao;
		this.chengshi = chengshi;
		this.shengfen = shengfen;
		this.quxian = quxian;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getChengshi() {
		return chengshi;
	}

	public void setChengshi(String chengshi) {
		this.chengshi = chengshi;
	}

	public String getShengfen() {
		return shengfen;
	}

	public void setShengfen(String shengfen) {
		this.shengfen = shengfen;
	}

	public String getQuxian() {
		return quxian;
	}

	public void setQuxian(String quxian) {
		this.quxian = quxian;
	}

}
