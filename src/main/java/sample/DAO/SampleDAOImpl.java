package sample.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.VO.SampleVO;
import sample.VO.SearchConditionVO;

@Repository("sampleDao")
public class SampleDAOImpl implements SampleDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<SampleVO> selectSampleList(SearchConditionVO searchVO) {
		// TODO Auto-generated method stub

		return mybatis.selectList("SampleMapper.selectSampleList", searchVO);
	}

	@Override
	public void insertSampleList(SampleVO sample) {
		// insert를 위한 mybatis의 insert 속성을 사용하여 mapper의 sql문을 실행
	    mybatis.insert("SampleMapper.insertSampleList", sample);
		
	}

	@Override
	public void updateSampleList(SampleVO sample) {
		// update를 위한 mybatis의 update 속성을 사용하여 mapper의 sql문을 실행
	    mybatis.update("SampleMapper.updateSampleList", sample);
		
	}

	@Override
	public void deleteSampleList(SampleVO sample) {
		// delete를 위한 mybatis의 delete 속성을 사용하여 mapper의 sql문을 실행
	    mybatis.delete("SampleMapper.deleteSampleList", sample);
		
	}

	
		
	

	
	
}