package com.google.mapper;

import com.google.entity.SurveyAnswerEntity;

import java.util.List;

public interface SurveyAnswerMapper {

    List<SurveyAnswerEntity> selectCustomerEntitys(String customersId, String oldQuestionId);
}
