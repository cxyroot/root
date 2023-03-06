package org.langyue.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.mapper.CustomerEntityMapper;
import com.google.mapper.SurveyAnswerMapper;
import com.google.entity.CustomerEntity;
import com.google.entity.SurveyAnswerEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MybatisTest {

	private static SqlSessionFactory sqlSessionFactory;

	@Before
	public void initSF() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test(){
		List<CustomerEntity> customerEntities = getCustomerEntities("2022-02-26");
		System.out.println("========================start===============================");
		for (CustomerEntity customerEntity : customerEntities) {
			String customersId = customerEntity.getId();
			System.out.println("========================customersId:" + customersId);
			List<SurveyAnswerEntity> list = new ArrayList<SurveyAnswerEntity>();
			SurveyAnswerEntity newSurveyAnswerEntity2 = getNewSurveyAnswerEntity(customersId, "2", "10",
					"会根据玩具的玩法正确玩玩具或做游戏吗？");
			list.add(newSurveyAnswerEntity2);
			SurveyAnswerEntity newSurveyAnswerEntity3 = getNewSurveyAnswerEntity(customersId, "3", "11",
					"儿童能认识汉字和数字吗？");
			list.add(newSurveyAnswerEntity3);
			SurveyAnswerEntity newSurveyAnswerEntity4 = getNewSurveyAnswerEntity(customersId, "4", "12",
					"能指认汉字、数字吗？会用笔吗？");
			list.add(newSurveyAnswerEntity4);
			SurveyAnswerEntity newSurveyAnswerEntity5 = getNewSurveyAnswerEntity(customersId, "5", "13",
					"大小便有表示吗？能否自理？");
			list.add(newSurveyAnswerEntity5);
			SurveyAnswerEntity newSurveyAnswerEntity6 = getNewSurveyAnswerEntity(customersId, "6", "15",
					"是否有食物或药物过敏？");
			list.add(newSurveyAnswerEntity6);
			SurveyAnswerEntity newSurveyAnswerEntity7 = getNewSurveyAnswerEntity(customersId, "7", "17",
					"身体大动作发育情况？");
			list.add(newSurveyAnswerEntity7);
			SurveyAnswerEntity newSurveyAnswerEntity8 = getNewSurveyAnswerEntity(customersId, "8", "2", "有没有语言？");
			list.add(newSurveyAnswerEntity8);
			SurveyAnswerEntity newSurveyAnswerEntity9 = getNewSurveyAnswerEntity(customersId, "9", "3",
					"如果还没有语言，儿童能模仿发音吗？");
			list.add(newSurveyAnswerEntity9);
			SurveyAnswerEntity newSurveyAnswerEntity10 = getNewSurveyAnswerEntity(customersId, "10", "4",
					"能否听懂简单指令？");
			list.add(newSurveyAnswerEntity10);
			SurveyAnswerEntity newSurveyAnswerEntity11 = getNewSurveyAnswerEntity(customersId, "11", "5",
					"能说出常见物品的名称吗？");
			list.add(newSurveyAnswerEntity11);
			SurveyAnswerEntity newSurveyAnswerEntity12 = getNewSurveyAnswerEntity(customersId, "12", "6",
					"对别人叫自己名字是否有回应？");
			list.add(newSurveyAnswerEntity12);
			SurveyAnswerEntity newSurveyAnswerEntity13 = getNewSurveyAnswerEntity(customersId, "13", "7",
					"能主动提要求吗？");
			list.add(newSurveyAnswerEntity13);
			SurveyAnswerEntity newSurveyAnswerEntity14 = getNewSurveyAnswerEntity(customersId, "14", "8",
					"是否对其他小朋友感兴趣？");
			list.add(newSurveyAnswerEntity14);
			SurveyAnswerEntity newSurveyAnswerEntity15 = getNewSurveyAnswerEntity(customersId, "15", "9",
					"是否有目光对视？");
			list.add(newSurveyAnswerEntity15);
			SurveyAnswerEntity newSurveyAnswerEntity16 = getNewSurveyAnswerEntity(customersId, "16", "14",
					"是否有癫痫？");
			list.add(newSurveyAnswerEntity16);
			SurveyAnswerEntity newSurveyAnswerEntity17 = getNewSurveyAnswerEntity(customersId, "17", "16",
					"是否有习惯性脱臼？");
			list.add(newSurveyAnswerEntity17);
			updateSurveyAnswer(customersId);
			for (SurveyAnswerEntity surveyAnswerEntity : list) {
				System.out.println("========================surveyAnswerMapper.insert==============================="
						+ customersId);
				String questionTitle = surveyAnswerEntity.getQuestionTitle();
				if (questionTitle != null && !"".equals(questionTitle)) {
					insert(surveyAnswerEntity);
				}
			}
		}
		System.out.println("========================end===============================");
	}

	private void insert(SurveyAnswerEntity surveyAnswerEntity) {

	}

	private void updateSurveyAnswer(String customersId) {

	}

	private SurveyAnswerEntity getNewSurveyAnswerEntity(String customersId, String oldQuestionId, String newQuestionId,
														String questionTitle) {
		List<SurveyAnswerEntity> oldSurveyAnswerEntity = getOldSurveyAnswerEntity(customersId, oldQuestionId);
		SurveyAnswerEntity surveyAnswerEntity = new SurveyAnswerEntity();
		if (oldSurveyAnswerEntity != null && !"".equals(oldSurveyAnswerEntity) && oldSurveyAnswerEntity.size() > 0) {
			surveyAnswerEntity.setCustomersId(customersId);
			surveyAnswerEntity.setQuestionId(newQuestionId);
			surveyAnswerEntity.setQuestionTitle(questionTitle);
			surveyAnswerEntity.setAnswer(oldSurveyAnswerEntity.get(0).getAnswer());
		}
		return surveyAnswerEntity;
	}
	private static List<SurveyAnswerEntity> getOldSurveyAnswerEntity(String customersId, String oldQuestionId) {
		List<CustomerEntity>  list = new ArrayList<CustomerEntity> ();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			SurveyAnswerMapper customerEntityMapper = sqlSession.getMapper(SurveyAnswerMapper.class);
			return customerEntityMapper.selectCustomerEntitys(customersId,oldQuestionId);
		} finally {
			sqlSession.close();
		}
	}

	private List<CustomerEntity> getCustomerEntities(String date) {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			CustomerEntityMapper customerEntityMapper = sqlSession.getMapper(CustomerEntityMapper.class);
			return customerEntityMapper.selectList();
		} finally {
			sqlSession.close();
		}
	}


}
