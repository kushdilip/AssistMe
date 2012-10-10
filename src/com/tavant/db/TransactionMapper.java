package com.tavant.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.tavant.domain.Transaction;

public interface TransactionMapper {
	final String INSERT = "INSERT INTO TRANSACTIONS (DATE, DESCRIPTION, CONTACT_ID, AMOUNT, USER_ID,CONTACT_NAME) VALUES (#{date}, #{description},#{contactId},#{amount},#{userId},#{contactName})";
	final String SELECT_ALL = "SELECT * FROM TRANSACTIONS WHERE (USER_ID = #{userId} AND IS_DELETED = b'0' )";
	final String DELETE = "DELETE FROM TRANSACTIONS WHERE TRANSACTION_ID = #{id}";

	
	@Insert(INSERT)
	@Options(useGeneratedKeys=true, keyProperty="transaction_id")
	void insert(Transaction transaction);
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="TRANSACTION_ID"),
		@Result(property="date", column="DATE"),
		@Result(property="description", column="DESCRIPTION"),
		@Result(property="contactId", column="CONTACT_ID"),
		@Result(property="amount", column="AMOUNT"),
		@Result(property="contactName", column="CONTACT_NAME"),
	})
	List<Transaction> selectAll(int userId);
	
	@Delete(DELETE)
	void delete(int id);
}
	
