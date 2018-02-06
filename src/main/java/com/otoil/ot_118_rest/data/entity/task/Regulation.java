package com.otoil.ot_118_rest.data.entity.task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
enum RegulationTypes {
    ONCE, HOURLY, DAILY, WEEKLY, MONTHLY, ANNUALLY
}

@Entity
public class Regulation implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "reg_id")
    private Task task;

    @NotNull
    @Column(name = "rgl_type")
    private RegulationTypes type;

    @NotNull
    @Column(name = "start_date")
    private Timestamp startDate;

    @NotNull
    @Column(name = "finish_date")
    private Timestamp endDate;

    @NotNull
    @Column(name = "run_count")
    private short runCount;

    private String limits;

    @Column(name = "is_actual")
    private boolean isActual;//or isRelevant

    private int version;

    public Regulation() {}

    public String getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public RegulationTypes getType() {
        return type;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public short getRunCount() {
        return runCount;
    }

    public String getLimits() {
        return limits;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setRunCount(short runCount) {
        this.runCount = runCount;
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

        if (!(that instanceof Regulation)) return false;

        Regulation objThat = (Regulation) that;
        if (id != objThat.getId() ||
                (type != null && !type.equals(objThat.getType())) ||
                (task != null && !task.equals(objThat.getTask())) ||
                startDate != objThat.getStartDate() &&
                endDate != objThat.getEndDate()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.length();
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
