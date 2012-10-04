package com.tavant.db.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.tavant.db.AnniversaryMapper;
import com.tavant.db.MyBatisConnectionFactory;
import com.tavant.domain.Anniversary;

@Service("anniversaryMapper")
public class AnniversaryDAO {
	private SqlSessionFactory sqlSessionFactory;

	public AnniversaryDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public void insert(Anniversary anniversary) {
		SqlSession session = sqlSessionFactory.openSession();

		try {

			AnniversaryMapper mapper = session
					.getMapper(AnniversaryMapper.class);
			mapper.insert(anniversary);

			session.commit();
		} finally {
			session.close();
		}

	}

	public List<Anniversary> selectAllByUserId(int userId) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			AnniversaryMapper mapper = session
					.getMapper(AnniversaryMapper.class);
			List<Anniversary> list = mapper.selectAllByUserId(userId);

			return list;
		} finally {
			session.close();
		}
	}

	public void delete(int anniversaryId, int userId) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			AnniversaryMapper mapper = session
					.getMapper(AnniversaryMapper.class);
			mapper.delete(anniversaryId, userId);

			session.commit();
		} finally {
			session.close();
		}
	}

	public void update(Anniversary anniversary) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			AnniversaryMapper mapper = session
					.getMapper(AnniversaryMapper.class);
			mapper.update(anniversary);

			session.commit();
		} finally {
			session.close();
		}
	}
	
	public Anniversary selectById(int anniversaryId, int userId){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			AnniversaryMapper mapper = session.getMapper(AnniversaryMapper.class);
			Anniversary anniversary = mapper.selectById(anniversaryId, userId);
			System.out.println(anniversary);
			return anniversary;
		} finally {
			session.close();
		}
	}
	
}
