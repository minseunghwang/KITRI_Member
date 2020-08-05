package service;

import dao.JoinDao;
import dao.JoinDaoImpl;
import model.Member;

public class JoinServiceImpl implements JoinService{
	
	private JoinDao dao;
	
	public JoinServiceImpl() {
		dao = new JoinDaoImpl();
	}

	@Override
	public void join(Member m) {
		dao.insert(m);
	}

	@Override
	public Member getMember(String id) {
		return null;
	}

	@Override
	public void editMember(Member m) {
		
	}

	@Override
	public void delMember(String id) {
		
	}
	
}
