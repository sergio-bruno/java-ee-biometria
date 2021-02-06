package com.java.service;

import CIDBio.CIDBio;
import CIDBio.ImageAndTemplate;
import CIDBio.RetCode;

public class TrazBiometria {

	public String retornaBiometria(String dedo) {
		// TODO Auto-generated method stub
		
		RetCode ret = CIDBio.Init();
		
		if(ret == RetCode.SUCCESS) {
			System.out.println("Bio Iniciado");
			CIDBio bio = new CIDBio();
			
			ImageAndTemplate imageAndTemplate = bio.CaptureImageAndTemplate();
			
			String digital = imageAndTemplate.getTemplateString();
			
			CIDBio.Terminate();
			
			return digital;
			
			//import CIDBio.MatchResult;
			//MatchResult result = bio.MatchTemplates(template1, template2);
			//System.out.println("Score: " + result.getScore());
			//System.out.println("RetCode: " + result.getRetCode());			
		} else {
			return CIDBio.GetErrorMessage(ret);
		}
	}
}
