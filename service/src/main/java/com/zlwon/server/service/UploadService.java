package com.zlwon.server.service;

import org.springframework.web.multipart.MultipartFile;

import com.zlwon.vo.file.FileUploadVo;

/**
 * 上传Service
 * @author yangy
 *
 */

public interface UploadService {

	/**
	 * 上传文件（包括图片）
	 * 不执行压缩
	 * @param file
	 * @return
	 */
	FileUploadVo uploadFile(MultipartFile file);
	
	/**
	 * 上传图片，并执行压缩
	 * @param file
	 * @return
	 */
	FileUploadVo uploadThumbPicFile(MultipartFile file);
	
	/**
	 * 上传图片，并打上图片水印
	 * @param file
	 * @return
	 */
	FileUploadVo uploadWaterMarkFile(MultipartFile file);
	
	/**
	 * 上传二进制文件
	 * @param picByte
	 * @return
	 */
	FileUploadVo uploadBinaryFile(byte[] picByte);
}
