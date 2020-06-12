package com.zhihuisystem.pds.model;

import java.io.Serializable;
import java.util.Date;

public class PersonnelInfoGzry implements Serializable {
    /**
     * 唯一主键
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 职务取字典表值
     */
    private Integer dutyId;

    /**
     * 取字典表值
     */
    private Integer gwId;

    /**
     * 警号
     */
    private String siren;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 性别取字典表
     */
    private Integer sexId;

    /**
     * 出生日期
     */
    private Date birth;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 政治面貌，取字典表值
     */
    private Integer politicalStatusId;

    /**
     * 参加工作时间
     */
    private Date cjggss;

    /**
     * 参加公安工作时间
     */
    private Date cjgggzsj;

    /**
     * 参加监管工作时间
     */
    private Date cjjggzsj;

    /**
     * 籍贯表，取字典表值
     */
    private Integer nativePlaceId;

    /**
     * t_folk民族表ID
     */
    private Integer folkId;

    /**
     * 警衔，取字典表值
     */
    private Integer policeRankId;

    /**
     * 在职状态，取字典表值
     */
    private Integer workStatusId;

    /**
     * 离职时间
     */
    private Date outDate;

    /**
     * 文化程度，取字典表值
     */
    private Integer educationLevelId;

    /**
     * 专业职称，取字典表值
     */
    private Integer professionalTitleId;

    /**
     * 现住址详址
     */
    private String xzzxz;

    /**
     * 现住址
     */
    private String xzz;

    /**
     * 户籍地详址
     */
    private String hjdxz;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 图片路径地址，多个用引文;分开
     */
    private String iamgesUrl;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 唯一主键
     *
     * @return 唯一主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 唯一主键
     *
     * @param id 唯一主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 姓名
     *
     * @return 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 职务取字典表值
     *
     * @return 职务取字典表值
     */
    public Integer getDutyId() {
        return dutyId;
    }

    /**
     * 设置 职务取字典表值
     *
     * @param dutyId 职务取字典表值
     */
    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    /**
     * 获取 取字典表值
     *
     * @return 取字典表值
     */
    public Integer getGwId() {
        return gwId;
    }

    /**
     * 设置 取字典表值
     *
     * @param gwId 取字典表值
     */
    public void setGwId(Integer gwId) {
        this.gwId = gwId;
    }

    /**
     * 获取 警号
     *
     * @return 警号
     */
    public String getSiren() {
        return siren;
    }

    /**
     * 设置 警号
     *
     * @param siren 警号
     */
    public void setSiren(String siren) {
        this.siren = siren == null ? null : siren.trim();
    }

    /**
     * 获取 手机号码
     *
     * @return 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取 性别取字典表
     *
     * @return 性别取字典表
     */
    public Integer getSexId() {
        return sexId;
    }

    /**
     * 设置 性别取字典表
     *
     * @param sexId 性别取字典表
     */
    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    /**
     * 获取 出生日期
     *
     * @return 出生日期
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置 出生日期
     *
     * @param birth 出生日期
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 获取 身份证号
     *
     * @return 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置 身份证号
     *
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 获取 政治面貌，取字典表值
     *
     * @return 政治面貌，取字典表值
     */
    public Integer getPoliticalStatusId() {
        return politicalStatusId;
    }

    /**
     * 设置 政治面貌，取字典表值
     *
     * @param politicalStatusId 政治面貌，取字典表值
     */
    public void setPoliticalStatusId(Integer politicalStatusId) {
        this.politicalStatusId = politicalStatusId;
    }

    /**
     * 获取 参加工作时间
     *
     * @return 参加工作时间
     */
    public Date getCjggss() {
        return cjggss;
    }

    /**
     * 设置 参加工作时间
     *
     * @param cjggss 参加工作时间
     */
    public void setCjggss(Date cjggss) {
        this.cjggss = cjggss;
    }

    /**
     * 获取 参加公安工作时间
     *
     * @return 参加公安工作时间
     */
    public Date getCjgggzsj() {
        return cjgggzsj;
    }

    /**
     * 设置 参加公安工作时间
     *
     * @param cjgggzsj 参加公安工作时间
     */
    public void setCjgggzsj(Date cjgggzsj) {
        this.cjgggzsj = cjgggzsj;
    }

    /**
     * 获取 参加监管工作时间
     *
     * @return 参加监管工作时间
     */
    public Date getCjjggzsj() {
        return cjjggzsj;
    }

