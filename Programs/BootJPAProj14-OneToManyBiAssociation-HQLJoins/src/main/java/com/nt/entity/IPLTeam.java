//IPLTeam.java
package com.nt.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name="JPA_TEAM")
@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class IPLTeam {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "TID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer  tid;
	
	@Column(length = 30)
	@NonNull
	private  String   tname;
	
	@NonNull
	@Column(length = 30)
	private  String owner;
	
	@NonNull
	@Column(length = 30)
	private   String captain;
	
	@OneToMany(targetEntity = IPLPlayer.class,cascade = CascadeType.ALL,mappedBy = "team",fetch = FetchType.EAGER)
	//@JoinColumn(name = "TEAM_ID",referencedColumnName = "TID")
	private  Set<IPLPlayer>  players;
	
	public IPLTeam() {
		System.out.println("IPLTeam:: 0-param constructor::"+this.getClass());
	}

	//alt+shift+s ,s  (toString) 
	@Override
	public String toString() {
		return "IPLTeam [tid=" + tid + ", tname=" + tname + ", owner=" + owner + ", captain=" + captain + "]";
	}  
	
	
	
	

}
