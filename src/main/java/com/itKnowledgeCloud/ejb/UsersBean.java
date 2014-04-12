package com.itKnowledgeCloud.ejb;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itKnowledgeCloud.ejb.myBatis.mappers.UsersMapper;
import com.itKnowledgeCloud.model.User;

@Stateless
@Named("okok")
public class UsersBean {
	
	@Inject
	private SqlSessionFactory sqlSessionFactory;
	
	public void addUser(User user){
		SqlSession sqlSession = null;
		try{
			sqlSession = sqlSessionFactory.openSession();
			UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
			mapper.addUser(user);
		}finally{
			sqlSession.close();
		}
	}
	
	public void addUser(){
		SqlSession sqlSession = null;
		try{
			sqlSession = sqlSessionFactory.openSession();
			UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
			User u = new User();
			u.setLogin("login");
			u.setName("name");
			mapper.addUser(u);
			u.toString();
		}finally{
			sqlSession.close();
		}
	}

}
