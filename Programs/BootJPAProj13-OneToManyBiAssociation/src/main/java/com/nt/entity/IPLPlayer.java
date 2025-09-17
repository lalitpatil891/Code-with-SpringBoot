//IPLPlayer.java
package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_PLAYER")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class IPLPlayer {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "PID_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer  pid;
	
	@Column(length = 30)
	@NonNull
	private  String  pname;
	
	@Column(length = 30)
	@NonNull
	private  String paddrs;
	
	@NonNull
	private   Double price;
	
	@ManyToOne(targetEntity = IPLTeam.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "TEAM_ID",referencedColumnName = "TID")
	private  IPLTeam  team;

	
	public IPLPlayer() {
		System.out.println("IPLPlayer:: 0-param constructor::"+this.getClass());
	}
	
		
	//toSTring() (alt+shift+s,s)
	@Override
	public String toString() {
		return "IPLPlayer [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", price=" + price + "]";
	}

	

}
