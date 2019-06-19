package df.db.mappers;

import df.bean.giftbean.Giftrecord;
import df.bean.giftbean.GiftrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiftrecordMapper {
    long countByExample(GiftrecordExample example);

    int deleteByExample(GiftrecordExample example);

    int insert(Giftrecord record);

    int insertSelective(Giftrecord record);

    List<Giftrecord> selectByExample(GiftrecordExample example);

    int updateByExampleSelective(@Param("record") Giftrecord record, @Param("example") GiftrecordExample example);

    int updateByExample(@Param("record") Giftrecord record, @Param("example") GiftrecordExample example);
}