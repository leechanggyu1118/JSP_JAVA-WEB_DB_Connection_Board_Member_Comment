package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int register(MemberVO mvo);

	MemberVO getID(MemberVO mvo);

	int lastLogin(String id);

	List<MemberVO> getList();


	int modify(MemberVO modify);

	int delete(String id);





}
