package app.repository;

import app.domain.AppDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class AppRepositoryImpl implements AppRepositoryCustom<AppDomain> {

    @Autowired
    @Qualifier("mongoTemplateReadFromPrimary")
    private MongoTemplate mongoTemplateReadFromPrimary;

    @Autowired
    @Qualifier("mongoTemplateReadFromSecondary")
    private MongoTemplate mongoTemplateReadFromSecondary;

    @Override
    public List<AppDomain> findOnPrimary() {
        return mongoTemplateReadFromPrimary.findAll(AppDomain.class);
    }

    @Override
    public List<AppDomain> findOnSecondary() {
        return mongoTemplateReadFromSecondary.findAll(AppDomain.class);
    }
}
