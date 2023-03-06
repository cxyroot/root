package kafka;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.entity.CustomerEntity;
import com.google.entity.SurveyAnswerEntity;

public class Demo {
	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;

	public static void main(String[] args) {
		List<CustomerEntity> customerEntities = getCustomerEntities("2022-02-26");
		System.out.println("========================start===============================");
		for (CustomerEntity customerEntity : customerEntities) {
			String customersId = customerEntity.getId();
			System.out.println("========================customersId:" + customersId);
			List<SurveyAnswerEntity> list = new ArrayList<SurveyAnswerEntity>();
			SurveyAnswerEntity newSurveyAnswerEntity2 = getNewSurveyAnswerEntity(customersId, "2", "10",
					"�������ߵ��淨��ȷ����߻�����Ϸ��");
			list.add(newSurveyAnswerEntity2);
			SurveyAnswerEntity newSurveyAnswerEntity3 = getNewSurveyAnswerEntity(customersId, "3", "11",
					"��ͯ����ʶ���ֺ�������");
			list.add(newSurveyAnswerEntity3);
			SurveyAnswerEntity newSurveyAnswerEntity4 = getNewSurveyAnswerEntity(customersId, "4", "12",
					"��ָ�Ϻ��֡������𣿻��ñ���");
			list.add(newSurveyAnswerEntity4);
			SurveyAnswerEntity newSurveyAnswerEntity5 = getNewSurveyAnswerEntity(customersId, "5", "13",
					"��С���б�ʾ���ܷ�����");
			list.add(newSurveyAnswerEntity5);
			SurveyAnswerEntity newSurveyAnswerEntity6 = getNewSurveyAnswerEntity(customersId, "6", "15",
					"�Ƿ���ʳ���ҩ�������");
			list.add(newSurveyAnswerEntity6);
			SurveyAnswerEntity newSurveyAnswerEntity7 = getNewSurveyAnswerEntity(customersId, "7", "17",
					"����������������");
			list.add(newSurveyAnswerEntity7);
			SurveyAnswerEntity newSurveyAnswerEntity8 = getNewSurveyAnswerEntity(customersId, "8", "2", "��û�����ԣ�");
			list.add(newSurveyAnswerEntity8);
			SurveyAnswerEntity newSurveyAnswerEntity9 = getNewSurveyAnswerEntity(customersId, "9", "3",
					"�����û�����ԣ���ͯ��ģ�·�����");
			list.add(newSurveyAnswerEntity9);
			SurveyAnswerEntity newSurveyAnswerEntity10 = getNewSurveyAnswerEntity(customersId, "10", "4",
					"�ܷ�������ָ�");
			list.add(newSurveyAnswerEntity10);
			SurveyAnswerEntity newSurveyAnswerEntity11 = getNewSurveyAnswerEntity(customersId, "11", "5",
					"��˵��������Ʒ��������");
			list.add(newSurveyAnswerEntity11);
			SurveyAnswerEntity newSurveyAnswerEntity12 = getNewSurveyAnswerEntity(customersId, "12", "6",
					"�Ա��˽��Լ������Ƿ��л�Ӧ��");
			list.add(newSurveyAnswerEntity12);
			SurveyAnswerEntity newSurveyAnswerEntity13 = getNewSurveyAnswerEntity(customersId, "13", "7",
					"��������Ҫ����");
			list.add(newSurveyAnswerEntity13);
			SurveyAnswerEntity newSurveyAnswerEntity14 = getNewSurveyAnswerEntity(customersId, "14", "8",
					"�Ƿ������С���Ѹ���Ȥ��");
			list.add(newSurveyAnswerEntity14);
			SurveyAnswerEntity newSurveyAnswerEntity15 = getNewSurveyAnswerEntity(customersId, "15", "9",
					"�Ƿ���Ŀ����ӣ�");
			list.add(newSurveyAnswerEntity15);
			SurveyAnswerEntity newSurveyAnswerEntity16 = getNewSurveyAnswerEntity(customersId, "16", "14",
					"�Ƿ�����");
			list.add(newSurveyAnswerEntity16);
			SurveyAnswerEntity newSurveyAnswerEntity17 = getNewSurveyAnswerEntity(customersId, "17", "16",
					"�Ƿ���ϰ�����Ѿʣ�");
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

	private static List<CustomerEntity> getCustomerEntities(String string) {

		List<CustomerEntity>  list = new ArrayList<CustomerEntity> ();
		sql = "select id from t_customer";// SQL���
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
			while (ret.next()) {
				CustomerEntity customerEntity = new CustomerEntity();
				String id = ret.getString(1);
				customerEntity.setId(id);
				list.add(customerEntity);
			} // ��ʾ����
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private static void insert(SurveyAnswerEntity surveyAnswerEntity) {
		//String sql = null;
		//DBHelper db1 = null;
		//ResultSet ret = null;
		List<CustomerEntity>  list = new ArrayList<CustomerEntity> ();
		sql = "INSERT INTO t_survey_answer (\n" +
				"\tquestion_id,\n" +
				"\tcustomers_id,\n" +
				"\tquestion_Title,\n" +
				"\tanswer,\n" +
				"\tcreate_User_Id,\n" +
				"\tcreate_User_Name,\n" +
				"\tcreate_Time,\n" +
				"\tupdate_User_Id,\n" +
				"\tupdate_User_Name,\n" +
				"\tupdate_Time,\n" +
				"\tdel_flag\n" +
				")\n" +
				"VALUE\n" +
				"\t(\n" +
				"\t\t'"+surveyAnswerEntity.getQuestionId()+"',\n" +
				"\t\t'"+surveyAnswerEntity.getCustomersId()+"',\n" +
				"\t\t'"+surveyAnswerEntity.getQuestionTitle()+"',\n" +
				"\t\t'"+surveyAnswerEntity.getAnswer()+"',\n" +
				"\t\t'"+"1"+"',\n" +
				"\t\t'"+"ϵͳ����Ա"+"',\n" +
				"\t\t'"+LocalDateTime.now()+"',\n" +
				"\t\t'"+"1"+"',\n" +
				"\t\t'"+"ϵͳ����Ա"+"',\n" +
				"\t\t'"+LocalDateTime.now()+"',\n" +
				"\t\t'"+"0"+"'\n" +
				"\n" +
				"\t)";// SQL���
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			int i = db1.pst.executeUpdate(sql);// ִ����䣬�õ������
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void updateSurveyAnswer(String customersId) {
		//String sql = null;
		//DBHelper db1 = null;
		sql = "update t_survey_answer set del_flag = '1' where customers_id = '"+customersId+"' ";// SQL���
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			int i  = db1.pst.executeUpdate();// ִ����䣬�õ������
			System.out.println(i);
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static SurveyAnswerEntity getNewSurveyAnswerEntity(String customersId, String oldQuestionId, String newQuestionId,
			String questionTitle) {

		// LambdaQueryWrapper<SurveyAnswerEntity> surveyAnswerEntityLambdaQueryWrapper =
		// new LambdaQueryWrapper<>();
		// surveyAnswerEntityLambdaQueryWrapper.eq(SurveyAnswerEntity::getCustomersId,customersId);
		// surveyAnswerEntityLambdaQueryWrapper.eq(SurveyAnswerEntity::getQuestionId,oldQuestionId);
		// List<SurveyAnswerEntity> oldSurveyAnswerEntity =
		// surveyAnswerMapper.selectList(surveyAnswerEntityLambdaQueryWrapper);

		List<SurveyAnswerEntity> oldSurveyAnswerEntity = getOldSurveyAnswerEntity(customersId, oldQuestionId);
		SurveyAnswerEntity surveyAnswerEntity = new SurveyAnswerEntity();
		if (oldSurveyAnswerEntity != null && !"".equals(oldSurveyAnswerEntity) && oldSurveyAnswerEntity.size() > 0) {
			surveyAnswerEntity.setCustomersId(customersId);
			surveyAnswerEntity.setQuestionId(newQuestionId);
			surveyAnswerEntity.setQuestionTitle(questionTitle);
			surveyAnswerEntity.setAnswer(oldSurveyAnswerEntity.get(0).getAnswer());

			/*surveyAnswerEntity.setCreateUserId(surveyAnswerEntity.getCreateUserId());
			surveyAnswerEntity.setCreateUserName(surveyAnswerEntity.getCreateUserName());
			surveyAnswerEntity.setUpdateUserId(surveyAnswerEntity.getUpdateUserId());
			surveyAnswerEntity.setUpdateUserName(surveyAnswerEntity.getUpdateUserName());
			surveyAnswerEntity.setCreateTime(surveyAnswerEntity.getCreateTime());
			surveyAnswerEntity.setUpdateTime(surveyAnswerEntity.getUpdateTime());*/
			surveyAnswerEntity.setDelFlag(Boolean.FALSE);
		}
		return surveyAnswerEntity;
	}

	private static List<SurveyAnswerEntity> getOldSurveyAnswerEntity(String customersId, String oldQuestionId) {
		//String sql = null;
		//DBHelper db1 = null;
		//ResultSet ret = null;
		List<SurveyAnswerEntity>  list = new ArrayList<SurveyAnswerEntity> ();
		sql = "SELECT\n" +
		"\tr.id,\n" +
				"\tr.question_id,\n" +
				"\tr.customers_id,\n" +
				"\tr.question_Title,\n" +
				"\tr.answer,\n" +
				"\tr.create_User_Id,\n" +
				"\tr.create_User_Name,\n" +
				"\tr.create_Time,\n" +
				"\tr.update_User_Id,\n" +
				"\tr.update_User_Name,\n" +
				"\tr.update_Time,\n" +
				"\tr.del_Flag\n" +
				"FROM\n" +
				"\tt_Survey_Answer r\n" +
				"WHERE\n" +
				"\tr.question_Id = '"+oldQuestionId+"'\n" +
				"AND r.customers_Id = '"+customersId+"'\n";// SQL���
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
			while (ret.next()) {
				SurveyAnswerEntity customerEntity = new SurveyAnswerEntity();
				String id = ret.getString(1);
				String questionId = ret.getString(2);
				String customersDBId = ret.getString(3);
				String questionTitle = ret.getString(4);
				String answer = ret.getString(5);
				String createUserId = ret.getString(6);
				String createUserName = ret.getString(7);
				Date createTime = ret.getDate(8);
				String updateUserId = ret.getString(9);
				String updateUserName = ret.getString(10);
				Date updateTime = ret.getDate(11);
				Boolean delFlag = ret.getBoolean(12);
				customerEntity.setId(id);
				customerEntity.setQuestionId(questionId);
				customerEntity.setCustomersId(customersDBId);
				customerEntity.setQuestionTitle(questionTitle);
				customerEntity.setAnswer(answer);
				customerEntity.setCreateUserId(createUserId);
				customerEntity.setCreateUserName(createUserName);
				//customerEntity.setCreateTime(LocalDateTime.ofInstant(createTime.toInstant(), ZoneId.systemDefault()));
				customerEntity.setUpdateUserId(updateUserId);
				customerEntity.setUpdateUserName(updateUserName);
				//customerEntity.setUpdateTime(LocalDateTime.ofInstant(updateTime.toInstant(), ZoneId.systemDefault()));
				customerEntity.setDelFlag(delFlag);
				list.add(customerEntity);
			} // ��ʾ����
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
