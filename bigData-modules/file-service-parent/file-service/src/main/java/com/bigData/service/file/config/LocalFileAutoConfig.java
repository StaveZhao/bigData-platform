package com.bigData.service.file.config;

import com.bigData.common.utils.ThrowableUtil;
import com.bigData.service.file.api.entity.FileEntity;
import com.bigData.service.file.properties.FileServerProperties;
import com.bigData.service.file.service.impl.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.IOException;

/**
 * 本地文件配置
 */
@Configuration
@ConditionalOnProperty(name = "data.file-server.type", havingValue = "local")
public class LocalFileAutoConfig {

	private final Logger logger = LoggerFactory.getLogger(LocalFileAutoConfig.class);

	@Autowired
	private FileServerProperties fileProperties;

	@Bean
	public WebMvcConfigurer webMvcConfigurerAdapter() {
		return new WebMvcConfigurer() {
			/**
			 * 外部文件访问
			 */
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler(fileProperties.getLocal().getPrefix() + "/**")
						.addResourceLocations(ResourceUtils.FILE_URL_PREFIX + fileProperties.getLocal().getPath() + File.separator);
			}
		};
	}

	@Service
	public class LocalFileServiceImpl extends FileServiceImpl {

		@Override
		protected String fileType() {
			return fileProperties.getType();
		}

		@Override
		protected void uploadFile(MultipartFile file, FileEntity fileEntity) {
			String localPath = fileProperties.getLocal().getPath();
			File parentFile = new File(localPath);
			if (!parentFile.exists()) {
				if (!parentFile.mkdirs()) {
					throw new RuntimeException("创建保存路径失败");
				}
			}
			fileEntity.setFilePath(localPath + File.separator + fileEntity.getFileName());
			File dest = new File(localPath + File.separator + fileEntity.getFileName());
			try {
				file.transferTo(dest);
			} catch (IOException e) {
				logger.error("全局异常信息ex={}, StackTrace={}", e.getMessage(), ThrowableUtil.getStackTrace(e));
			}
		}

		@Override
		protected void deleteFile(FileEntity fileEntity) {
			File file = new File(fileEntity.getFilePath());
			if (file.exists()) {
				file.delete();
			}
		}
	}
}
