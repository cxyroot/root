package com.google.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerEntity {

	private String id;

	private String schoolId;// ����У��

	private String schoolName;

	private String studentName;// ��ͯ����

	private Boolean gender;// �Ա�

	private String consultChannel;// ��ѯ;��

	private String consultMode;// ��ѯ��ʽ

	private LocalDate birthday;// ��������

	private String knownChannel;// ��֪;��

	private String phone;// ��ϵ��ʽ

	private String intentionLevel;// ����ǿ��

	private String parentName;// ��������

	private String provinceCode; // ʡCode

	private String provinceName; // ʡ����

	private String cityCode; // ��Code

	private String cityName; // ������

	private String countyCode; // ��/��Code

	private String countyName; // ��/������

	private String hospitalDiagnosis; // ҽԺ���

	private String ability;// �����̶�

	private Boolean isTrain;// �Ƿ�μӹ�ѵ��

	private String organizationName;// ��������

	private LocalDate latestContactTime;// ������ϵʱ��

	private String reason;// ����/ԭ��

	private String responsiblePerson;// ������

	private Boolean isPublicSea; // �Ƿ��ڹ��� 1 �� 0��

	private LocalDate consultTime;// ��ѯʱ��

	private String stage;// �����׶�

	private String consultState;// ��ѯ״̬

	private String homeAddress; // ��ͥסַ

	protected String createUserId; // 创建人ID

	protected String createUserName; // 创建人姓�?

	protected LocalDateTime createTime; // 创建时间

	protected String updateUserId; // 更新人ID

	protected String updateUserName; // 更新人姓�?

	protected LocalDateTime updateTime; // 更新时间

	private Boolean delFlag; // 逻辑删除，true标识已删�?

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
