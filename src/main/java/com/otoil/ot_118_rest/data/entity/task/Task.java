package com.otoil.ot_118_rest.data.entity.task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
public class Task implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    @Column(name = "is_actual")
    private boolean isActual;//or isRelevant

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "task_id")
    private List<Operation> operations;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_id", nullable = false)
    private int regulationId;

    private int version;

    public Task() {}


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActual() {
        return isActual;
    }

    public List<Operation> getOperations() {
        return operations;
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

        if (!(that instanceof Task)) return false;

        Task objThat = (Task) that;
        if (id != objThat.getId() ||
                (operations != null && !operations.equals(objThat.getOperations())) ||
                !name.equals(objThat.getName())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.length();
        result = 31 * result + (name != "" ? name.hashCode() : 0);
        result = 31 * result + (operations != null ? operations.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
