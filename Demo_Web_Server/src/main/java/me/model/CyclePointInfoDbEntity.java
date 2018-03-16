package me.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CyclePointInfoDb", schema = "Cycle", catalog = "")
public class CyclePointInfoDbEntity implements Serializable {
    private String cycleUserId;
    private String cyclePointMessage;
    private String cycleStartDate;
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
    @Column(name = "CycleStartDate")
    public String getCycleStartDate() {
        return cycleStartDate;
    }

    public void setCycleStartDate(String cycleindex) {
        this.cycleStartDate = cycleindex;
    }

    @Basic
    @Column(name = "CyclePointMessage")
    public String getCyclePointMessage() {
        return cyclePointMessage;
    }

    public void setCyclePointMessage(String cyclePointMessage) {
        this.cyclePointMessage = cyclePointMessage;
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

        CyclePointInfoDbEntity that = (CyclePointInfoDbEntity) o;

        if (flag != that.flag) return false;
        if (cycleUserId != null ? !cycleUserId.equals(that.cycleUserId) : that.cycleUserId != null) return false;
        if (cyclePointMessage != null ? !cyclePointMessage.equals(that.cyclePointMessage) : that.cyclePointMessage != null)
            return false;
        if (cycleStartDate != null ? !cycleStartDate.equals(that.cycleStartDate) : that.cycleStartDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cycleUserId != null ? cycleUserId.hashCode() : 0;
        result = 31 * result + (cycleStartDate != null ? cycleStartDate.hashCode() : 0);
        result = 31 * result + (cyclePointMessage != null ? cyclePointMessage.hashCode() : 0);
        result = 31 * result + (int) flag;
        return result;
    }
}
