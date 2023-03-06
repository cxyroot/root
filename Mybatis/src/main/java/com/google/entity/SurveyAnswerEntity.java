package com.google.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class SurveyAnswerEntity {

    
    private String id;

    
    private String questionId;//问题Id

    
    private String customersId;//客户id

    
    private String questionTitle;//问题

    
    private String answer; //答案
    
    protected String createUserId;      //创建人ID

    protected String createUserName;    //创建人姓�?

    protected LocalDateTime createTime; //创建时间

    protected String updateUserId;      //更新人ID

    protected String updateUserName;    //更新人姓�?

    protected LocalDateTime updateTime; //更新时间

    private Boolean delFlag;            //逻辑删除，true标识已删�?

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getCustomersId() {
		return customersId;
	}

	public void setCustomersId(String customersId) {
		this.customersId = customersId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}
