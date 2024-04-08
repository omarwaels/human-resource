package iti.project.soap.Persistance.DAO;

import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;
import iti.project.soap.Utils.EmployerStatusEnum;
import iti.project.soap.Utils.JpaTransactionManager;
import jakarta.persistence.Query;

public class ProjectDAOImp {

    public static Project getById (int id ){
        Project res = JpaTransactionManager.doInTransaction((em)->{
          
            return em.find(Project.class, id);
        });
        res.getProjectManager(); // to get the lazy part
        return res ;
    }

    // }
    // public static EmployerStatusEnum getStatus (String employerEmail ){
        
    //     EmployerStatusEnum res = JpaTransactionManager.doInTransaction((em)->{
    //             Employer employer = null;
    //             Query query = em.createQuery("FROM Employer e WHERE e.email = :email");
    //             query.setParameter("email", employerEmail);
    //             employer = (Employer) query.getSingleResult();
    //             if(employer ==null ){
    //                 return EmployerStatusEnum.UNKNOWN_EMPLOYER;
    //             }else{
    //                 if(employer.getPassword() == null ){
    //                     return EmployerStatusEnum.NEW_EMPLOYER;
    //                 }else{
    //                     return EmployerStatusEnum.EXISTING_EMPLOYER;
    //                 }
    //             }
    //     });
    //     return res ;

    // }
    // public static Employer getEmployer (String employerEmail , String employerPassword ){
    //     Employer res = JpaTransactionManager.doInTransaction((em)->{
    //             Employer employer = null;
    //             Query query = em.createQuery("FROM Employer e WHERE e.email = :email");
    //             query.setParameter("email", employerEmail);
    //             employer = (Employer) query.getSingleResult();
    //             return employer ; 
    //     });
    //     return res ;
    // }
    public static boolean registerProject (Project project){
        Boolean res = JpaTransactionManager.doInTransaction((em)->{
                em.persist(project);
                return true ;
        });
        if(res == null) return false;
        return res == true ? true : false ;
    }
    public static boolean updateProject (Project project){
        Boolean res = JpaTransactionManager.doInTransaction((em)->{
                em.merge(project);
                return true ;
        });
        if(res == null) return false;
        return res == true ? true : false ;
    }
    
}
