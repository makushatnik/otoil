package com.otoil.ot_118_rest.data.entity.datasource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
public class State implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "datasource_id", nullable = false)
    private DataSource dataSource;

    @NotNull
    @Column(name = "changed_at")
    private Timestamp changeDate;

    /*
     * 0 - default,
     * 1 - normal,
     * 2 - high,
     * 3 - very high
     */
    private short status;

    private int version;

    public State() {}

    public String getId() {
        return id;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Timestamp getChangeDate() {
        return changeDate;
    }

    public short getStatus() {
        return status;
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

        if (!(that instanceof State)) return false;

        State objThat = (State) that;
        if (id != objThat.getId() ||
                (dataSource != null && !dataSource.equals(objThat.getDataSource())) ||
                changeDate != objThat.getChangeDate()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.length();
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + (changeDate != null ? changeDate.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
