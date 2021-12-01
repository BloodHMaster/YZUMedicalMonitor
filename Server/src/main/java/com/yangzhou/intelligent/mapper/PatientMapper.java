package com.yangzhou.intelligent.mapper;

import com.yangzhou.intelligent.model.Patient;

public interface PatientMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}