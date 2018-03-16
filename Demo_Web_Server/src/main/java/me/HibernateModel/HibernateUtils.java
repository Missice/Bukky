package me.HibernateModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * hibernate 工具类, 初始化Hibernate, 获取会话工厂和会话对象
 * @author lxf
 *
 */

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static StandardServiceRegistry registry = (new StandardServiceRegistryBuilder()).configure().build();

    static {
        sessionFactory = (new MetadataSources(registry)).buildMetadata().buildSessionFactory();
    }

    public HibernateUtils() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        session = sessionFactory.openSession();
        return session;
    }

    public static void closeSession() {
        if (session != null) {
            session.clear();
        }

    }
}