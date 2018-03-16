package me.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CycleKey", schema = "Cycle", catalog = "")
public class CycleKeyEntity implements Serializable {
    private String cycleUserId;
    private String accessToken;
    private String cycleAccessTokenTime;
    @Id
    @Column(name = "CycleUserId")
    public String getCycleUserId() {
        return cycleUserId;
    }

    public void setCycleUserId(String cycleUserId) {
        this.cycleUserId = cycleUserId;
    }

    @Basic
    @Column(name = "AccessToken")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Basic
    @Column(name = "CycleAccessTokenTime")
    public String getCycleAccessTokenTime() {
        return cycleAccessTokenTime;
    }

    public void setCycleAccessTokenTime(String cycleAccessTokenTime) {
        this.cycleAccessTokenTime = cycleAccessTokenTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CycleKeyEntity that = (CycleKeyEntity) o;

        if (cycleUserId != that.cycleUserId) return false;
        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        if (cycleAccessTokenTime != null ? !cycleAccessTokenTime.equals(that.cycleAccessTokenTime) : that.cycleAccessTokenTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cycleUserId != null ? cycleUserId.hashCode() : 0;
        result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
        result = 31 * result + (cycleAccessTokenTime != null ? cycleAccessTokenTime.hashCode() : 0);
        return result;
    }
}
