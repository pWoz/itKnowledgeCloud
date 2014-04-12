package com.itKnowledgeCloud.services;

import com.itKnowledgeCloud.ejb.UsersBean;
import com.itKnowledgeCloud.model.User;

public class UserAccountsGeneratorWorker implements Runnable{
	
	private UsersBean usersBean;
	public UserAccountsGeneratorWorker(UsersBean usersBean){
		this.usersBean = usersBean;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			User u = new User();
			u.setLogin("user"+i);
			usersBean.addUser(u);
		}
	}
}
