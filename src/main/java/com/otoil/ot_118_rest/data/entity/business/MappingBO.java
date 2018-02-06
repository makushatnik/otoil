package com.otoil.ot_118_rest.data.entity.business;

import com.otoil.ot_118_rest.data.entity.datasource.DataSource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
@Table(name = "business_object_in_ds")
public class MappingBO implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private BusinessObject businessObject;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "datasource_id", nullable = false)
    private DataSource dataSource;

    @Column(name = "used_tables")
    private String usedTables;

    @Lob
    @Column(name = "select_query")
    private String selectQuery;

    @Column(name = "insert_query")
    private String insertQuery;

    @Column(name = "update_query")
    private String updateQuery;

    @Column(name = "delete_query")
    private String deleteQuery;

    private String filter;

    @Column(name = "use_distinct")
    private boolean useDistinct;

    private int version;

    public MappingBO() {}

    public String getId() {
        return id;
    }

    public BusinessObject getBusinessObject() {
        return businessObject;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public String getUsedTables() {
        return usedTables;
    }

    public String getFilter() {
        return filter;
    }

    public String getSelectQuery() {
        return selectQuery;
    }

    public String getInsertQuery() {
        return insertQuery;
    }

    public String getUpdateQuery() {
        return updateQuery;
    }

    public String getDeleteQuery() {
        return deleteQuery;
    }

    public boolean isUseDistinct() {
        return useDistinct;
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

        if (!(that instanceof MappingBO)) return false;

        MappingBO objThat = (MappingBO) that;
        if (id != objThat.getId() ||
                (businessObject != null && !businessObject.equals(objThat.getBusinessObject())) ||
                (dataSource != null && !dataSource.equals(objThat.getDataSource())) ||
                usedTables != objThat.getUsedTables()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.length();
        result = 31 * result + (businessObject != null ? businessObject.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
