package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper    // 声明是数据访问的对象
@Deprecated // 不推荐使用了，用Redis重构了
public interface LoginTicketMapper {

    // 用注解实现Mapper
    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",   // 分段记得最后要加一个空格
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")        // 自动生成id
    int insertLoginTicket(LoginTicket loginTicket);

    // 查询用ticket，因为整张表是以ticket为核心建立的，查询到的是唯一值
    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    // 通过修改status的状态来完成退出功能
    @Update({
            "update login_ticket set status=#{status} where ticket=#{ticket}"
    })
    int updateStatus(String ticket, int status);

}
