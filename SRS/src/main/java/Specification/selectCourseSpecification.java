package Specification;

import com.github.zjh.domain.Course;
import com.github.zjh.domain.Section;
import com.github.zjh.domain.Students;
import com.github.zjh.domain.Transcript;

public class selectCourseSpecification implements Specification{
	   
	@Override
	public boolean enroll(Students student, Section section) {
		// TODO Auto-generated method stub
		 Transcript transcript = student.getTranscript();
		//判断有没有位置
		if (!section.confirmSeatAvailability()) {
			return false;
		}
	   //判断符不符合学习计划
		if(!student.getPlanOfStudy().isInPlanOfStudy(section.getRepresentedCourse())){
		return false;
	}
	    
	 // 判断学生是否参加过类似的课程，或者参加过并没有通过考试的可以继续
		if (student.isCurrentlyEnrolledInSimilar(section) || 
			    transcript.verifyCompletion(section.getRepresentedCourse())) {
				return false;
			}
		
		/// 判断学生是否满足该课程的前置课程，过不过
		Course c = section.getRepresentedCourse();
		if (c.hasPrerequisites()) {
			for (Course pre : c.getPrerequisites()) {
				if (!transcript.verifyCompletion(pre)) {
					return false;
				}
			}
		}
		return true;
	
	}

}

	

	
