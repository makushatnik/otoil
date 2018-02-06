package com.otoil.ot_118_rest.data.entity.business;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
@Table(name = "structure_bo")
public class Link implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private BusinessObject parentBO;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id")
    private BusinessObject childBO;

    @Column(name = "is_link")
    private boolean isLink;//link or participate

    @Column(name = "parent_link_name")
    private String parentLinkName;

    @Column(name = "child_link_name")
    private String childLinkName;

    @Column(name = "is_actual")
    private boolean isActual;//or isRelevant

    @Column(name = "is_visible")
    private boolean isVisible;

    private int version;

    public Link() {}

    public String getId() {
        return id;
    }

    public BusinessObject getParentBO() {
        return parentBO;
    }

    public BusinessObject getChildBO() {
        return childBO;
    }

    public boolean isLink() {
        return isLink;
    }

    public String getParentLinkName() {
        return parentLinkName;
    }

    public String getChildLinkName() {
        return childLinkName;
    }

    public boolean isActual() {
        return isActual;
    }

    public boolean isVisible() {
        return isVisible;
    }

    @Version
    @Column(name = "version", nullable = false, insertable = true, updatable = true)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;

        if (that == null) return false;

        if (!(that instanceof Link)) return false;

        Link objThat = (Link) that;
        if (id != objThat.getId() ||
                (parentBO != null && !parentBO.equals(objThat.getParentBO())) ||
                (childBO != null && !childBO.equals(objThat.getChildBO())) ||
                !parentLinkName.equals(objThat.getParentLinkName()) ||
                !childLinkName.equals(objThat.getChildLinkName())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.length();
        result = 31 * result + (parentBO != null ? parentBO.hashCode() : 0);
        result = 31 * result + (childBO != null ? childBO.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
