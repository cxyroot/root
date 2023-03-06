package com.google.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerEntity {

	private String id;

	private String schoolId;// 所属校区

	private String schoolName;

	private String studentName;// 儿童姓名

	private Boolean gender;// 性别

	private String consultChannel;// 咨询途径

	private String consultMode;// 咨询方式

	private LocalDate birthday;// 出生日期

	private String knownChannel;// 获知途径

	private String phone;// 联系方式

	private String intentionLevel;// 意向强度

	private String parentName;// 父亲名字

	private String provinceCode; // 省Code

	private String provinceName; // 省名称

	private String cityCode; // 市Code

	private String cityName; // 市名称

	private String countyCode; // 区/县Code

	private String countyName; // 区/县名称

	private String hospitalDiagnosis; // 医院诊断

	private String ability;// 能力程度

	private Boolean isTrain;// 是否参加过训练

	private String organizationName;// 机构名称

	private LocalDate latestContactTime;// 最新联系时间

	private String reason;// 内容/原因

	private String responsiblePerson;// 负责人

	private Boolean isPublicSea; // 是否在公海 1 是 0否

	private LocalDate consultTime;// 咨询时间

	private String stage;// 所属阶段

	private String consultState;// 咨询状态

	private String homeAddress; // 家庭住址

	protected String createUserId; // 鍒涘缓浜篒D

	protected String createUserName; // 鍒涘缓浜哄鍚?

	protected LocalDateTime createTime; // 鍒涘缓鏃堕棿

	protected String updateUserId; // 鏇存柊浜篒D

	protected String updateUserName; // 鏇存柊浜哄鍚?

	protected LocalDateTime updateTime; // 鏇存柊鏃堕棿

	private Boolean delFlag; // 閫昏緫鍒犻櫎锛宼rue鏍囪瘑宸插垹闄?

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getConsultChannel() {
		return consultChannel;
	}

	public void setConsultChannel(String consultChannel) {
		this.consultChannel = consultChannel;
	}

	public String getConsultMode() {
		return consultMode;
	}

	public void setConsultMode(String consultMode) {
		this.consultMode = consultMode;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getKnownChannel() {
		return knownChannel;
	}

	public void setKnownChannel(String knownChannel) {
		this.knownChannel = knownChannel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntentionLevel() {
		return intentionLevel;
	}

	public void setIntentionLevel(String intentionLevel) {
		this.intentionLevel = intentionLevel;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getHospitalDiagnosis() {
		return hospitalDiagnosis;
	}

	public void setHospitalDiagnosis(String hospitalDiagnosis) {
		this.hospitalDiagnosis = hospitalDiagnosis;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public Boolean getIsTrain() {
		return isTrain;
	}

	public void setIsTrain(Boolean isTrain) {
		this.isTrain = isTrain;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public LocalDate getLatestContactTime() {
		return latestContactTime;
	}

	public void setLatestContactTime(LocalDate latestContactTime) {
		this.latestContactTime = latestContactTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public Boolean getIsPublicSea() {
		return isPublicSea;
	}

	public void setIsPublicSea(Boolean isPublicSea) {
		this.isPublicSea = isPublicSea;
	}

	public LocalDate getConsultTime() {
		return consultTime;
	}

	public void setConsultTime(LocalDate consultTime) {
		this.consultTime = consultTime;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getConsultState() {
		return consultState;
	}

	public void setConsultState(String consultState) {
		this.consultState = consultState;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
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
