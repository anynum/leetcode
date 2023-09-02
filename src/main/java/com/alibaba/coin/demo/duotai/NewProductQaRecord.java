/*
 * Copyright 2017 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.coin.demo.duotai;


import java.util.List;

/**
 * @author helang.wcy
 * @date 2020年10月24日
 */
public class NewProductQaRecord extends OpensearchRecord {

	/**
	 * 问句;隔开
	 */
	String questions;

	/**
	 * 答案
	 */
	String answers;

	/**
	 *	产品key
	 */
	String productKey;

	/**
	 * 产品模式
	 */
	String productMode;

	/**
	 * 业务id
	 */
	String bizId;

	/**
	 * 业务标识
	 */
	String bizLabel;

	/**
	 *	生效时间
	 */
	String start_time;

	/**
	 *	截止时间
	 */
	String end_time;

	/**
	 * 直达技能Id，自定义问答为-1的
	 */
	String skillId;

	/**
	 * 自定义问答模式
	 */
	String qaType;

	/**
	 * 状态 1： 上线， 2：下线
	 */
	String status;

	/**
	 * productKeyModel 列表
	 */
	List<String> productKeyModes;

	/**
	 * mainProductKeyModel 列表
	 */
	List<String> mainProductKeyModes;

    /**
     * deviceTypeMode 列表
     */
    List<String> deviceTypeModes;


    /**
     * 去除的productKeyMode
     */
    List<String> excludeProductKeyModes;

	public List<String> getDeviceTypeModes() {
		return deviceTypeModes;
	}

	public void setDeviceTypeModes(List<String> deviceTypeModes) {
		this.deviceTypeModes = deviceTypeModes;
	}

	public List<String> getExcludeProductKeyModes() {
		return excludeProductKeyModes;
	}

	public void setExcludeProductKeyModes(List<String> excludeProductKeyModes) {
		this.excludeProductKeyModes = excludeProductKeyModes;
	}

	public List<String> getMainProductKeyModes() {
		return mainProductKeyModes;
	}

	public void setMainProductKeyModes(List<String> mainProductKeyModes) {
		this.mainProductKeyModes = mainProductKeyModes;
	}

	public NewProductQaRecord(String bizLabel, String bizId){
		super(0L);
		this.bizLabel = bizLabel;
		this.bizId = bizId;
	}

	public NewProductQaRecord(Long id, String questions){
		super(id);
		this.questions = questions;
	}

	public NewProductQaRecord(Long id, String questions, String answers){
		super(id);
		this.questions = questions;
		this.answers = answers;
	}

	public NewProductQaRecord(Long id, String questions, String answers, String skillId){
		super(id);
		this.questions = questions;
		this.answers = answers;
		this.skillId = skillId;
	}

	public NewProductQaRecord(Long id, String questions, String answers, String skillId, String qaType){
		super(id);
		this.questions = questions;
		this.answers = answers;
		this.skillId = skillId;
		this.qaType = qaType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getProductKeyModes() {
		return productKeyModes;
	}

	public void setProductKeyModes(List<String> productKeyModes) {
		this.productKeyModes = productKeyModes;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getProductMode() {
		return productMode;
	}

	public void setProductMode(String productMode) {
		this.productMode = productMode;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizLabel() {
		return bizLabel;
	}

	public void setBizLabel(String bizLabel) {
		this.bizLabel = bizLabel;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String getQaType() {
		return qaType;
	}

	public void setQaType(String qaType) {
		this.qaType = qaType;
	}

	@Override
	public String toString() {
		return "NewProductQaRecord{" +
				"questions='" + questions + '\'' +
				", answers='" + answers + '\'' +
				", productKey='" + productKey + '\'' +
				", productMode='" + productMode + '\'' +
				", bizId='" + bizId + '\'' +
				", bizLabel='" + bizLabel + '\'' +
				", start_time='" + start_time + '\'' +
				", end_time='" + end_time + '\'' +
				", skillId='" + skillId + '\'' +
				", qaType='" + qaType + '\'' +
				", status='" + status + '\'' +
				", productKeyModes=" + productKeyModes +
				", mainProductKeyModes=" + mainProductKeyModes +
				", id='" + id + '\'' +
				'}';
	}
}
