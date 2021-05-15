package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Actor {
private Integer ACTORID;
private String ACTORNAME;
private String  ACTORADDRESS;
private Long PHONENO;
private Float REMUNERATION;
}
