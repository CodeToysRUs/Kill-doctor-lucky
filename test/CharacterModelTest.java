import character.CharacterModel;
import org.junit.Before;
import org.junit.Test;
import place.Place;
import place.PlaceModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CharacterModelTest {

	private CharacterModel character;

	/**
	 * Sets up a character with a name, health, and a list of places.
	 */
	@Before
	public void setUp() {
		PlaceModel pharmacy = new PlaceModel(8, 7, 11, 11, "Pharmacy");
		PlaceModel barberShop = new PlaceModel(6, 9, 8, 11, "Barber Shop");
		PlaceModel coffeeShop = new PlaceModel(0, 10, 5, 12, "Coffee Shop");

		List<Place> places = new ArrayList<>();
		places.add(pharmacy);
		places.add(barberShop);
		places.add(coffeeShop);

		character = new CharacterModel("The Mayor", 100, pharmacy, places);
	}

	/**
	 * Tests the initialization of the character.
	 */
	@Test
	public void testCharacterInitialization() {
		assertEquals("The Mayor", character.getName());
		assertEquals(100, character.getHealth());
		assertEquals("Pharmacy", character.getCurrentPlace().getName());
	}

	/**
	 * Tests the movement of the character to the next place.
	 */
	@Test
	public void testMoveToNextPlace() {
		assertEquals("Pharmacy", character.getCurrentPlace().getName());

		character.moveToNextPlace();
		assertEquals("Barber Shop", character.getCurrentPlace().getName());

		character.moveToNextPlace();
		assertEquals("Coffee Shop", character.getCurrentPlace().getName());
	}

	/**
	 * Tests the movement of the character to the next place and looping back to the
	 * first place.
	 */
	@Test
	public void testMoveToNextPlaceAndLoopBack() {
		character.moveToNextPlace();
		character.moveToNextPlace();

		character.moveToNextPlace();
		assertEquals("Pharmacy", character.getCurrentPlace().getName());
	}

	/**
	 * Tests the retrieval of the current place where the character is located.
	 */
	@Test
	public void testGetCurrentPlace() {
		assertEquals("Pharmacy", character.getCurrentPlace().getName());

		character.moveToNextPlace();
		assertEquals("Barber Shop", character.getCurrentPlace().getName());
	}
}