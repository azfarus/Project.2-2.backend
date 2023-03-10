package com.example.arparina.classroom;




import com.example.arparina.student.Student;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Classroom implements Serializable {
    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dept;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "classroom_student",
            joinColumns = @JoinColumn(name = "classroom_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> students = new HashSet<Student>();
    public void setDept(String dept) {
        this.dept = dept;
    }



    public Set<Student> getStudents() {
        return students;
    }


}
