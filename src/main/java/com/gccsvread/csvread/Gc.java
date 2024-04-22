package com.gccsvread.csvread;

import java.io.Serializable;

public class Gc implements Serializable {

	private static final long serialVersionUID = -1942824210136227855L;
	private String region;
	private String caseNumber;
	private String caseNumberFull;
	private String consulate;
	private String status;
	private String submitDate;
	private String statusDate;
	private String issued;
	private String ap;
	private String ready;
	private String refused;
	private String refused221g;
	private String inTransit;
	private String transfer;
	private String nvc;
	private String twoNlDate;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getCaseNumberFull() {
		return caseNumberFull;
	}

	public void setCaseNumberFull(String caseNumberFull) {
		this.caseNumberFull = caseNumberFull;
	}

	public String getConsulate() {
		return consulate;
	}

	public void setConsulate(String consulate) {
		this.consulate = consulate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getIssued() {
		return issued;
	}

	public void setIssued(String issued) {
		this.issued = issued;
	}

	public String getAp() {
		return ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	public String getReady() {
		return ready;
	}

	public void setReady(String ready) {
		this.ready = ready;
	}

	public String getRefused() {
		return refused;
	}

	public void setRefused(String refused) {
		this.refused = refused;
	}

	public String getRefused221g() {
		return refused221g;
	}

	public void setRefused221g(String refused221g) {
		this.refused221g = refused221g;
	}

	public String getInTransit() {
		return inTransit;
	}

	public void setInTransit(String inTransit) {
		this.inTransit = inTransit;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	public String getNvc() {
		return nvc;
	}

	public void setNvc(String nvc) {
		this.nvc = nvc;
	}

	public String getTwoNlDate() {
		return twoNlDate;
	}

	public void setTwoNlDate(String twoNlDate) {
		this.twoNlDate = twoNlDate;
	}

}
