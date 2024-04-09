package iti.project.soap.Persistance.DAO;

import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;
import iti.project.soap.Utils.EmployerStatusEnum;
import iti.project.soap.Utils.JpaTransactionManager;
import jakarta.persistence.Query;
import java.util.List;

public class ProjectDAOImp {

    public static final int EMPLOYERPAGESIZE = 5;

    public static Project getById(int id) {
        Project res = JpaTransactionManager.doInTransaction((em) -> {

            return em.find(Project.class, id);
        });
        res.getProjectManager();
        return res;
    }

    public static Project getByName(String projectName) {
        Project res = JpaTransactionManager.doInTransaction((em) -> {
            Project project = null;
            Query query = em.createQuery("FROM Project p WHERE p.projectName = :projectName");
            query.setParameter("projectName", projectName);
            project = (Project) query.getSingleResult();
            return project;
        });
        res.getProjectManager();
        return res;
    }

    public static List<Employer> getEmpOfProjectById(int id, int start) {
        List<Employer> res = JpaTransactionManager.doInTransaction((em) -> {
            Query query = em.createQuery("SELECT e FROM Project p JOIN p.employer e WHERE p.projectId = :projectId");
            query.setParameter("projectId", id);
            query.setFirstResult(start);
            query.setMaxResults(EMPLOYERPAGESIZE);
            List<Employer> employers = (List<Employer>) query.getResultList();
            return employers;
        });
        return res;
    }

    public static boolean registerProject(Project project) {
        Boolean res = JpaTransactionManager.doInTransaction((em) -> {
            em.persist(project);
            return true;
        });
        if (res == null)
            return false;
        return res == true ? true : false;
    }

    public static boolean updateProject(Project project) {
        Boolean res = JpaTransactionManager.doInTransaction((em) -> {
            em.merge(project);
            return true;
        });
        if (res == null)
            return false;
        return res == true ? true : false;
    }

    public static Boolean delByName(String projectName) {
        Boolean res = JpaTransactionManager.doInTransaction((em) -> {
            Query deleteQuery = em.createQuery("DELETE FROM Project p WHERE p.projectName = :projectName");
            deleteQuery.setParameter("projectName", projectName);
            int deletedCount = deleteQuery.executeUpdate();
            return deletedCount > 0;
        });
        return res;
    }

}
