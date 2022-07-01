package com.havila.pojo;

public class Course {

	@Override
	public String toString() {
		return "Course [_id=" + id + ", optionalCourseId=" + optionalCourseId
				+ ", subject_name=" + subject_name + ", standard=" + standard
				+ ", section=" + section + "]";
	}

		// Course ID
		private Integer id;
		private Integer optionalCourseId;

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getOptionalCourseId() {
			return optionalCourseId;
		}
		public void setOptionalCourseId(Integer optionalCourseId) {
			this.optionalCourseId = optionalCourseId;
		}
		
		
		// Course name
		private String subject_name;

		public String getSubject_name() {
			return subject_name;
		}
		public void setSubject_name(String subject_name) {
			this.subject_name = subject_name;
		}

		public String getStandard() {
			return standard;
		}
		public void setStandard(String standard) {
			this.standard = standard;
		}
		public String getSection() {
			return section;
		}
		public void setSection(String section) {
			this.section = section;
		}

		private String standard;
		private String section;
	
}