    /**
     * 设置 参加监管工作时间
     *
     * @param cjjggzsj 参加监管工作时间
     */
    public void setCjjggzsj(Date cjjggzsj) {
        this.cjjggzsj = cjjggzsj;
    }

    /**
     * 获取 籍贯表，取字典表值
     *
     * @return 籍贯表，取字典表值
     */
    public Integer getNativePlaceId() {
        return nativePlaceId;
    }

    /**
     * 设置 籍贯表，取字典表值
     *
     * @param nativePlaceId 籍贯表，取字典表值
     */
    public void setNativePlaceId(Integer nativePlaceId) {
        this.nativePlaceId = nativePlaceId;
    }

    /**
     * 获取 t_folk民族表ID
     *
     * @return t_folk民族表ID
     */
    public Integer getFolkId() {
        return folkId;
    }

    /**
     * 设置 t_folk民族表ID
     *
     * @param folkId t_folk民族表ID
     */
    public void setFolkId(Integer folkId) {
        this.folkId = folkId;
    }

    /**
     * 获取 警衔，取字典表值
     *
     * @return 警衔，取字典表值
     */
    public Integer getPoliceRankId() {
        return policeRankId;
    }

    /**
     * 设置 警衔，取字典表值
     *
     * @param policeRankId 警衔，取字典表值
     */
    public void setPoliceRankId(Integer policeRankId) {
        this.policeRankId = policeRankId;
    }

    /**
     * 获取 在职状态，取字典表值
     *
     * @return 在职状态，取字典表值
     */
    public Integer getWorkStatusId() {
        return workStatusId;
    }

    /**
     * 设置 在职状态，取字典表值
     *
     * @param workStatusId 在职状态，取字典表值
     */
    public void setWorkStatusId(Integer workStatusId) {
        this.workStatusId = workStatusId;
    }

    /**
     * 获取 离职时间
     *
     * @return 离职时间
     */
    public Date getOutDate() {
        return outDate;
    }

    /**
     * 设置 离职时间
     *
     * @param outDate 离职时间
     */
    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    /**
     * 获取 文化程度，取字典表值
     *
     * @return 文化程度，取字典表值
     */
    public Integer getEducationLevelId() {
        return educationLevelId;
    }

    /**
     * 设置 文化程度，取字典表值
     *
     * @param educationLevelId 文化程度，取字典表值
     */
    public void setEducationLevelId(Integer educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    /**
     * 获取 专业职称，取字典表值
     *
     * @return 专业职称，取字典表值
     */
    public Integer getProfessionalTitleId() {
        return professionalTitleId;
    }

    /**
     * 设置 专业职称，取字典表值
     *
     * @param professionalTitleId 专业职称，取字典表值
     */
    public void setProfessionalTitleId(Integer professionalTitleId) {
        this.professionalTitleId = professionalTitleId;
    }

    /**
     * 获取 现住址详址
     *
     * @return 现住址详址
     */
    public String getXzzxz() {
        return xzzxz;
    }

    /**
     * 设置 现住址详址
     *
     * @param xzzxz 现住址详址
     */
    public void setXzzxz(String xzzxz) {
        this.xzzxz = xzzxz == null ? null : xzzxz.trim();
    }

    /**
     * 获取 现住址
     *
     * @return 现住址
     */
    public String getXzz() {
        return xzz;
    }

    /**
     * 设置 现住址
     *
     * @param xzz 现住址
     */
    public void setXzz(String xzz) {
        this.xzz = xzz == null ? null : xzz.trim();
    }

    /**
     * 获取 户籍地详址
     *
     * @return 户籍地详址
     */
    public String getHjdxz() {
        return hjdxz;
    }

    /**
     * 设置 户籍地详址
     *
     * @param hjdxz 户籍地详址
     */
    public void setHjdxz(String hjdxz) {
        this.hjdxz = hjdxz == null ? null : hjdxz.trim();
    }

    /**
     * 获取 创建时间
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 更新时间
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 图片路径地址，多个用引文;分开
     *
     * @return 图片路径地址，多个用引文;分开
     */
    public String getIamgesUrl() {
        return iamgesUrl;
    }

    /**
     * 设置 图片路径地址，多个用引文;分开
     *
     * @param iamgesUrl 图片路径地址，多个用引文;分开
     */
    public void setIamgesUrl(String iamgesUrl) {
        this.iamgesUrl = iamgesUrl == null ? null : iamgesUrl.trim();
    }
}