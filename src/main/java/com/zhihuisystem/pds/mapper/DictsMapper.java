package com.zhihuisystem.pds.mapper;

import com.zhihuisystem.pds.model.Dicts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictsMapper {
    /**
     *  根据主键删除数据库的记录
     *
     * @param dictId
     */
    int deleteByPrimaryKey(Integer dictId);

    /**
     *  新写入数据库记录
     *
     * @param record
     */
    int insert(Dicts record);

    /**
     *  动态字段,写入数据库记录
     *
     * @param record
     */
    int insertSelective(Dicts record);

    /**
     *  根据指定主键获取一条数据库记录
     *
     * @param dictId
     */
    Dicts selectByPrimaryKey(Integer dictId);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Dicts record);

    /**
     * 
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Dicts record);

    /**
     *  根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Dicts record);
}