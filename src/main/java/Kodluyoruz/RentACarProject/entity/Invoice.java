package Kodluyoruz.RentACarProject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(name = "invoice_date")
	private LocalDate invoiceDate;

	@OneToOne
	@JoinColumn(name = "rental_id", unique = true)
	private Rental rental;

	@ManyToOne
	@JoinColumn(name = "corporate_customer_id")
	private CorporateCustomer corporateCustomer;
	
	@ManyToOne
	@JoinColumn(name = "individual_customer_id")
	private IndividualCustomer individualCustomer;

}
