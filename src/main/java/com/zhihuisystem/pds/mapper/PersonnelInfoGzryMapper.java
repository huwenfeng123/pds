package com.zhihuisystem.pds.mapper;

import com.zhihuisystem.pds.model.PersonnelInfoGzry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonnelInfoGzryMapper {
    /**
     *  根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录
     *
     * @param record
     */
    int insert(PersonnelInfoGzry record);

    /**
     *  动态字段,写入数据库记录
     *
     * @param record
     */
    int insertSelective(PersonnelInfoGzry record);

    /**
     *  根据指定主键获取一条数据库记录
     *
     * @param id
     */
    PersonnelInfoGzry selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(PersonnelInfoGzry record);

    /**
     *  根据主键来更新符合条件的数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(PersonnelInfoGzry record);
}