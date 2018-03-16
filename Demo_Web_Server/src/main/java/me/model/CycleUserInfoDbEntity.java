package me.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CycleUserInfoDb", schema = "Cycle", catalog = "")
public class CycleUserInfoDbEntity implements Serializable {
    private String cycleUserId;
    private String cyceleUserMessage;
    private byte flag;
    private String cycleLogInType;
    private String cycleLogInId;

    @Id
    @Column(name = "CycleUserID")
    public String getCycleUserId() {
        return cycleUserId;
    }

    public void setCycleUserId(String cycleUserId) {
        this.cycleUserId = cycleUserId;
    }

    @Basic
    @Column(name = "CyceleUserMessage")
    public String getCyceleUserMessage() {
        return cyceleUserMessage;
    }

    public void setCyceleUserMessage(String cyceleUserMessage) {
        this.cyceleUserMessage = cyceleUserMessage;
    }

    @Basic
    @Column(name = "Flag")
    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = " CycleLogInType")
    public String getCycleLogInType() {
        return cycleLogInType;
    }

    public void setCycleLogInType(String cycleLogInType) {
        this.cycleLogInType = cycleLogInType;
    }

    @Basic
    @Column(name = "CycleLogInID")
    public String getCycleLogInId() {
        return cycleLogInId;
    }

    public void setCycleLogInId(String cycleLogInId) {
        this.cycleLogInId = cycleLogInId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CycleUserInfoDbEntity that = (CycleUserInfoDbEntity) o;

        if (flag != that.flag) return false;
        if (cycleUserId != null ? !cycleUserId.equals(that.cycleUserId) : that.cycleUserId != null) return false;
        if (cyceleUserMessage != null ? !cyceleUserMessage.equals(that.cyceleUserMessage) : that.cyceleUserMessage != null)
            return false;
        if (cycleLogInType != null ? !cycleLogInType.equals(that.cycleLogInType) : that.cycleLogInType != null)
            return false;
        if (cycleLogInId != null ? !cycleLogInId.equals(that.cycleLogInId) : that.cycleLogInId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cycleUserId != null ? cycleUserId.hashCode() : 0;
        result = 31 * result + (cyceleUserMessage != null ? cyceleUserMessage.hashCode() : 0);
        result = 31 * result + (int) flag;
        result = 31 * result + (cycleLogInType != null ? cycleLogInType.hashCode() : 0);
        result = 31 * result + (cycleLogInId != null ? cycleLogInId.hashCode() : 0);
        return result;
    }
}
