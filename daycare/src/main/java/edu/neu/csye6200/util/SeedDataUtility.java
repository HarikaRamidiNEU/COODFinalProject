package edu.neu.csye6200.util;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.service.factory.ImmunizationFactory;
import edu.neu.csye6200.service.factory.StudentFactory;
import edu.neu.csye6200.service.factory.TeacherFactory;
import edu.neu.csye6200.service.singleton.ImmunizationFactorySingleton;
import edu.neu.csye6200.service.singleton.PersonFactorySingleton;


public class SeedDataUtility {
    TeacherFactory tf = PersonFactorySingleton.getInstance().getTeacherFactory();
    StudentFactory sf = PersonFactorySingleton.getInstance().getStudentFactory();
    ImmunizationFactory vf = ImmunizationFactorySingleton.getInstance().getFactory();
    
    public List<Teacher> populateTeacherData(String csv){
        List<Teacher> teachers = new ArrayList<>();
        List<String> teacherCsv = FileUtil.readFile(csv);
        for(String teacherString : teacherCsv){
            teachers.add(tf.getObject(teacherString));
        }
        return teachers;
    }
    public List<Student> populateStudentData(String csv){
        List<Student> students = new ArrayList<>();
        List<String> studentCsvs = FileUtil.readFile(csv);
        for(String studentString : studentCsvs){
            students.add(sf.getObject(studentString));
        }
        return students;
    }
    public List<Immunization> populateVaccineData(String csv){
        List<Immunization> vaccines = new ArrayList<>();
        List<String> vaccineCsvs = FileUtil.readFile(csv);
        for(String vaccineString : vaccineCsvs){
            vaccines.add(vf.getObject(vaccineString));
        }
        return vaccines;
    }
}
