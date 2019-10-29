package com.mengqiqi.mybatistest;

import com.mengqiqi.dao.IUserDao;
import com.mengqiqi.entitis.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 10/23/2019 11:34 AM
 **/
public class MybatisTest {

    public static void main(String[] args) throws Exception {
        /**
         * 1 读取配置文件
         * 第一个：使用类加载器，他只能读取类路径的配置文件
         * 第二个：使用ServletContext对象的getRealPath()
         *
         * 不能使用绝对路径，相对路径
         * 绝对路径，例如，配置了d:/xxx/xxx.xml 服务器可能没有d盘
         * 相对路径，例如src/java/main/xxx.xml 发布后没有src目录，所以会找不到
         */
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        /**
         * 2 创建一个SqlSessionFactory工厂
         * 创建工程mybatis使用的是构建者模式
         * 构建者：目的是为了把繁琐的细节封装起来。
         *       优点：把对象的创建细节隐藏，让使用者直接调用方法即可拿到对象。
         *       例如：我们要造一个工厂，要选址，买建筑材料，找工人等事情，这些工作又费时又费力。
         *       为了节省时间通过找一个包工队来完成这些繁琐的工作，
         *       我们只要告诉包工队我们的需求，给钱
         *       SqlSessionFactoryBuilder就是包工队，负责造工厂，繁琐的事情我们就不用管了
         *       我们只需要给钱，参数in就是对应的钱
         */
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bulider.build(in);
        /**
         * 3 使用工厂模式生产SqlSession对象
         * 工厂模式：
         *        优势就是解耦，降低了类之间的依赖关系
         *        例如，new 了一个1实现，这个时候只能使用1实现。
         *        到了哪天想要使用2实现的时候，只能打开代码修改，发布，
         *        为了避免每次修改源码，重复发布的情况，就把new关键字屏蔽了，使用工厂为我们创建一个对象，这个时候解决了类之前的依赖关系
         *        为了避免频繁修改，就使用了工厂模式
         *
         */
        SqlSession session = factory.openSession();
        /**
         * 4 使用SqlSession创建Dao接扣的代理对象
         * 创建Dao接口实现类使用了代理模式
         * 代理模式：优点：不修改源码的基础上对已有方法增强
         */
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6 释放资源
        session.close();
        in.close();

    }
}
