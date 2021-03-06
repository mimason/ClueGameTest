package ClueBoard;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import ClueBoard.Card.CardType;

public class ComputerPlayer extends Player{
	
	private int lastRoom = 0;
	private ArrayList<Card> deck;

	

	private char lastRoomVisted;
	private ArrayList<Card> seenCards = new ArrayList<Card>();
	
	public ComputerPlayer(String name, String color, int location, BoardCell cell) {
		super(name, color, location);
		// TODO Auto-generated constructor stub
	}
	
	public void move(int cell) {
		lastRoom = getLocation();
	}
	
	public BoardCell pickLocation(HashSet<BoardCell> hashSet, ArrayList<BoardCell> cells) {
		int i = 0;
		Random rand = new Random();
		int target = rand.nextInt(hashSet.size());
		
		BoardCell result = null;
			
		for (BoardCell key : hashSet) {
			if (key.isDoorway())
				return key;
			if (i == target) {
				result = key;
			}
			System.out.println(i);
			i++;
		}
		
		return result;
	}
	
	public int getLocation() {
		return location;
	}
	
	public void createDeck(String inputFile) throws FileNotFoundException {
		int x = 1;
		FileReader reader = new FileReader(inputFile);
		Scanner in = new Scanner(reader);
		deck = new ArrayList<Card>();
		
		while (in.hasNextLine()) {
			if (x <= 6) {
				deck.add(new Card(in.nextLine(), Card.CardType.PERSON));
			} else if (x > 6 && x <= 15) {
				deck.add(new Card(in.nextLine(), Card.CardType.ROOM));
			} else if (x > 15) {
				deck.add(new Card(in.nextLine(), Card.CardType.WEAPON));
			}
			x++;
		}
	}
	public ArrayList<Card> createSuggestion() {
		ArrayList<Card> suggestion = new ArrayList<Card>();
		updateSeen();		
		
		long seed = System.nanoTime();		
		Collections.shuffle(deck, new Random(seed));
		
		
		//put answer into solution, remove solution cards from deck 
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < deck.size(); i++) {
			if (deck.get(i).getCardtype() == Card.CardType.PERSON && a == 0) {
				System.out.println(deck.get(i).getCardName());
				suggestion.add(deck.get(i));				
				a++;
			} else if (deck.get(i).getCardtype() == Card.CardType.ROOM && b == 0) {
				System.out.println(deck.get(i).getCardName());
				suggestion.add(deck.get(i));
				b++;
			} else if (deck.get(i).getCardtype() == Card.CardType.WEAPON && c == 0) {
				System.out.println(deck.get(i).getCardName());
				suggestion.add(deck.get(i));
				c++;
			} 
		}
		return suggestion;
	}
	
	public void updateSeen() {
		for (Card i : myCards) {
			if (!seenCards.contains(i)) {
				seenCards.add(i);
				deck.remove(i);
			}
		}
		
		
	}
}
