package cn.stylefeng.guns.sys.modular.system.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.sys.modular.system.entity.Notice;
import cn.stylefeng.guns.sys.modular.system.mapper.NoticeMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class NoticeService extends ServiceImpl<NoticeMapper, Notice> {

    /**
     * 获取通知列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:05 PM
     */
    public Page<Map<String, Object>> list(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.list(page, condition);
    }


    /**
     * @Description 获取未阅读的通知列表
     * @param :
     * @return java.util.List<cn.stylefeng.guns.sys.modular.system.entity.Notice>
     */
    public List<Notice> getUnReadNoticeList(){
        return this.baseMapper.getUnReadNoticeList();
    }


    /**
     * @Description 获取不分页的通知列表
     * @param :
     * @return java.util.List<cn.stylefeng.guns.sys.modular.system.entity.Notice>
     */
    public List<Notice> getNoticeListByNotgetPagination(){
        return this.baseMapper.getNoticeListByNotPagination();
    }

    /**
     * @Description 获取未读通知的数量
     * @param notices:
     * @return int
     */
    public int getUnReadNum(List<Notice> notices){
        int count = 0;
        for (Notice notice : notices) {
            if (notice != null){
                if (notice.getIsRead() == 0){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @Description 修改通知的阅读状态
     * @param notices:
     * @return void
     */
    public void modifyNoticeStatus(List<Notice> notices){
        for (Notice notice : notices) {
            if (notice != null){
                notice.setIsRead(1);
                this.updateById(notice);
            }
        }
    }
}
