package com.admin.study.login.controller;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.study.login.dao.ILoginDao;
import com.admin.study.login.dto.LoginDto;


@Controller
@RequestMapping(value = "/admin")
public class LoginController {
	
	@Autowired
	SqlSession sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
     * Simply selects the home view to render by returning its name.
     */
	@RequestMapping(value = "/login" , method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@RequestParam Map<String,Object> param , HttpSession session , Locale locale, ModelMap map) throws Exception{
		
        logger.info("Welcome login! {} , {} , {}", session.getId() , locale.getLanguage(), param.toString());
        
    	return "login";
    }
    
    @RequestMapping(value = "/loginProcess", method =RequestMethod.POST)
    public String loginProcess(@RequestParam Map<String,Object> param, HttpSession session,  ModelMap map) throws Exception{
//    public String loginProcess(@RequestParam Map<String,Object> param, HttpServletResponse response, HttpSession session,  ModelMap map) throws Exception{
    	String id = StringUtils.defaultString((String)param.get("userId"), "");
    	String pass = StringUtils.defaultString((String)param.get("password"), "");
    	String redirectUrl = StringUtils.defaultString((String)param.get("redirectUrl"), "");
    	  	
    	logger.info("seung        id   ======================  "+id);
    	logger.info("seung        pass   ======================  "+pass);
    	
    	ILoginDao loginDao = sqlSession.getMapper(ILoginDao.class);
    	LoginDto loginDto = loginDao.checkUser(id, pass);
    	
    	if(loginDto != null){
//    		session.invalidate();
    		session.setAttribute("adminInfo", loginDto);
    		return "redirect:member";
    	}
    	
    	return "redirect:login_fail";
    	
//    	ILoginDao loginDao = sqlSession.getMapper(ILoginDao.class);
//    	System.out.println(redirectUrl);
//    	int resultCnt = loginDao.checkUser(id, pass);
    	
//    	if(resultCnt == 0){
////    		response.setContentType("text/html;charset=UTF-8");
////    		PrintWriter out = response.getWriter();
////    		out.println("<script>alert('아이디 또는 비밀번호가 틀렸습니다.'); history.go(-1);</script>");
////    		out.flush();
//    		return "redirect:login_fail";
////    		return null;
//    	} 
//    	return "redirect:member";
    }
    
    @RequestMapping("/login_fail")
	public String loginFail(){
		return "login_fail";
	}
    
    @RequestMapping("/logout")
    public String logOut(HttpSession session){
    	session.setAttribute("adminInfo", null);
    	return "redirect:login";
    }
}
