package Kodluyoruz.RentACarProject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "employees")
public class Employee extends User {

	@Override
	public String getRole() {
		String getRole = "employee";
		return getRole;
	}
}
