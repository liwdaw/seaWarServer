package com.liwdaw.config;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.liwdaw.util.XMLFile;

public class ServerConfig {
	
	private XMLFile xmlFile;
	
	public ServerConfig() throws Exception {
		Path xmlFilePath = FileSystems.getDefault().getPath("target/classes/config.xml");
		xmlFile = new XMLFile(xmlFilePath);
		xmlFile.setNodeList("server");
	}
	
	public int loadPort() {
		return Integer.parseInt(xmlFile.getElementByTagName("port"));
	}
	
}
