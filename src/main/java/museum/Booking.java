package museum;

/*
 * Author: Taufik (March 2025)
 */

import java.io.Serializable;
import java.sql.Date;

public class Booking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookingId;
	private int userId;
	private Date date;
	private String session;
	private String guide;
	private int generalQuantity;
	private int studentQuantity;
	private int seniorQuantity;
	private int audioQuantity;
	private int cafeQuantity;
	
	public Booking() {}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getGuide() {
		return guide;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	public int getGeneralQuantity() {
		return generalQuantity;
	}
	public void setGeneralQuantity(int generalQuantity) {
		this.generalQuantity = generalQuantity;
	}
	public int getStudentQuantity() {
		return studentQuantity;
	}
	public void setStudentQuantity(int studentQuantity) {
		this.studentQuantity = studentQuantity;
	}
	public int getSeniorQuantity() {
		return seniorQuantity;
	}
	public void setSeniorQuantity(int seniorQuantity) {
		this.seniorQuantity = seniorQuantity;
	}
	public int getAudioQuantity() {
		return audioQuantity;
	}
	public void setAudioQuantity(int audioQuantity) {
		this.audioQuantity = audioQuantity;
	}
	public int getCafeQuantity() {
		return cafeQuantity;
	}
	public void setCafeQuantity(int cafeQuantity) {
		this.cafeQuantity = cafeQuantity;
	}
}