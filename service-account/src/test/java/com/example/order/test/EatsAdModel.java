package com.example.order.test;


import java.util.List;

public class EatsAdModel {

	private	String	issuerId	;//	发行服务机构Id，说明记账文件是哪一个发行服务机构产生的
	private	String	operatorId	;//	ETC拓展服务清分方ID，指明当前记账文件针对的是哪一个ETC拓展服务清分方
	private	Integer	serviceType	;//	拓展应用类型
	private	Long	messageId	;//	表示是针对哪一个ETC拓展服务清分方的原始交易文件。
	private	String	receiveTime	;//	部联网中心记账交易接收时间
	private	String	processTime	;//	记账时间
	private	Integer	count	;//	本记账文件对应原始交易文件的交易记录数量
	private	Integer	accountCount	;//	确认记账总记录数量
	private	Long	accountAmount	;//	确认记账总金额
	private	Integer	disputedCount	;//	本记账文件包含的争议交易数量
	private List<EatsDisputedRecord> disputedRecord;// 争议交易明细

	public String getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getProcessTime() {
		return processTime;
	}

	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getAccountCount() {
		return accountCount;
	}

	public void setAccountCount(Integer accountCount) {
		this.accountCount = accountCount;
	}

	public Long getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(Long accountAmount) {
		this.accountAmount = accountAmount;
	}

	public Integer getDisputedCount() {
		return disputedCount;
	}

	public void setDisputedCount(Integer disputedCount) {
		this.disputedCount = disputedCount;
	}

	public List<EatsDisputedRecord> getDisputedRecord() {
		return disputedRecord;
	}

	public void setDisputedRecord(List<EatsDisputedRecord> disputedRecord) {
		this.disputedRecord = disputedRecord;
	}

	public EatsAdModel() {
	}
}
