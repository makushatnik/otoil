package com.otoil.ot_118_rest.data.entity.datasource;

import org.json.JSONArray;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Ageev Evgeny on 31.01.2018.
 */
@Entity
@Table(name = "datasource_kind")
public class Type implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotNull
    @Column(name = "identifier")
    private String typeId;

    @NotNull
    private String typeName;

    private String name;

    private String description;

    private String notation;

    @Column(name = "dictionary_class_name")
    private String dictionaryName;

    @NotNull
    @Column(name = "read_name")
    private String readName;

    @NotNull
    @Column(name = "write_name")
    private String writeName;

    @Column(name = "is_actual")
    private boolean isActual;

    @Column(name = "is_visible")
    private boolean isVisible;

    @Column(name = "params")
    private JSONArray params;

    private int version;

    public Type() {}

    public String getId() {
        return id;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public String getReadName() {
        return readName;
    }

    public String getWriteName() {
        return writeName;
    }

    public boolean isActual() {
        return isActual;
    }

    public boolean isVisible() {
        return isVisible;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
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

        if (!(that instanceof Type)) return false;

        Type objThat = (Type) that;
        if (id != objThat.getId() ||
                !typeId.equals(objThat.getTypeId()) ||
                !typeName.equals(objThat.getTypeName())) {
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
