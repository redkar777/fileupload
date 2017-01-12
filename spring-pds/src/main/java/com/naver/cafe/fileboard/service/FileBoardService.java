package com.naver.cafe.fileboard.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileBoardService {
		Logger logger = LoggerFactory.getLogger(FileBoardService.class);
		public int addFileBoard(FileBoardCommand fileboardcommand){
			// 1 디렉토리 저장
			String path = "";
			String fileName = "";
			File destFile = null;
			String extention ="";
			try {
				path = "D:\\jjdev\\springwork\\spring-pds\\src\\main\\resources\\upload\\";
				UUID uuid = UUID.randomUUID();
				fileName = uuid.toString().replace("-","");
				MultipartFile multipartFile = fileboardcommand.getMultipartFile();
				int index = multipartFile.getOriginalFilename().lastIndexOf(".");
				extention = multipartFile.getOriginalFilename().substring(index+1);
				fileName = fileName+"."+extention;
				destFile = new File(path+fileName+"."+extention);
				
				multipartFile.transferTo(destFile);
				
				FileBoard fileBoard = new FileBoard();
				
				fileBoard.setTitle(fileboardcommand.getTitle());
				fileBoard.setAuth(fileboardcommand.getAuth());
				fileBoard.setFilePath(path);
				fileBoard.setFileName(fileName);
				fileBoard.setExtention(extention);
				
				logger.info("{}", fileBoard.toString());
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				destFile.delete();
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				destFile.delete();
				e.printStackTrace();
			}
			
			
			// 2 FileBoardCommand --> FileBoard -> DAO
			return 0;
		}
}
