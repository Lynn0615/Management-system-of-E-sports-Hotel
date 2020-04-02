package cn.stylefeng.guns.sys.modular.system.mapper;

import cn.stylefeng.guns.sys.modular.system.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
     * 获取通知列表
     */
    Page<Map<String, Object>> list(@Param("page") Page page, @Param("condition") String condition);

    /**
     * @Description 获取未阅读的通知
     * @param :
     * @return java.util.List<cn.stylefeng.guns.sys.modular.system.entity.Notice>
     */
    @Select("select * from sys_notice where is_read = 0 and is_del = 0")
    List<Notice> getUnReadNoticeList();

    /**
     * @Description 获取不分页的通知列表
     * @param :
     * @return java.util.List<cn.stylefeng.guns.sys.modular.system.entity.Notice>
     */
    @Select("select * from sys_notice where is_del = 0 order by create_time desc")
    List<Notice> getNoticeListByNotPagination();
}
