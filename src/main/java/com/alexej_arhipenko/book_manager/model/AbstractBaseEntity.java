package com.alexej_arhipenko.book_manager.model;

import org.hibernate.Hibernate;
import org.springframework.util.Assert;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected AbstractBaseEntity() {
    }

    protected AbstractBaseEntity(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long id() {
        Assert.notNull(id, "Entity must have id");
        return id;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), id);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : Long.hashCode(id);
    }

    public boolean isNew() {
        return id != null;
    }


}
