package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.MemberController;
import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	//로그객체
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	//sqlSession객체
	private SqlSession sql;
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int register(MemberVO mvo) {
		log.info("register dao in!!");
		int isOk = sql.insert("MemberMapper.register",mvo);
		if(isOk>0) {
			sql.commit();
		}	
		return isOk;
	}

	@Override
	public MemberVO getID(MemberVO mvo) {
		log.info("login dao in!!");
		return sql.selectOne("MemberMapper.login", mvo);
	}

	@Override
	public int lastLogin(String id) {
		log.info("lastLogin dao in!!");
		int isOk = sql.update("MemberMapper.last", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<MemberVO> getList() {
		log.info("list dao in!!");
		return sql.selectList("MemberMapper.list");
	}

	@Override
	public int modify(MemberVO modify) {
		log.info("modify dao in!!");
		int isOk = sql.update("MemberMapper.update", modify);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(String id) {
		log.info("delete dao in!!");
		int isOk = sql.delete("MemberMapper.delete", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;

	}




	
	//namespace="MemberMapper"
}
