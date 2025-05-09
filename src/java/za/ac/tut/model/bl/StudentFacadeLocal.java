/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.model.entity.Student;

/**
 *
 * @author samuk
 */
@Local
public interface StudentFacadeLocal {

    void create(Student student);

    void edit(Student student);

    void remove(Student student);

    Student find(Object id);

    List<Student> findAll();

    List<Student> findRange(int[] range);

    int count();
    
    Student find(String name,String surname);
       Integer cntAllMaleStudents();
       Integer cntAllFemaleStudents();
       Integer cntAllPassedStudents();
       Integer cntAllFailedStudents();
       Integer cntAllPassedMaleStudents();
       Integer cntAllPassedFemaleStudents();
       Integer cntAllFailedMaleStudents();
       Integer cntAllFailedFemaleStudents();
       
       List<Student>findStudentWithinRange(Integer minAge,Integer maxAge);
       Double getHighestMark();
       Double getLowestMark();
       Double getAvgMark();
       
    
}
