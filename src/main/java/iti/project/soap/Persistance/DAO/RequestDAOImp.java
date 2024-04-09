package iti.project.soap.Persistance.DAO;

import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;
import iti.project.soap.Persistance.Entity.Request;
import iti.project.soap.Utils.EmployerStatusEnum;
import iti.project.soap.Utils.JpaTransactionManager;
import jakarta.persistence.Query;
import java.util.List;

public class RequestDAOImp {

    public static final int EMPLOYERPAGESIZE = 5;

    public static Request getById(int id) {
        Request res = JpaTransactionManager.doInTransaction((em) -> {

            return em.find(Request.class, id);
        });

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

    public static List<Request> getRequestsEvolved(int id, int start) {
        List<Request> res = JpaTransactionManager.doInTransaction((em) -> {
            Query query = em
                    .createQuery("SELECT r FROM Request r JOIN r.project p WHERE r.project.projectId = :projectId");
            query.setParameter("projectId", id);
            query.setFirstResult(start);
            query.setMaxResults(EMPLOYERPAGESIZE);
            List<Request> employers = (List<Request>) query.getResultList();
            return employers;
        });
        return res;
    }

    public static boolean registerRequest(Request request) {
        Boolean res = JpaTransactionManager.doInTransaction((em) -> {
            em.persist(request);
            return true;
        });
        if (res == null)
            return false;
        return res == true ? true : false;
    }

    public static boolean updateRequest(Request request) {
        Boolean res = JpaTransactionManager.doInTransaction((em) -> {
            em.merge(request);
            return true;
        });
        if (res == null)
            return false;
        return res == true ? true : false;
    }

    public static Boolean delById(int reqId) {
        Boolean res = JpaTransactionManager.doInTransaction((em) -> {

            Query deleteQuery = em.createQuery("DELETE FROM Request r WHERE r.requestId = :requestId");
            deleteQuery.setParameter("requestId", reqId);
            int deletedCount = deleteQuery.executeUpdate();
            return deletedCount > 0;
        });
        return res;
    }

}
