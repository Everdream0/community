package com.nowcoder.community;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.service.DiscussPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class CaffeineTests {

    @Autowired
    private DiscussPostService discussPostService;

    @Test
    public void initDataForTest() {
        for (int i = 0; i < 300000; ++i) {
            DiscussPost post = new DiscussPost();
            post.setUserId(111);
            post.setTitle("互联网求职暖春计划");
            post.setContent("今年的就业形势，确实不容乐观。过了个年，仿佛跳水一般，整个讨论区哀鸿遍野！");
            post.setCreateTime(new Date());
            post.setScore(Math.random() * 3000);
            discussPostService.addDiscussPost(post);
        }
    }

    @Test
    public void testCache() {
        // 第一次，缓存里没有数据，访问一次数据库，访问完后就有了
        System.out.println(discussPostService.findDiscussPosts(0, 0, 10, 1));
        // 取缓存的数据
        System.out.println(discussPostService.findDiscussPosts(0, 0, 10, 1));
        // 取缓存的数据
        System.out.println(discussPostService.findDiscussPosts(0, 0, 10, 1));
        // 查询默认的排序，不走缓存
        System.out.println(discussPostService.findDiscussPosts(0, 0, 10, 0));
    }

}
