package app.service;

import app.domain.AppDomain;
import app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service")
public class AppServiceImpl implements AppService {

    @Autowired
    private AppRepository repository;

    @Override
    public List<AppDomain> findOnPrimary() {
        return repository.findOnPrimary();
    }

    @Override
    public List<AppDomain> findOnSecondary() {
        return repository.findOnSecondary();
    }
}
