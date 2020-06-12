package com.zhihuisystem.pds.model;

import java.io.Serializable;
import java.util.Date;

public class Dicts implements Serializable {
    /**
     * 字典ID
     */
    private Integer dictId;

    /**
     * 编号
     */
    private Integer dictNo;

    /**
     * 显示名称
     */
    private String dictNoName;

    /**
     * 
     */
    private String dictKey;

    /**
     * 
     */
    private String dictKeyName;

    /**
     * 创建时间
     */
    private Date dictCreatedDate;

    /**
     * 更新时间
     */
    private Date dictUpdatedDate;

    /**
     * 排序
     */
    private Integer dictSort;

    /**
     * 备注
     */
    private String dictRemark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 字典ID
     *
     * @return 字典ID
     */
    public Integer getDictId() {
        return dictId;
    }

    /**
     * 设置 字典ID
     *
     * @param dictId 字典ID
     */
    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    /**
     * 获取 编号
     *
     * @return 编号
     */
    public Integer getDictNo() {
        return dictNo;
    }

    /**
     * 设置 编号
     *
     * @param dictNo 编号
     */
    public void setDictNo(Integer dictNo) {
        this.dictNo = dictNo;
    }

    /**
     * 获取 显示名称
     *
     * @return 显示名称
     */
    public String getDictNoName() {
        return dictNoName;
    }

    /**
     * 设置 显示名称
     *
     * @param dictNoName 显示名称
     */
    public void setDictNoName(String dictNoName) {
        this.dictNoName = dictNoName == null ? null : dictNoName.trim();
    }

    /**
     * 获取 
     *
     * @return 
     */
    public String getDictKey() {
        return dictKey;
    }

    /**
     * 设置 
     *
     * @param dictKey 
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey == null ? null : dictKey.trim();
    }

    /**
     * 获取 
     *
     * @return 
     */
    public String getDictKeyName() {
        return dictKeyName;
    }

    /**
     * 设置 
     *
     * @param dictKeyName 
     */
    public void setDictKeyName(String dictKeyName) {
        this.dictKeyName = dictKeyName == null ? null : dictKeyName.trim();
    }

    /**
     * 获取 创建时间
     *
     * @return 创建时间
     */
    public Date getDictCreatedDate() {
        return dictCreatedDate;
    }

    /**
     * 设置 创建时间
     *
     * @param dictCreatedDate 创建时间
     */
    public void setDictCreatedDate(Date dictCreatedDate) {
        this.dictCreatedDate = dictCreatedDate;
    }

    /**
     * 获取 更新时间
     *
     * @return 更新时间
     */
    public Date getDictUpdatedDate() {
        return dictUpdatedDate;
    }

    /**
     * 设置 更新时间
     *
     * @param dictUpdatedDate 更新时间
     */
    public void setDictUpdatedDate(Date dictUpdatedDate) {
        this.dictUpdatedDate = dictUpdatedDate;
    }

    /**
     * 获取 排序
     *
     * @return 排序
     */
    public Integer getDictSort() {
        return dictSort;
    }

    /**
     * 设置 排序
     *
     * @param dictSort 排序
     */
    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    /**
     * 获取 备注
     *
     * @return 备注
     */
    public String getDictRemark() {
        return dictRemark;
    }

    /**
     * 设置 备注
     *
     * @param dictRemark 备注
     */
    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark == null ? null : dictRemark.trim();
    }
}