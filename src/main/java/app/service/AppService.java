package app.service;

import app.domain.AppDomain;

import java.util.List;

public interface AppService {

    List<AppDomain> findOnPrimary();

    List<AppDomain> findOnSecondary();
}
