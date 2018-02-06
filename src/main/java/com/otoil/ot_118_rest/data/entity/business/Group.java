package com.otoil.ot_118_rest.data.entity.business;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
public class Group implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] icon;

    @Column(name = "is_actual")
    private boolean isActual = false;//or isRelevant

    @Column(name = "is_visible")
    private boolean isVisible = false;

    private int version;

    public Group() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getIcon() {
        return icon;
    }

    public boolean isActual() {
        return isActual;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
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

        if (!(that instanceof Group)) return false;

        Group objThat = (Group) that;
        if (id != objThat.getId() ||
                !name.equals(objThat.getName())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.length();
        result = 31 * result + (name != "" ? name.hashCode() : 0);
        result = 31 * result + (description != "" ? description.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
