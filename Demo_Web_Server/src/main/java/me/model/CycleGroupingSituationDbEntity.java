package me.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CycleGroupingSituationDb", schema = "Cycle", catalog = "")
public class CycleGroupingSituationDbEntity implements Serializable {
    private String cycleUserId;
    private String groupMessages;
    private byte flag;
    private String cycleStartDate;

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
    @Basic
    @Column(name = "GroupMessages")
    public String getGroupMessages() {
        return groupMessages;
    }

    public void setGroupMessages(String groupMessages) {
        this.groupMessages = groupMessages;
    }

    @Basic
    @Column(name = "Flag")
    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }



    public void setCycleStartDate(String cycleStartDate) {
        this.cycleStartDate = cycleStartDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CycleGroupingSituationDbEntity that = (CycleGroupingSituationDbEntity) o;

        if (flag != that.flag) return false;
        if (cycleUserId != null ? !cycleUserId.equals(that.cycleUserId) : that.cycleUserId != null) return false;
        if (groupMessages != null ? !groupMessages.equals(that.groupMessages) : that.groupMessages != null)
            return false;
        if (cycleStartDate != null ? !cycleStartDate.equals(that.cycleStartDate) : that.cycleStartDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cycleUserId != null ? cycleUserId.hashCode() : 0;
        result = 31 * result + (groupMessages != null ? groupMessages.hashCode() : 0);
        result = 31 * result + (int) flag;
        result = 31 * result + (cycleStartDate != null ? cycleStartDate.hashCode() : 0);
        return result;
    }
}
