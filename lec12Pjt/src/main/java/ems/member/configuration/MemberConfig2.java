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
public class MemberConfig2 {

	
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
	
}
