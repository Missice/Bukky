package me.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CycleFanDb", schema = "Cycle", catalog = "")
public class CycleFanDbEntity implements Serializable {
    private String cycleUserId;
    private String cycleLikeId;
    private byte flag;

    @Id
    @Column(name = "CycleUserID")
    public String getCycleUserId() {
        return cycleUserId;
    }

    public void setCycleUserId(String cycleUserId) {
        this.cycleUserId = cycleUserId;
    }

    @Id
    @Column(name = "CycleLikeID")
    public String getCycleLikeId() {
        return cycleLikeId;
    }

    public void setCycleLikeId(String cycleLikeId) {
        this.cycleLikeId = cycleLikeId;
    }

    @Basic
    @Column(name = "Flag")
    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CycleFanDbEntity that = (CycleFanDbEntity) o;

        if (flag != that.flag) return false;
        if (cycleUserId != null ? !cycleUserId.equals(that.cycleUserId) : that.cycleUserId != null) return false;
        if (cycleLikeId != null ? !cycleLikeId.equals(that.cycleLikeId) : that.cycleLikeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cycleUserId != null ? cycleUserId.hashCode() : 0;
        result = 31 * result + (cycleLikeId != null ? cycleLikeId.hashCode() : 0);
        result = 31 * result + (int) flag;
        return result;
    }
}
