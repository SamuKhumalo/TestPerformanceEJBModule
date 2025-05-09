/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.model.entity.Student;

/**
 *
 * @author samuk
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "TestPerformedEJBModuleV1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public Student find(String name, String surname) {
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.firstName=?1 AND s.lastName =?2 ");
        query.setParameter(1, name);
        query.setParameter(2, surname);

        Student student = (Student) query.getSingleResult();
        return student;
    }

    @Override
    public Integer cntAllMaleStudents() {
        Query query = em.createQuery("Select count(s) FROM Student s WHERE s.gender='M' ");
        Long cnt = (Long) query.getSingleResult();
        return cnt.intValue();

    }

    @Override
    public Integer cntAllFemaleStudents() {
        Query query = em.createQuery("SELECT count(s) FROM Student s WHERE s.gender='F' ");
        Long cnt = (Long) query.getSingleResult();

        return cnt.intValue();

    }

    @Override
    public Integer cntAllPassedStudents() {
        Query query = em.createQuery("SELECT count(s) FROM Student s WHERE s.percentageMarkObtained >50 ");
        Long cnt = (Long) query.getSingleResult();

        return cnt.intValue();

    }

    @Override
    public Integer cntAllFailedStudents() {
        Query query = em.createQuery("SELECT count(s) FROM Student s WHERE s.percentageMarkObtained <50 ");
        Long cnt = (Long) query.getSingleResult();

        return cnt.intValue();

    }

    @Override
    public Integer cntAllPassedMaleStudents() {
        Query query = em.createQuery("SELECT count(s) FROM Student s WHERE s.percentageMarkObtained >50 AND s.gender ='M' ");
        Long cnt = (Long) query.getSingleResult();

        return cnt.intValue();

    }

    @Override
    public Integer cntAllPassedFemaleStudents() {
        Query query = em.createQuery("SELECT count(s) FROM Student s WHERE s.percentageMarkObtained >50 AND s.gender ='F' ");
        Long cnt = (Long) query.getSingleResult();

        return cnt.intValue();
    }

    @Override
    public Integer cntAllFailedMaleStudents() {
        Query query = em.createQuery("SELECT count(s) FROM Student s WHERE s.percentageMarkObtained <50 AND s.gender ='M' ");
        Long cnt = (Long) query.getSingleResult();

        return cnt.intValue();

    }

    @Override
    public Integer cntAllFailedFemaleStudents() {
        Query query = em.createQuery("SELECT count(s) FROM Student s WHERE s.percentageMarkObtained <50 AND s.gender ='F' ");
        Long cnt = (Long) query.getSingleResult();

        return cnt.intValue();

    }

    @Override
    public List<Student> findStudentWithinRange(Integer minAge, Integer maxAge) {

        Query query = em.createQuery("SELECT s FROM Student s WHERE s.age >=?1 AND s.age<=?2 ");
        query.setParameter(1, minAge);
        query.setParameter(2, maxAge);
        List<Student> students = query.getResultList();

        return students;

    }

    @Override
    public Double getHighestMark() {
        Query query = em.createQuery("SELECT MAX( s.percentageMarkObtained) FROM Student s ");
        Double maxMark = (Double) query.getSingleResult();

        return maxMark;

    }

    @Override
    public Double getLowestMark() {
        Query query = em.createQuery("SELECT MIN( s.percentageMarkObtained) FROM Student s ");
        Double minMark = (Double) query.getSingleResult();

        return minMark;
    }

    @Override
    public Double getAvgMark() {
        Query query = em.createQuery("SELECT AVG( s.percentageMarkObtained) FROM Student s ");
        Double avgMark = (Double) query.getSingleResult();

        return avgMark;
    }

}
