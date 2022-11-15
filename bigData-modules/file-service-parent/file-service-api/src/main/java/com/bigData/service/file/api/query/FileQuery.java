package com.bigData.service.file.api.query;

import com.bigData.common.base.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FileQuery extends BaseQueryParams {

    private static final long serialVersionUID=1L;

    private String fileName;
}
