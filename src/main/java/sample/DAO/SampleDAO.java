package sample.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sample.VO.SampleVO;
import sample.VO.SearchConditionVO;


public interface SampleDAO {

	List<SampleVO> selectSampleList(SearchConditionVO searchVO);

	void insertSampleList(SampleVO sample);

	void updateSampleList(SampleVO sample);

	void deleteSampleList(SampleVO sample);

	

}
