package com.otoil.ot_118_rest.data.entity.task;

import com.otoil.ot_118_rest.data.entity.business.MappingBO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
public class Operation implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_bo_id", nullable = true)
    private MappingBO mappingBO;

    @NotNull
    private String name;

    private String description;

    @Column(name = "type")
    private String operationType;

    private String filter;

    /*
     * 0 - dont known,
     * 1 - prepared,
     * 2 - accomplished,
     * 3 -
     */
    private short status = 0;

    @Column(name = "is_actual")
    private boolean isActual;//or isRelevant

    private int version;

    public Operation() {}

    public String getId() {
        return id;
    }

    public MappingBO getMappingBO() {
        return mappingBO;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOperationType() {
        return operationType;
    }

    public short getStatus() {
        return status;
    }

    public boolean isActual() {
        return isActual;
    }

    public String getFilter() {
        return filter;
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

        if (!(that instanceof Operation)) return false;

        Operation objThat = (Operation) that;
        if (id != objThat.getId() ||
                !name.equals(objThat.getName()) ||
                !description.equals(objThat.getDescription())) {
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
