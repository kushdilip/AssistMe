package com.tavant.db;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.tavant.domain.Contact;
import com.tavant.domain.Transaction;

public interface TransactionMapper {
	final String INSERT = "INSERT INTO TRANSACTIONS (DATE, DESCRIPTION, CONTACT_ID, AMOUNT, USER_ID,CONTACT_NAME) VALUES (#{date}, #{description},#{contactId},#{amount},#{userId},#{contactName})";
//	final String INSERT = "INSERT INTO `assistmedb`.`transactions` (DATE, DESCRIPTION, CONTACT_ID, AMOUNT, USER_ID) VALUES ('2011-12-30', 'shopping',36,230,3)";
	final String SELECT_ALL = "SELECT * FROM TRANSACTIONS WHERE (USER_ID = #{userId} AND IS_DELETED = b'0' )";

	@Insert(INSERT)
	@Options(useGeneratedKeys=true, keyProperty="transaction_id")
	void insert(Transaction transaction);
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="TRANSACTION_ID"),
		@Result(property="date", column="DATE"),
		@Result(property="phoneNumber", column="MOBILE"),
		@Result(property="emailId", column="EMAIL_ID")
	})
	List<Contact> selectAll(int userId);
}
	
