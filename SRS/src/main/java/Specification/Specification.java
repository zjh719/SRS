package Specification;

import com.github.zjh.domain.Section;
import com.github.zjh.domain.Students;

public interface Specification {
	public boolean enroll(Students student, Section section);
}
