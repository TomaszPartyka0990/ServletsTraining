package pl.sda.partyka.last.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.sda.partyka.last.domain.ForbiddenNames;

import javax.persistence.criteria.*;
import java.util.List;

public class ForbiddenNamesImpl implements ForbiddenNamesDao {

    private static final SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(registry).buildMetadata();
        sessionFactory = metadata.buildSessionFactory();
    }

    @Override
    public List<String> findAllNames() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        Root<ForbiddenNames> root = criteria.from(ForbiddenNames.class);
        criteria.select(root.<String>get("name"));
        List<String> forbiddenNames = session.createQuery(criteria).list();
        session.close();
        return forbiddenNames;
    }
}
