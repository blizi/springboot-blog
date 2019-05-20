package com.blizi.blog;

import com.blizi.blog.entity.User;
import com.blizi.blog.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import utils.date.DateUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Commit
public class BlogApplicationTests {
//    @Autowired
//    private UserMapper mapper;
//
//    /**
//     * 查找所有数据
//     */
//    @Test
//    public void selectAll(){
//        List<User> users = mapper.selectAll();
//        for(User user : users){
//            System.out.println(user.toString());
//        }
//    }
//    /**
//     * 插入数据
//     */
//    @Test
//    public void insert(){
//        User user = new User();
//        user.setName("test");
//        user.setPassword("123");
//        user.setReDate(new DateUtils().getNowTime());
//        int i = mapper.insert(user);
//        System.out.println(i);
//        selectAll();
//    }
//    @Test
//    public void delete(){
//        Example example = new Example(User.class);
//        example.createCriteria().andEqualTo("name","test");
//        mapper.deleteByExample(example);
//    }
}
