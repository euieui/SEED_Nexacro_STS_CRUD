package sample.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexacro.java.xapi.data.DataSet;
import com.nexacro.uiadapter.spring.core.data.DataSetRowTypeAccessor;

import sample.DAO.SampleDAO;
import sample.VO.SampleVO;
import sample.VO.SearchConditionVO;

// Service를 인식시켜주기 위한 설정
@Service("sampleService")
public class SampleServiceImpl implements SampleService{
	
	// SampleDAO 로 연결을 하기 위한 선언
	@Autowired
	private SampleDAO sampleDao;
	
	// Controller에서 받아온 selectSampleList의 메소드를 SampleDAO의 selectSampleList 메소드 전달
	// 결과로 얻은 반환값을 return을 통해 다시 Controller로 전달
	@Override
	public List<SampleVO> selectSampleList(SearchConditionVO searchVO) {
		return sampleDao.selectSampleList(searchVO);
	}

	@Override
	public void updateSampleList(List<SampleVO> updateSampleList) {
		System.out.println("서비스 시작");
		// 기존 DB에서 수정된 데이터를 size로 정의
		int size = updateSampleList.size();
		System.out.println("서비스 시작 222");
		try {
			System.out.println("서비스 시작 333");
			for (int i = 0 ; i < size ; i++) {
				
				System.out.println("서비스 시작 444");
				// 수정된 VO정보를 sample에 저장
				SampleVO sample = updateSampleList.get(i);
				
				
				System.out.println("서비스 시작 555");
				// DataSetRowTypeAccessor를 통해 각 타입의 row 정보를 가져온다
				if(sample instanceof DataSetRowTypeAccessor) {
					System.out.println("서비스 시작 666");
					DataSetRowTypeAccessor accessor = (DataSetRowTypeAccessor) sample;
					System.out.println("서비스 시작 777");
					// type insert 발생시
					if(accessor.getRowType() == DataSet.ROW_TYPE_INSERTED) {
						System.out.println("insert 발생 : " + sample.getName() + " " + sample.getUseYn());
						String id = null;
						
						id = "ex" + Integer.toString((int) (Math.random() * 999)) + "_ID";
						
						sample.setId(id);
						
						sampleDao.insertSampleList(sample);
					}else if (accessor.getRowType() == DataSet.ROW_TYPE_UPDATED){
						System.out.println("update 발생 : " + sample.getName() + " " + sample.getUseYn());
						sampleDao.updateSampleList(sample);
					}else if(accessor.getRowType() == DataSet.ROW_TYPE_DELETED) {
						System.out.println("delete 발생 : " + sample.getName() + " " + sample.getUseYn());
						sampleDao.deleteSampleList(sample);
					}
				}
			}
		
		}catch (Exception e) {
			System.out.println("에러 발생 " + e.getMessage());
		}
	}


		
	

}
