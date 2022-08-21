package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Comment;
import com.nowcoder.community.util.CommunityConstant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 通过实体去选择评论
     *
     * @param entityType 评论的实体类型
     * @param entityId 评论的实体id
     * @param offset 每页第一条数据
     * @param limit 每页显示的行数限制
     * @return 显示的评论的列表
     */
    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);

    /**
     * 查询数据的条目数
     *
     * @param entityType
     * @param entityId
     * @return
     */
    int selectCountByEntity(int entityType, int entityId);

    int insertComment (Comment comment);

    Comment selectCommentById(int id);

}
