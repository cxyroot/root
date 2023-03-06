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

	private static List<CustomerEntity> getCustomerEntities(String string) {

		List<CustomerEntity>  list = new ArrayList<CustomerEntity> ();
		sql = "select id from t_customer";// SQL语句
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				CustomerEntity customerEntity = new CustomerEntity();
				String id = ret.getString(1);
				customerEntity.setId(id);
				list.add(customerEntity);
			} // 显示数据
			ret.close();
			db1.close();// 关闭连接
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
				"\t\t'"+"系统管理员"+"',\n" +
				"\t\t'"+LocalDateTime.now()+"',\n" +
				"\t\t'"+"1"+"',\n" +
				"\t\t'"+"系统管理员"+"',\n" +
				"\t\t'"+LocalDateTime.now()+"',\n" +
				"\t\t'"+"0"+"'\n" +
				"\n" +
				"\t)";// SQL语句
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			int i = db1.pst.executeUpdate(sql);// 执行语句，得到结果集
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void updateSurveyAnswer(String customersId) {
		//String sql = null;
		//DBHelper db1 = null;
		sql = "update t_survey_answer set del_flag = '1' where customers_id = '"+customersId+"' ";// SQL语句
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			int i  = db1.pst.executeUpdate();// 执行语句，得到结果集
			System.out.println(i);
			db1.close();// 关闭连接
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
				"AND r.customers_Id = '"+customersId+"'\n";// SQL语句
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
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
			} // 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
