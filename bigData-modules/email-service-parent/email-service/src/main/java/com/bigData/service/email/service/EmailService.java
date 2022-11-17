package com.bigData.service.email.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.email.api.dto.EmailDto;
import com.bigData.service.email.api.entity.EmailEntity;

import java.util.List;

public interface EmailService extends BaseService<EmailEntity> {

    EmailEntity getEmailById(String id);

    void saveEmail(EmailDto emailDto);

    void updateEmail(EmailDto emailDto);

    void deleteEmailById(String id);

    void deleteEmailBatch(List<String> ids);

    void sendEmail(String id);
}
