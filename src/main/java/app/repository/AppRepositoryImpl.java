package app.repository;

import app.domain.AppDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class AppRepositoryImpl implements AppRepositoryCustom<AppDomain> {

    @Autowired
    @Qualifier("mongoTemplateReadFromPrimary")
    private MongoTemplate mongoTemplateReadFromPrimary;

    @Autowired
    @Qualifier("mongoTemplateReadFromSecondary")
    private MongoTemplate mongoTemplateReadFromSecondary;

    private static Query QUERY_ON_PRIMARY = new Query().comment("QUERY_ON_PRIMARY");
    private static Query QUERY_ON_SECONDARY = new Query().comment("QUERY_ON_SECONDARY");

    @Override
    public List<AppDomain> findOnPrimary() {
        return mongoTemplateReadFromPrimary.find(QUERY_ON_PRIMARY, AppDomain.class);
    }

    @Override
    public List<AppDomain> findOnSecondary() {
        return mongoTemplateReadFromSecondary.find(QUERY_ON_SECONDARY, AppDomain.class);
    }
}
