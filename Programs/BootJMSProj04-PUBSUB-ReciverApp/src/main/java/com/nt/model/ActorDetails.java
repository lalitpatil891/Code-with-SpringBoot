package com.nt.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDetails implements  Serializable{
	private  Integer aid;
	private  String  aname;
	private  String addrs;
	private  String category;
	private  Float  remuneration;

}
