package app.repository;

import java.util.List;

public interface AppRepositoryCustom<AppDomain> {

    List<AppDomain> findOnPrimary();

    List<AppDomain> findOnSecondary();
}
