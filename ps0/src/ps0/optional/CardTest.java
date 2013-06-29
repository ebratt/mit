package ps0.optional;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	Card badCard1, badCard2, badCard3, AC, AC2, KH, KS;
	
	@Before
	@Test
	public final void testConstructor() {
		try { badCard1 = new Card(null,null); fail("Constructor allowed creation of a Card with null value and null suit!"); }	catch (Exception e) { }
		try { badCard2 = new Card(CardValue.ACE,null); fail("Constructor allowed creation of a Card with null value!"); }		catch (Exception e) { }
		try { badCard3 = new Card(null,CardSuit.CLUBS); fail("Constructor allowed creation of a Card with null value!"); }		catch (Exception e) { }
		try { AC = new Card(CardValue.ACE, CardSuit.CLUBS); } 		catch (Exception e) { fail("Constructor dis-allowed creation of a valid Card!"); }
		try { AC2 = new Card(CardValue.ACE, CardSuit.CLUBS); } 		catch (Exception e) { fail("Constructor dis-allowed creation of a valid Card!"); }
		try { KH = new Card(CardValue.KING, CardSuit.HEARTS); }		catch (Exception e) { fail("Constructor dis-allowed creation of a valid Card!"); }
		try { KS = new Card(CardValue.KING, CardSuit.SPADES); }		catch (Exception e) { fail("Constructor dis-allowed creation of a valid Card!"); }
	}

	@Test
	public final void testHashCode() {
		Assert.assertEquals(AC.hashCode(), AC2.hashCode());
		Assert.assertFalse(AC.hashCode() == KH.hashCode());
	}

	@Test
	public final void testGetSuit() {
		Assert.assertEquals(CardSuit.CLUBS, AC.getSuit());
		Assert.assertEquals(CardSuit.HEARTS, KH.getSuit());
		Assert.assertEquals(AC.getSuit(), AC2.getSuit());
		Assert.assertFalse(AC.getSuit().equals(KH.getSuit()));
	}

	@Test
	public final void testGetValue() {
		Assert.assertEquals(CardValue.ACE, AC.getValue());
		Assert.assertEquals(CardValue.KING, KH.getValue());
		Assert.assertEquals(AC.getValue(), AC2.getValue());
		Assert.assertFalse(AC.getValue().equals(KH.getValue()));
	}

	@Test
	public final void testCompareTo() {
		Assert.assertEquals(AC.compareTo(AC), 0);
		Assert.assertEquals(AC.compareTo(AC2), 0);
		Assert.assertEquals(AC.compareTo(new Card(CardValue.ACE, CardSuit.CLUBS)), 0);
		Assert.assertFalse(AC.compareTo(KH) == 0);
		Assert.assertTrue(AC.compareTo(KH) > 0);
		Assert.assertTrue(KH.compareTo(AC) < 0);
		Assert.assertTrue(KS.compareTo(KH) > 0);
		Assert.assertTrue(KH.compareTo(KS) < 0);
	}

	@Test
	public final void testEqualsObject() {
		Assert.assertTrue(AC.equals(AC));
		Assert.assertTrue(AC.equals(AC2));
		Assert.assertTrue(AC.equals(new Card(CardValue.ACE, CardSuit.CLUBS)));
		Assert.assertFalse(AC.equals(KH));
		Assert.assertFalse(AC.equals(KS));
		Assert.assertFalse(KS.equals(KH));
	}

	@Test
	public final void testToString() {
		String expected = "Ace of CLUBS";
		Assert.assertEquals(expected, AC.toString());
	}

}
