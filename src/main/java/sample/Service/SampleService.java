package sample.Service;

import java.util.List;

import sample.VO.SampleVO;
import sample.VO.SearchConditionVO;

public interface SampleService {

	List<SampleVO> selectSampleList(SearchConditionVO searchVO);

	void updateSampleList(List<SampleVO> updateSampleList);



}
