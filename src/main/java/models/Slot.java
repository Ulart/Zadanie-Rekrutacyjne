package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Slot {

	@Id
	@GeneratedValue(generator = "SlotIdSequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SlotIdSequence")
	private long id;

	@Column(nullable = false)
	private String Name;

	@OneToOne
	private Card card;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection
	private Set<Typ> compatibleTyp = new HashSet<Typ>();

	protected void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Set<Typ> getCompatibleTyp() {
		return compatibleTyp;
	}

	public void setCompatibleTyp(Set<Typ> compatibleTyp) {
		this.compatibleTyp = compatibleTyp;
	}

	public Slot() {

	}

	public Slot(String name, Card card, Set<Typ> compatibleTyp) {
		super();
		Name = name;
		this.card = card;
		this.compatibleTyp = compatibleTyp;
	}
}