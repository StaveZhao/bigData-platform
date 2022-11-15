package com.bigData.service.quartz.mapstruct;

import com.bigData.service.quartz.api.dto.QrtzJobDto;
import com.bigData.service.quartz.api.entity.QrtzJobEntity;
import com.bigData.service.quartz.api.vo.QrtzJobVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-10T17:06:37+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_252 (Amazon.com Inc.)"
)
@Component
public class QrtzJobMapperImpl implements QrtzJobMapper {

    @Override
    public QrtzJobDto toDTO(QrtzJobEntity e) {
        if ( e == null ) {
            return null;
        }

        QrtzJobDto qrtzJobDto = new QrtzJobDto();

        qrtzJobDto.setId( e.getId() );
        qrtzJobDto.setJobName( e.getJobName() );
        qrtzJobDto.setBeanName( e.getBeanName() );
        qrtzJobDto.setMethodName( e.getMethodName() );
        qrtzJobDto.setMethodParams( e.getMethodParams() );
        qrtzJobDto.setCronExpression( e.getCronExpression() );
        qrtzJobDto.setStatus( e.getStatus() );
        qrtzJobDto.setRemark( e.getRemark() );

        return qrtzJobDto;
    }

    @Override
    public List<QrtzJobDto> toDTO(List<QrtzJobEntity> es) {
        if ( es == null ) {
            return null;
        }

        List<QrtzJobDto> list = new ArrayList<QrtzJobDto>( es.size() );
        for ( QrtzJobEntity qrtzJobEntity : es ) {
            list.add( toDTO( qrtzJobEntity ) );
        }

        return list;
    }

    @Override
    public QrtzJobVo toVO(QrtzJobEntity e) {
        if ( e == null ) {
            return null;
        }

        QrtzJobVo qrtzJobVo = new QrtzJobVo();

        qrtzJobVo.setId( e.getId() );
        qrtzJobVo.setStatus( e.getStatus() );
        qrtzJobVo.setCreateTime( e.getCreateTime() );
        qrtzJobVo.setRemark( e.getRemark() );
        qrtzJobVo.setJobName( e.getJobName() );
        qrtzJobVo.setBeanName( e.getBeanName() );
        qrtzJobVo.setMethodName( e.getMethodName() );
        qrtzJobVo.setMethodParams( e.getMethodParams() );
        qrtzJobVo.setCronExpression( e.getCronExpression() );

        return qrtzJobVo;
    }

    @Override
    public List<QrtzJobVo> toVO(List<QrtzJobEntity> es) {
        if ( es == null ) {
            return null;
        }

        List<QrtzJobVo> list = new ArrayList<QrtzJobVo>( es.size() );
        for ( QrtzJobEntity qrtzJobEntity : es ) {
            list.add( toVO( qrtzJobEntity ) );
        }

        return list;
    }

    @Override
    public QrtzJobEntity toEntity(QrtzJobDto d) {
        if ( d == null ) {
            return null;
        }

        QrtzJobEntity qrtzJobEntity = new QrtzJobEntity();

        qrtzJobEntity.setId( d.getId() );
        qrtzJobEntity.setStatus( d.getStatus() );
        qrtzJobEntity.setRemark( d.getRemark() );
        qrtzJobEntity.setJobName( d.getJobName() );
        qrtzJobEntity.setBeanName( d.getBeanName() );
        qrtzJobEntity.setMethodName( d.getMethodName() );
        qrtzJobEntity.setMethodParams( d.getMethodParams() );
        qrtzJobEntity.setCronExpression( d.getCronExpression() );

        return qrtzJobEntity;
    }

    @Override
    public List<QrtzJobEntity> toEntity(List<QrtzJobDto> ds) {
        if ( ds == null ) {
            return null;
        }

        List<QrtzJobEntity> list = new ArrayList<QrtzJobEntity>( ds.size() );
        for ( QrtzJobDto qrtzJobDto : ds ) {
            list.add( toEntity( qrtzJobDto ) );
        }

        return list;
    }
}
