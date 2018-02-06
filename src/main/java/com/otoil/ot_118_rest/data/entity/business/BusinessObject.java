package com.otoil.ot_118_rest.data.entity.business;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
public class BusinessObject implements Serializable {
    @Id
    @NotNull
    private String id;

    @Column(name = "is_dir")
    private boolean isDirectory = false;

    @NotNull
    private String name;

    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] icon;

    @Column(name = "showcase")
    private String showcaseBO;

    @Column(name = "package_api")
    private String packageAPI = "v1";

    @Column(name = "is_actual")
    private boolean isActual;//or isRelevant

    @Column(name = "is_visible")
    private boolean isVisible;

    private int version;

    public BusinessObject() {}

    public String getId() {
        return id;
    }

    public boolean isDirectory() {
        return isDirectory;
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

    public String getShowcaseBO() {
        return showcaseBO;
    }

    public String getPackageAPI() {
        return packageAPI;
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

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;

        if (that == null) return false;

        if (!(that instanceof BusinessObject)) return false;

        BusinessObject objThat = (BusinessObject) that;
        if (id != objThat.getId() ||
                !name.equals(objThat.getName()) ||
                !showcaseBO.equals(objThat.getShowcaseBO())) {
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
