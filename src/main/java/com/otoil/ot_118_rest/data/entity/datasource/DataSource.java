package com.otoil.ot_118_rest.data.entity.datasource;

import org.json.JSONArray;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
public class DataSource implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @Column(name = "datasource_id")
    private DataSource dataSource;

    @NotNull
    private String name;

    private String description;

    @Column(name = "is_actual")
    private boolean isActual;

    @Column(name = "is_visible")
    private boolean isVisible;

    /*
    * 0 - default,
    * 1 - normal,
    * 2 - high,
    * 3 - very high
    */
    @NotNull
    private short priority;

    @Column(name = "params")
    private JSONArray params;

    private int version;

    public DataSource() {}

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActual() {
        return isActual;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public short getPriority() {
        return priority;
    }

    public JSONArray getParams() {
//        ArrayList<Object> params = new ArrayList<>();
//        if (!params_str.isEmpty()) {
//            String str = params_str.replace("[","");
//            str = str.replace("]","");
//            int len = str.length();
//            String curStr = "";
//            for (int i=0; i < len; i++) {
//                char curCh = str.charAt(i);
//                if (curCh == 10) {
//
//                } else if (curCh == 13) {
//
//                } else {
//
//                }
//            }
//        }
        return params;
    }

    @Version
    @Column(name = "version", nullable = false, insertable = true, updatable = true)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setParams(JSONArray params) {
//        String str = "";
//        int len = params.size();
//        for (int i=0; i < len; i++) {
//            Object curObj = params.get(i);
//            str += "{";
//            str += params.get(i);
//            str += "}";
//        }
//        if (!str.isEmpty()) {
//            str = "[" + str + "]";
//        }
//        if (!str.equals(params_str)) {
//            params_str = str;
//        }
        this.params = params;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;

        if (that == null) return false;

        if (!(that instanceof DataSource)) return false;

        DataSource objThat = (DataSource) that;
        if (id != objThat.getId() ||
                (type != null && !type.equals(objThat.getType())) ||
                (dataSource != null && !dataSource.equals(objThat.getDataSource())) ||
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
