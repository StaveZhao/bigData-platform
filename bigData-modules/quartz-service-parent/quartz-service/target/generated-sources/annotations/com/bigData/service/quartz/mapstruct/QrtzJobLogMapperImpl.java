package com.bigData.service.quartz.mapstruct;

import com.bigData.service.quartz.api.dto.QrtzJobLogDto;
import com.bigData.service.quartz.api.entity.QrtzJobLogEntity;
import com.bigData.service.quartz.api.vo.QrtzJobLogVo;
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
public class QrtzJobLogMapperImpl implements QrtzJobLogMapper {

    @Override
    public QrtzJobLogDto toDTO(QrtzJobLogEntity e) {
        if ( e == null ) {
            return null;
        }

        QrtzJobLogDto qrtzJobLogDto = new QrtzJobLogDto();

        qrtzJobLogDto.setId( e.getId() );
        qrtzJobLogDto.setJobId( e.getJobId() );
        qrtzJobLogDto.setMsg( e.getMsg() );

        return qrtzJobLogDto;
    }

    @Override
    public List<QrtzJobLogDto> toDTO(List<QrtzJobLogEntity> es) {
        if ( es == null ) {
            return null;
        }

        List<QrtzJobLogDto> list = new ArrayList<QrtzJobLogDto>( es.size() );
        for ( QrtzJobLogEntity qrtzJobLogEntity : es ) {
            list.add( toDTO( qrtzJobLogEntity ) );
        }

        return list;
    }

    @Override
    public QrtzJobLogVo toVO(QrtzJobLogEntity e) {
        if ( e == null ) {
            return null;
        }

        QrtzJobLogVo qrtzJobLogVo = new QrtzJobLogVo();

        qrtzJobLogVo.setId( e.getId() );
        qrtzJobLogVo.setStatus( e.getStatus() );
        qrtzJobLogVo.setCreateTime( e.getCreateTime() );
        qrtzJobLogVo.setJobId( e.getJobId() );
        qrtzJobLogVo.setMsg( e.getMsg() );

        return qrtzJobLogVo;
    }

    @Override
    public List<QrtzJobLogVo> toVO(List<QrtzJobLogEntity> es) {
        if ( es == null ) {
            return null;
        }

        List<QrtzJobLogVo> list = new ArrayList<QrtzJobLogVo>( es.size() );
        for ( QrtzJobLogEntity qrtzJobLogEntity : es ) {
            list.add( toVO( qrtzJobLogEntity ) );
        }

        return list;
    }

    @Override
    public QrtzJobLogEntity toEntity(QrtzJobLogDto d) {
        if ( d == null ) {
            return null;
        }

        QrtzJobLogEntity qrtzJobLogEntity = new QrtzJobLogEntity();

        qrtzJobLogEntity.setId( d.getId() );
        qrtzJobLogEntity.setJobId( d.getJobId() );
        qrtzJobLogEntity.setMsg( d.getMsg() );

        return qrtzJobLogEntity;
    }

    @Override
    public List<QrtzJobLogEntity> toEntity(List<QrtzJobLogDto> ds) {
        if ( ds == null ) {
            return null;
        }

        List<QrtzJobLogEntity> list = new ArrayList<QrtzJobLogEntity>( ds.size() );
        for ( QrtzJobLogDto qrtzJobLogDto : ds ) {
            list.add( toEntity( qrtzJobLogDto ) );
        }

        return list;
    }
}
