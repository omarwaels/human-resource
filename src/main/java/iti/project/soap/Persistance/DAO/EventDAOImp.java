package iti.project.soap.Persistance.DAO;

import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Events;
import iti.project.soap.Persistance.Entity.Project;
import iti.project.soap.Utils.EmployerStatusEnum;
import iti.project.soap.Utils.JpaTransactionManager;
import jakarta.persistence.Query;
import java.util.List;

public class EventDAOImp {

    public static final int EMPLOYERPAGESIZE = 5;

    public static Events getById(int id) {
        Events res = JpaTransactionManager.doInTransaction((em) -> {
            return em.find(Events.class, id);
        });
        return res;
    }

    public static Events getByName(String eventName) {
        Events res = JpaTransactionManager.doInTransaction((em) -> {
            Events event = null;
            Query query = em.createQuery("FROM Events e WHERE e.eventName = :eventName");
            query.setParameter("eventName", eventName);
            event = (Events) query.getSingleResult();
            return event;
        });
        return res;
    }

    public static Boolean delByName(String eventName) {
        Boolean res = JpaTransactionManager.doInTransaction((em) -> {
            Query deleteQuery = em.createQuery("DELETE FROM Events e WHERE e.eventName = :eventName");
            deleteQuery.setParameter("eventName", eventName);
            int deletedCount = deleteQuery.executeUpdate();
            return deletedCount > 0;
        });
        return res;
    }

    public static boolean addEmployerToEventByName(String eventName, Employer employerToAdd) {
        boolean res = JpaTransactionManager.doInTransaction((em) -> {
            Events event = null;
            Query query = em.createQuery("FROM Events e WHERE e.eventName = :eventName");
            query.setParameter("eventName", eventName);
            event = (Events) query.getSingleResult();
            event.getEmployers().add(employerToAdd);
            return true;
        });
        return res;
    }

    public static List<Employer> getEmployersEvolved(String eventName, int start) {
        List<Employer> res = JpaTransactionManager.doInTransaction((em) -> {
            Query query = em.createQuery("SELECT e FROM Events v JOIN v.employers e WHERE v.eventName = :eventName");
            query.setParameter("eventName", eventName);
            query.setFirstResult(start);
            query.setMaxResults(EMPLOYERPAGESIZE);
            List<Employer> employers = query.getResultList();
            return employers;
        });
        return res;

    }

    public static boolean registerEvent(Events event) {
        Boolean res = JpaTransactionManager.doInTransaction((em) -> {
            em.persist(event);
            return true;
        });
        if (res == null)
            return false;
        return res == true ? true : false;
    }

    public static boolean updateEvent(Events event) {
        Boolean res = JpaTransactionManager.doInTransaction((em) -> {
            em.merge(event);
            return true;
        });
        if (res == null)
            return false;
        return res == true ? true : false;
    }

}
