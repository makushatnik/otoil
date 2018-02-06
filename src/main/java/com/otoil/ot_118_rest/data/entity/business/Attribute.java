package com.otoil.ot_118_rest.data.entity.business;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
public class Attribute implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private BusinessObject businessObject;

    @NotNull
    @Column(name = "bo_type")
    private String type;

    @NotNull
    private String name;

    private String description;

    @Column(name = "order_number")
    private int ordNumber;

    @Column(name = "is_actual")
    private boolean isActual;

    @Column(name = "is_visible")
    private boolean isVisible;

    @Column(name = "is_required")
    private boolean isRequired;

    @Column(name = "enter_format")
    private String enterFormat;

    @Column(name = "view_format")
    private String viewFormat;

    private int version;

    public Attribute() {}

    public String getId() {
        return id;
    }

    public BusinessObject getBusinessObject() {
        return businessObject;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getOrdNumber() {
        return ordNumber;
    }

    public boolean isActual() {
        return isActual;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public String getEnterFormat() {
        return enterFormat;
    }

    public String getViewFormat() {
        return viewFormat;
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

        if (!(that instanceof Attribute)) return false;

        Attribute objThat = (Attribute) that;
        if (id != objThat.getId() ||
                (businessObject != null && !businessObject.equals(objThat.getBusinessObject())) ||
                !name.equals(objThat.getName()) ||
                !type.equals(objThat.getType())) {
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
