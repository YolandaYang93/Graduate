package com.gw.classsignin.model;

public class Course {
	
	private String id;
	private String name;
	private String teacherId;
	private String teacherName;
	private int week;
	private int startSection;
	private int endSection;
	private String startTime;
	private String endTime;
	
	
	
	public Course() {
	}
	
	
	public Course(String id, String name, String teacherId, String teacherName,
			int week, int startSection, int endSection) {
		super();
		this.id = id;
		this.name = name;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.week = week;
		this.startSection = startSection;
		this.endSection = endSection;
	}


	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getStartSection() {
		return startSection;
	}
	public int getEndSection() {
		return endSection;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public void setStartSection(int startSection) {
		this.startSection = startSection;
	}
	public void setEndSection(int endSection) {
		this.endSection = endSection;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
