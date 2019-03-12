package serviceimpl;


import java.util.List;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ReserveLaboratoryDao;
import service.ReserveLaboratoryService;
import entity.Lab_Reservation;

@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class ReserveLaboratoryServiceImpl implements ReserveLaboratoryService {
	@Autowired
	private ReserveLaboratoryDao reserveLaboratoryDao;
	

	@Override
	public int reserveLab(Reservation reservation) {
		int result=0;
		if(reservation.getReserve_type()==1){
			result=(int)reserveLaboratoryDao.reserveLab(reservation);
		}
		else{
			//调用Reserve_type=2的方法
			result=(int)reserveLaboratoryDao.reserveLab2(reservation);
		}
		return result;
	}


	@Override
	public List<Lab_Reservation> getLab_reservations(int lab_id) {
		List<Lab_Reservation> labReservation_list =reserveLaboratoryDao.getLab_reservations(lab_id);
		return labReservation_list;
	}


	@Override
	public List<lab_schedule> getSchedule_table(int lab_id) {
		return reserveLaboratoryDao.getSchedule_table(lab_id);
	}


	@Override
	public List<Lab_Reservation> reservationByUser(int user_id) {
		return reserveLaboratoryDao.reservationByUser(user_id);
	}


	@Override
	public int deleteReservation(int reserve_id) {
		return reserveLaboratoryDao.deleteReservation(reserve_id);
	}


	@Override
	public List<Lab_Reservation> ReservationTeacherForStudent(int user_id) {
		return reserveLaboratoryDao.ReservationTeacherForStudent(user_id);
	}


	@Override
	public List<user_lab_reservation> selectReservation(int user_id,
			int user_type, String user_name, int reserve_type, String from,
			String end) {
		return reserveLaboratoryDao.selectReservation( user_id, user_type,  user_name,  reserve_type,  from, end);
	}

}
