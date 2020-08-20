package pl.sda.partyka.last.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.sda.partyka.last.domain.FemaleNames;

import java.util.List;

public class FemaleNamesImpl implements FemaleNamesDao {

    private static final SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(registry).buildMetadata();
        sessionFactory = metadata.buildSessionFactory();
    }

    @Override
    public List<FemaleNames> findAll() {
        Session session = sessionFactory.openSession();
        List<FemaleNames> femaleNames = session.createQuery("FROM FemaleNames", FemaleNames.class).getResultList();
        session.close();
        return femaleNames;
    }

    @Override
    public int createOrUpdate(FemaleNames femaleName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(femaleName);
        transaction.commit();
        session.close();
        return femaleName.getId();
    }
}
