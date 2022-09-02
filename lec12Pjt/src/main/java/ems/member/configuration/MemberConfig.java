package ems.member.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

@Configuration
public class MemberConfig {
	
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}
	
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}
	
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}
	
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo InforDev = new DataBaseConnectionInfo();
		InforDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		InforDev.setUserId("scott");
		InforDev.setUserPw("tiger");
		
		return InforDev;
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
		DataBaseConnectionInfo InforReal = new DataBaseConnectionInfo();
		InforReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		InforReal.setUserId("masterid");
		InforReal.setUserPw("masterpw");
		
		return InforReal;
	}
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService InforService = new EMSInformationService();
		InforService.setInfo("Education Management System program was developed in 2015.");
		InforService.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		InforService.setVer("The version is 1.0");
		InforService.setsYear(2015);
		InforService.setsMonth(1);
		InforService.setsDay(1);
		InforService.seteYear(2015);
		InforService.seteMonth(2);
		InforService.seteDay(28);
		
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian.");
		InforService.setDevelopers(developers);
		
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Cheney","cheney@springPjt.org");
		administrators.put("Jasper","jasper@springPjt.org");
		InforService.setAdministrators(administrators);
		
		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<String, DataBaseConnectionInfo>();
		dbInfos.put("dev",dataBaseConnectionInfoDev());
		dbInfos.put("real",dataBaseConnectionInfoReal());
		InforService.setDbInfos(dbInfos);
		
		return InforService;
		
	}
	
	
}
