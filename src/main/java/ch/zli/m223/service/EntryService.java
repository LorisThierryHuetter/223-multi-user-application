package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.application_user.ApplicationUser;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public ApplicationUser createApplicationUser(ApplicationUser applicationuser) {
        entityManager.persist(applicationuser);
        return applicationuser;
    }

    public List<ApplicationUser> findAll() {
        var query = entityManager.createQuery("FROM ApplicationUser", ApplicationUser.class);
        return query.getResultList();
    }

    @Transactional
    public void deleteApplicationUser(Long id){
        var entity = entityManager.find(ApplicationUser.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public ApplicationUser updateApplicationUser(Long id, ApplicationUser applicationuser) {
        return entityManager.merge(applicationuser);
    }

}
