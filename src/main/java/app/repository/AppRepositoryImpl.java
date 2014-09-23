package app.repository;

import app.domain.AppDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class AppRepositoryImpl implements AppRepositoryCustom<AppDomain> {

    @Autowired
    @Qualifier("mongoTemplateReadFromPrimary")
    private MongoTemplate mongoTemplateReadFromPrimary;

    @Autowired
    @Qualifier("mongoTemplateReadFromSecondary")
    private MongoTemplate mongoTemplateReadFromSecondary;

    @Override
    public List<AppDomain> findOnPrimary() {
        return mongoTemplateReadFromPrimary.find(new Query(where("read preference").is("primary")),AppDomain.class);
    }

    @Override
    public List<AppDomain> findOnSecondary() {
        return mongoTemplateReadFromSecondary.find(new Query(where("read preference").is("secondary")),AppDomain.class);
    }
}
