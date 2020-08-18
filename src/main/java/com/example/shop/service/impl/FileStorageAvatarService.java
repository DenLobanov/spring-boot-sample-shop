package com.example.shop.service.impl;


import com.example.shop.exception.InternalServerErrorException;
import com.example.shop.service.AvatarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Service
public class FileStorageAvatarService implements AvatarService {
	
	@Value("${app.avatar.root.dir}")
	private String rootDir;
	
	@Override
	public String processAvatarLink(String avatarUrlFromSocialNetwork) {
		try {
			String uniqFileName = generateUniqFileName();
			Path filePathToSave = Paths.get(rootDir+"/"+uniqFileName);
			downloadAvatar(avatarUrlFromSocialNetwork, filePathToSave);
			return "/media/avatar/"+uniqFileName;
		} catch (IOException e) {
			throw new InternalServerErrorException("Can't process avatar link", e);
		}
	}

	protected String generateUniqFileName(){
		return UUID.randomUUID().toString()+".jpg";
	}
	
	protected void downloadAvatar(String avatarUrl, Path filePathToSave) throws IOException {
		try(InputStream in = new URL(avatarUrl).openStream()) {
			Files.copy(in, filePathToSave);
		}
	}
}
