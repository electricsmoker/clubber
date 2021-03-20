package org.angelove.clubs.domain;

import com.sun.istack.NotNull;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(
            name = "club_visitor",
            joinColumns = {@JoinColumn(name = "club", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "visitor", referencedColumnName = "id")}
    )
    @BatchSize(size = 10)
    private Set<Visitor> visitors = new HashSet<>();

    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Club name(String name) {
        this.name = name;
        return this;
    }

    public void setVisitors(Set<Visitor> visitors) {
        this.visitors = visitors;
    }

    public Set<Visitor> getVisitors() {
        return visitors;
    }
}
