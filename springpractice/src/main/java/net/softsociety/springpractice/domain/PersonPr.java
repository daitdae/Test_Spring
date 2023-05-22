package net.softsociety.springpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonPr {
	
	String id;
	String password;
	String name;
	String phone;
	String com;

}
