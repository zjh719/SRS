package com.github.zjh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.zjh.domain.Students;
import com.github.zjh.domain.Section;
import com.github.zjh.service.SectionService;
import com.github.zjh.service.StudentsService;
import com.github.zjh.util.JavaEmail;


/**
 * @author ZJH
 * @since Jdk1.8
 * @describe studentsController
 * @time 2017年6月1日下午7:10:54
 */

@Controller
@RequestMapping("/student")
public class StudentsController extends BaseController{
	private static final int Section = 0;
	@Autowired
	protected StudentsService studentsService;
	@Autowired
	protected JavaEmail javaEmail;
	@Autowired
	protected SectionService sectionService;
	
	Map<String, Object> data =new HashMap<String,Object>();
	ModelAndView mView=new ModelAndView();
	
	/**
	 * @method 查询所有students
	 * @author ZJH
	 * @param asc
	 * @param pageNumber
	 * @param pageSize
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	@RequestMapping(value="/queryAll")
	@ResponseBody
	public Map<String, Object> queryAll(String asc,
			@RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "5") int pageSize
            ) throws Exception{
		data.put("total", studentsService.count());
		data.put("rows", studentsService.queryByPage(pageNumber, pageSize));
		return data;
		} 
	
	/**
	 * @Method
	 * @author ZJH
	 * @ 2017年7月1日 下午3:06:03
	 * @param asc
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/query")
	@ResponseBody
	public Map<String, Object> query(String asc,@RequestParam int page,@RequestParam int rows) throws Exception{
		data.put("rows", studentsService.queryByPage(page, rows));
		data.put("total", studentsService.count());
		return data;
		} 
	
	/**
	 * @Method
	 * @author ZJH
	 * @ 2017年7月1日 下午3:06:06
	 * @param students_id
	 * @param password
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login")
	@ResponseBody
	public Map<String , Object> login(
			@RequestParam("students_id") String students_id ,			
			@RequestParam("password") String password,
			HttpSession session
			) throws Exception{
		
		Boolean login=studentsService.checkLogin(students_id,password);
		if (login) {
			 session.setAttribute("student", studentsService.queryById(students_id));
			 return ajaxSuccessResponse();
		} 
		else {
			return ajaxFailureResponse();
		}
	} 
	
	// 检验登录并跳转页面
		/**
		 * @Method
		 * @author ZJH
		 * @ 2017年7月1日 下午3:06:10
		 * @param session
		 * @return
		 */
		@SuppressWarnings("unused")
		@RequestMapping(value="/sendLogin") 
		@ResponseBody
		public ModelAndView sendLogin(HttpSession session){
			 // 从session中获取students
			Students student = (Students)session.getAttribute("student"); 
			session.setAttribute("stuSection", sectionService.findSectionByStudent(student.getId()));
			// 判断session中的student是否为空
			if (student!=null)
				return new ModelAndView("redirect:/studentmain.jsp"); // 跳转至首页
			else
				return new ModelAndView("redirect:/login.jsp"); // 跳转至login页
		}
		
	
	/**
	 * @Method
	 * @author ZJH
	 * @ 2017年7月1日 下午3:06:13
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/exitLogin")
	@ResponseBody
	public ModelAndView exitLogin(HttpSession session) throws Exception{
		session.invalidate();
		mView.setViewName("login");
		return mView;
	}
	
	
	/**
	 * @Method 
	 * @author ZJH
	 * @ 2017年7月1日 下午3:06:18
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCourse")
	@ResponseBody
	public ModelAndView selectCourse(HttpSession session) throws Exception{
		
		return new ModelAndView("redirect:/selectCourse.jsp");
	}
	
	
	/**
	 * @Method
	 * @author ZJH
	 * @ 2017年7月1日 下午3:06:21
	 * @param asc
	 * @param students
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addStudents")
	@ResponseBody
	public Map<String,Object > addStudents(String asc,Students students) throws Exception{
		try {
			studentsService.addStudents(students);
			return ajaxSuccessResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return ajaxFailureResponse();
		}
		
		
	}
	
	/**
	 * @Method
	 * @author ZJH
	 * @ 2017年7月1日 下午3:06:25
	 * @throws InterruptedException
	 */
	@RequestMapping(value="/sendEmail")
	@ResponseBody
//	@Scheduled(cron="0/5 * *  * * ? ") 
	public void testScheduled() throws InterruptedException{
		javaEmail.sendHtmlEmail("1098018724@qq.com", "测试", "hello");		
		System.out.println("邮件已发送");	
	}
	
	
	
	
}
