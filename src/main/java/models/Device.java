package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Device {

	@Id
	@GeneratedValue(generator = "DeviceIdSequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "DeviceIdSequence")
	private long id;

	@OneToMany(cascade=CascadeType.ALL)
	List<Slot> slots = new ArrayList<Slot>();

	protected void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public Device() {

	}
	
	public Device(List<Slot> slots) {
		super();
		this.slots = slots;
	}

	public boolean insertCardToSlot(String nameOfSlot, Card card) {
		Slot slot = findSlotWithName(nameOfSlot);
		if (slot == null)
			return false;
		else if (slot.getCard() == null && slot.getCompatibleTyp().contains(card.getTyp())) {
			slot.setCard(card);
			return true;
		}
		return false;
	}

	private Slot findSlotWithName(String nameOfSlot) {
		for (Slot s : slots)
			if (s.getName().equals(nameOfSlot))
				return s;
		return null;
	}
}
