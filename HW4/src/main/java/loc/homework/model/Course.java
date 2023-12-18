package loc.homework.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String title;

    @Column
    private int duration;


    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course(int id,String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course() {
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
