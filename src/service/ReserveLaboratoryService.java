package service;

import java.util.List;

import entity.*;
import entity.Lab_Reservation;

public interface ReserveLaboratoryService {
	public int reserveLab(Reservation reservation);
	public List<Lab_Reservation> getLab_reservations(int lab_id);
	public List<lab_schedule> getSchedule_table(int lab_id);
	public List<Lab_Reservation> reservationByUser(int user_id);
	public int deleteReservation(int reserve_id);
	public List<Lab_Reservation> ReservationTeacherForStudent(int user_id);
	public List<user_lab_reservation> selectReservation(int user_id,
			int user_type, String user_name, int reserve_type, String from,
			String end);
}
