package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Card {

	@Id
	@GeneratedValue(generator = "CardIdSequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CardIdSequence")
	private long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Typ typ;

	protected void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}

	public Card() {

	}

	public Card(Typ typ) {
		super();
		this.typ = typ;
	}
}
