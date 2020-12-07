package by.misha.entity;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sq_b")
    @SequenceGenerator(name ="sq_b",sequenceName = "sq_book",allocationSize = 1)
    private int id;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="id_stud")
    private Student student;
    @JoinColumn(name = "genre")
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", student=").append(student);
        sb.append('}');
        return sb.toString();
    }
}
