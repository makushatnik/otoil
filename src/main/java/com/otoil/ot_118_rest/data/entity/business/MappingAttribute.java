package com.otoil.ot_118_rest.data.entity.business;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
@Table(name = "attribute_bo_in_ds")
public class MappingAttribute implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_bo_id", nullable = false)
    private MappingBO mappingBO;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;

    @Column(name = "mapping_attr")
    private MappingAttribute mappingAttribute;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "link_bo_id")
    private Link link;

    @Column(name = "is_primary")
    private boolean isPrimaryKey;

    @Column(name = "is_unique")
    private boolean isUnique;

    @Column(name = "is_mandatory")
    private boolean isRequired;

    @Column(name = "const_value")
    private String constValue;

    @Column(name = "read_func")
    private String readFunction;

    @Column(name = "write_func")
    private String writeFunction;

    private Object column;//string or link

    /*
     * 0 - default,
     * 1 - normal,
     * 2 - high,
     * 3 - very high
     */
    @NotNull
    private short priority;//datasource priority

    private int version;

    public MappingAttribute() {}

    public String getId() {
        return id;
    }

    public MappingBO getMappingBO() {
        return mappingBO;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public MappingAttribute getMappingAttribute() {
        return mappingAttribute;
    }

    public Link getLink() {
        return link;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public String getConstValue() {
        return constValue;
    }

    public String getReadFunction() {
        return readFunction;
    }

    public String getWriteFunction() {
        return writeFunction;
    }

    public Object getColumn() {
        return column;
    }

    public short getPriority() {
        return priority;
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

        if (!(that instanceof MappingAttribute)) return false;

        MappingAttribute objThat = (MappingAttribute) that;
        if (id != objThat.getId() ||
                (mappingBO != null && !mappingBO.equals(objThat.getMappingBO())) ||
                (attribute != null && !attribute.equals(objThat.getAttribute())) ||
                !constValue.equals(objThat.getConstValue())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.length();
        result = 31 * result + (mappingBO != null ? mappingBO.hashCode() : 0);
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
