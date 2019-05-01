package colin29.court.domain;

import java.util.Date;

public class Reservation {
	public Reservation(String courtName, Date date, int hour, Player player, SportType sportType) {
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
		this.player = player;
		this.sportType = sportType;
	}

	private String courtName;
	private Date date;
	private int hour;
	private Player player;
	private SportType sportType;

	public String getCourtName() {
		return courtName;
	}

	public Date getDate() {
		return date;
	}

	public int getHour() {
		return hour;
	}

	public Player getPlayer() {
		return player;
	}

	public SportType getSportType() {
		return sportType;
	}

}
