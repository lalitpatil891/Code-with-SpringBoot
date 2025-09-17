package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Actor {
	@NonNull
	private Integer aid;
	@NonNull
	private  String  aname;
	@NonNull
	private  String  addrs;
	@NonNull
	private  float  remunaration;
	@NonNull
	private   String category;
	private  String[]  favColors;
	private  List<String>  friends;
	private  Set<Long>  phones;
	private  Map<String,Object>  idDetails;
	private  Vehicle  vehicle;
	

}
