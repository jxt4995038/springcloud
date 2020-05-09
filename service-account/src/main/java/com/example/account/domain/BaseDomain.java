package com.example.account.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-12-23 16:52
 */
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BaseDomain  implements  Serializable {

    private static final long serialVersionUID = 9104864818970977517L;
    @Id
    @GeneratedValue(
            generator = "uuid"
    )
    @Column(
            length = 32,
            nullable = false,
            updatable = false
    )
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid"
    )
    private String id;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(
            updatable = false
    )
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(
            insertable = false
    )
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}