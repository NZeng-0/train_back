package com.ruoyi.train.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 t_user
 *
 * @author me
 * @date 2025-03-13
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String realName;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private Long idType;

    /** 证件号 */
    @Excel(name = "证件号")
    private String idCard;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String mail;

    /** 删除标识 */
    private Integer delFlag;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setIdType(Long idType)
    {
        this.idType = idType;
    }

    public Long getIdType()
    {
        return idType;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getMail()
    {
        return mail;
    }

    public void setDelFlag(Integer delFlag)
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("username", getUsername())
                .append("password", getPassword())
                .append("realName", getRealName())
                .append("idType", getIdType())
                .append("idCard", getIdCard())
                .append("phone", getPhone())
                .append("mail", getMail())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
