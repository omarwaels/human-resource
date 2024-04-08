package iti.project.soap.Persistance.DAO;

import org.hibernate.Hibernate;

import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Utils.EmployerStatusEnum;
import iti.project.soap.Utils.JpaTransactionManager;
import jakarta.persistence.Query;

public class EmployerDAOImp {

    public static Employer getById (Integer id ){
        Employer res = JpaTransactionManager.doInTransaction((em)->{
          
            return em.find(Employer.class, id);
        });
        return res ;

    }
    public static Employer getByEmail (String employerEmail ){
        
        Employer res = JpaTransactionManager.doInTransaction((em)->{
                Employer employer = null;
                Query query = em.createQuery("FROM Employer e WHERE e.email = :email");
                query.setParameter("email", employerEmail);
                employer = (Employer) query.getSingleResult();
                return employer ;
        });
        return res ;

    }
    public static EmployerStatusEnum getStatus (String employerEmail ){
        
        EmployerStatusEnum res = JpaTransactionManager.doInTransaction((em)->{
                Employer employer = null;
                Query query = em.createQuery("FROM Employer e WHERE e.email = :email");
                query.setParameter("email", employerEmail);
                employer = (Employer) query.getSingleResult();
                if(employer ==null ){
                    return EmployerStatusEnum.UNKNOWN_EMPLOYER;
                }else{
                    if(employer.getPassword() == null ){
                        return EmployerStatusEnum.NEW_EMPLOYER;
                    }else{
                        return EmployerStatusEnum.EXISTING_EMPLOYER;
                    }
                }
        });
        return res ;

    }
    public static Employer getEmployer (String employerEmail ){
        Employer res = JpaTransactionManager.doInTransaction((em)->{
                Employer employer = null;
                Query query = em.createQuery("FROM Employer e WHERE e.email = :email");
                query.setParameter("email", employerEmail);
                employer = (Employer) query.getSingleResult();
                if (!Hibernate.isInitialized(employer.getHumanResourceId())) {
                    Hibernate.initialize(employer.getHumanResourceId());
                }

                return employer ; 
        });
        return res ;
    }
    public static boolean registerEmployer (Employer employer){
        Boolean res = JpaTransactionManager.doInTransaction((em)->{
                em.persist(employer);
                return true ;
        });
        if(res == null) return false;
        return res == true ? true : false ;
    }
    public static boolean updateEmployer (Employer employer){
        Boolean res = JpaTransactionManager.doInTransaction((em)->{
                em.merge(employer);
                return true ;
        });
        if(res == null) return false;
        return res == true ? true : false ;
    }
    
}
