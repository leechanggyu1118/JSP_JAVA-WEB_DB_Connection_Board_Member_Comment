package repository;

import java.util.List;

import domain.BoardVO;

public interface BoardDao {

	int insert(BoardVO bvo);

	List<BoardVO> selectList();

	BoardVO selectOne(int bno);


	int update(BoardVO bvo);

	int delete(int bno);

}
