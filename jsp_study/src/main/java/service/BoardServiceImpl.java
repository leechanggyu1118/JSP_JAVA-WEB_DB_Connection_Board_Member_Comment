package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAOImpl;
import repository.BoardDao;


public class BoardServiceImpl implements BoardService {
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDao bdao; //interface 생성
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl(); //class 생성
	}

	@Override
	public int register(BoardVO bvo) {
		log.info("register service in!!");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("list service in!!!");
		return bdao.selectList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("detail service in!!!");
		return bdao.selectOne(bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("update srvice in!!");
		return bdao.update(bvo);
	}

	@Override
	public int delete(int bno) {
		log.info("delete srvice in!!");
		return bdao.delete(bno);
	}
	
}
