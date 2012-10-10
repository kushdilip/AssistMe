package com.tavant.db.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.tavant.db.ContactMapper;
import com.tavant.db.MyBatisConnectionFactory;
import com.tavant.db.TransactionMapper;
import com.tavant.domain.Transaction;

@Service("transactionMapper")
public class TransactionDAO {
	private SqlSessionFactory sqlSessionFactory;

	public TransactionDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public void insert(Transaction transaction) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			TransactionMapper mapper = session
					.getMapper(TransactionMapper.class);
			mapper.insert(transaction);

			session.commit();
		} finally {
			session.close();
		}
	}

	public List<Transaction> selectAll(int userId) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			TransactionMapper mapper = session
					.getMapper(TransactionMapper.class);
			List<Transaction> list = mapper.selectAll(userId);

			return list;
		} finally {
			session.close();
		}
	}

	public void delete(int id) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			TransactionMapper mapper = session
					.getMapper(TransactionMapper.class);
			mapper.delete(id);

			session.commit();
		} finally {
			session.close();
		}
	}

}
