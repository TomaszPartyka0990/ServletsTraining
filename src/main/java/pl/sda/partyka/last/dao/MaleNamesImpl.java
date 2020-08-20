package pl.sda.partyka.last.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.sda.partyka.last.domain.MaleNames;

import java.util.List;

public class MaleNamesImpl implements MaleNamesDao {

    private static final SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(registry).buildMetadata();
        sessionFactory = metadata.buildSessionFactory();
    }

    @Override
    public List<MaleNames> findAll() {
        Session session = sessionFactory.openSession();
        List<MaleNames> maleNames = session.createQuery("FROM MaleNames", MaleNames.class).getResultList();
        session.close();
        return maleNames;
    }

    @Override
    public int createOrUpdate(MaleNames maleName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(maleName);
        transaction.commit();
        session.close();
        return maleName.getId();
    }
}
