package com.github.zjh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.zjh.dao.SectionDao;
import com.github.zjh.domain.Course;
import com.github.zjh.domain.EnrollmentStatus;
import com.github.zjh.domain.Professor;
import com.github.zjh.domain.Section;
import com.github.zjh.domain.Students;
import com.github.zjh.domain.Transcript;
import com.github.zjh.service.SectionService;


@Controller
@RequestMapping("/section")
public class SectionController extends BaseController{
    @Resource(name="sectionService")
    protected SectionService sectionService;
    
    Map<String, Object> data =new HashMap<String,Object>();
    
	/**
	 * @Method 添加课程班次
	 * @author ZJH
	 * @ 2017年6月29日 上午10:35:21
	 * @param section
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addSection")
	@ResponseBody
    public Map<String,Object> addSection(Section section) throws Exception{
    	try {
			sectionService.addSection(section);
			return ajaxSuccessResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return ajaxFailureResponse();
		}
    }
	
	/**
	 * @Method 系主任根据课程查询班次
	 * @author ZJH
	 * @ 2017年6月29日 上午11:57:11
	 * @param courseNo
	 * @return Map
	 * @throws Exception
	 */
	@RequestMapping(value="/getSectionByCourseNo")
	@ResponseBody
	public Map<String, Object> getSectionByCourseNo(@RequestParam(required=true,defaultValue="0")String courseNo) throws Exception{
		data.put("rows", sectionService.getSectionByCourseNo(courseNo));
		System.out.println(data.size());
		return data;
	}
	
	/**
	 * @Method 删除班次
	 * @author ZJH
	 * @ 2017年6月29日 下午3:50:49
	 * @param sectionNo
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteSection")
	@ResponseBody
	public Map<String, Object>  deleteSection(@RequestParam(required=true,defaultValue="0")String sectionNo)throws Exception{
		try {
			sectionService.delete(sectionNo);
			return ajaxSuccessResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return ajaxFailureResponse();
		}
	}
	/**
	 * @Method 修改班次
	 * @author ZJH
	 * @ 2017年6月29日 下午3:56:12
	 * @param section
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/resetSection")
	@ResponseBody
	public Map<String, Object> resetSection(Section section)throws Exception{
	try {
		   sectionService.resetSection(section);
			return ajaxSuccessResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return ajaxFailureResponse();
		}
	}
	
	/**
	 * @Method 指定班次老师
	 * @author ZJH
	 * @ 2017年6月29日 下午3:58:20
	 * @return  Map
	 * @throws Exception
	 */
	@RequestMapping("/appointProfessor")
	@ResponseBody
	public  Map<String, Object> appointProfessor()  throws Exception{
	try {
			
			return ajaxSuccessResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return ajaxFailureResponse();
		}
	}
	
	/**
	 * @Method  输入成绩
	 * @author ZJH
	 * @ 2017年6月29日 下午4:00:34
	 * @return  Map
	 * @throws Exception
	 */
	@RequestMapping("/inputGrade")
	@ResponseBody
	public Map<String, Object> inputGrade() throws Exception{
	try {
			
			return ajaxSuccessResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return ajaxFailureResponse();
		}
	}
	/**
	 * @Method 根据班次找学生
	 * @author ZJH
	 * @ 2017年6月29日 下午4:06:27
	 * @param sectionNo
	 * @return Map
	 * @throws Exception
	 */
	@RequestMapping("/findStudentBySectionNo")
	@ResponseBody
	public Map<String, Object> findStudentBySectionNo(@RequestParam(required=true,defaultValue="0")String sectionNo) throws Exception{
		Map<String, Object> data1= new HashMap<String,Object>();
		data1.put("rows", sectionService.findStudentBySectionNo(sectionNo));
		return data1;
	}
	
	/**
	 * @Method 找到老师自己的教学
	 * @author ZJH
	 * @ 2017年6月30日 下午4:17:39
	 * @param session
	 * @return
	 */
	@RequestMapping("/findSectionByProfessorId")
	@ResponseBody
	public Map<String, Object> findSectionByProfessorId(HttpSession session){
		 Map<String, Object> map =new HashMap<String,Object>();
		 Professor professorId =(Professor)session.getAttribute("professor");
		 map.put("rows", sectionService. findSectionByProfessorId(professorId.getId()));
		 return map;
	}
	
	
	/**
	 * @Method 学生选课
	 * @author ZJH
	 * @ 2017年7月1日 下午4:55:47
	 * @param SectionNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="selectCourse")
	@ResponseBody
	public Map<String, Object> selectCourse(int sectionNo,String courseNo,HttpSession session){
		    Students student = (Students)session.getAttribute("student");
		    EnrollmentStatus enrollmentStatus=sectionService.selectCourse(student, sectionNo,courseNo);
		    if (enrollmentStatus.equals(EnrollmentStatus.success)) {
				sectionService.addTranscript(student.getId(),sectionNo,courseNo);
			}
			return ajaxSuccessResponse(enrollmentStatus.value());
	
	    }
	}
