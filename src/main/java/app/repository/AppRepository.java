package app.repository;

import app.domain.AppDomain;
import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends CrudRepository<AppDomain, String>, AppRepositoryCustom<AppDomain> {

}
