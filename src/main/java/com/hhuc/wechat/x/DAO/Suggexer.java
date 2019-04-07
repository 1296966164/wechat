package com.hhuc.wechat.x.DAO;

import com.hhuc.wechat.x.Models.Suggestion;
import com.hhuc.wechat.x.Models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: Wechat_1
 * @description:
 * @author: LYX
 * @create: 2019-02-23 19:33
 **/
public class Suggexer<sout> {

    private String parameters[];

    public Suggexer(Suggestion suggestion) {
        this.suggestion = suggestion;
    }


    private int res;
    private Suggestion suggestion;
    private List<Suggestion> suggestions;

    private SqlSession getSqlSession() throws IOException {
        String resource = "com/hhuc/wechat/x/conf/mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

//    public String modifyPersonData() throws IOException {
//        SqlSession session = getSqlSession();
//        String openid =getOpenid();
//        String phone =getPhone();
//        String province =getProvince();
//        String city =getCity();
//        String language =getLanguage();
//        String avatarUrl =getAvatarUrl();
//
//        try {
//            UserMapper Mapper = session.getMapper(UserMapper.class);
//            res = Mapper.updateUserIfNecessary();
//            System.out.println(res);
//        } finally {
//            session.close();
//        }
//        return "修改成功"+res;
//    }


    public String commit() throws IOException {
        SqlSession session = getSqlSession();
        try {
            SuggMapper Mapper = session.getMapper(SuggMapper.class);
            Mapper.commit(suggestion);
            session.commit();
            System.out.println("增加完成");
        } finally {
            session.close();
        }
        return suggestion.toString();
    }


    public String queryAll() throws IOException {
        SqlSession session = getSqlSession();
        try {
            SuggMapper Mapper = session.getMapper(SuggMapper.class);
            Mapper.queryAll();
            System.out.println(Mapper.queryAll());
            System.out.println("查询结果如上");
        } finally {
            session.close();
        }

        return suggestions.toString();
    }


    public String queryCm() throws IOException {
        SqlSession session = getSqlSession();
        try {
            SuggMapper Mapper = session.getMapper(SuggMapper.class);
            suggestions = Mapper.queryCm(suggestion.getTowho());
            System.out.println(suggestions);
        } finally {
            session.close();
        }
        String Res = "";

        for (int i = 0; i < suggestions.size(); i++) {
            Res += "<br>";
            Res += suggestions.get(i).toString();
            Res += "</br>";
        }

        return Res;
    }
}