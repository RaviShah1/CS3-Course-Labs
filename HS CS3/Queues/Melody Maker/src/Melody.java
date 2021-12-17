import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * The Melody class represents a melody that can be played 
 */
public class Melody
{

	private Queue<Note> notes;
	
	/*
	 * Constructs an object of the Melody Class
	 */
	public Melody(Queue<Note> song)
	{
		notes = new LinkedList<Note>();
		for(Note n : song)
			notes.offer(n);
	}
	
	/*
	 * Gets the duration of the song
	 * @return dur is the duration of the song
	 */
	public double getTotalDuration()
	{
		Queue<Note> temp = new LinkedList<Note>();
		for(Note n : notes)
			temp.offer(n);
		
		Queue<Note> repeatedVals = new LinkedList<Note>();
		boolean repeat = false;
		
		double dur = 0;
		while(!temp.isEmpty())
		{
			Note note = temp.poll();
			dur+=note.getDuration();
			if(note.isRepeat())
				repeat = !repeat;
			if(repeat)
			{
				repeatedVals.offer(note);
			}
			if(note.isRepeat() && !repeat)
			{
				while(!repeatedVals.isEmpty())
					dur+=repeatedVals.poll().getDuration();
				dur+=note.getDuration();
			}
		}
		
		return dur;
	}
	
	/*
	 * Changes the tempo of the song
	 * @param tempo is the factor to change the speed of the song by
	 */
	public void changeTempo(double tempo)
	{
		for(Note n : notes)
			n.setDuration(n.getDuration()*(1/tempo));
	}
	
	public void reverse()
	{
		Stack<Note> invert = new Stack<Note>();
		while(!notes.isEmpty())
			invert.push(notes.poll());
		while(!invert.isEmpty())
			notes.offer(invert.pop());
	}
	
	/*
	 * Gets the notes of the song as a queue
	 * @return notes is a queue containing the notes of the song
	 */
	public Queue<Note> getNotes()
	{
		return notes;
	}
	
	/*
	 * Appends a melody to the end of the current melody
	 * @param other is the song to append
	 */
	public void append(Melody other)
	{
		Queue<Note> newNotes = other.getNotes();
		while(!newNotes.isEmpty())
		{
			notes.offer(newNotes.poll());
		}
	}
	
	/*
	 * Plays the song
	 */
	public void play()
	{
		Queue<Note> repeatedVals = new LinkedList<Note>();
		Queue<Note> temp = new LinkedList<Note>();
		
		boolean repeat = false;
		
		while(!notes.isEmpty())
		{
			Note note = notes.poll();
			note.play();
			temp.offer(note);
			
			if(note.isRepeat())
				repeat = !repeat;
			if(repeat)
			{
				repeatedVals.offer(note);
			}
			if(note.isRepeat() && !repeat)
			{
				while(!repeatedVals.isEmpty())
					repeatedVals.poll().play();
				note.play();
			}
		}
		notes = temp;
	}
	
	/*
	 * Gets the string representation of a melody
	 * @return the string representation of this melody
	 */
	public String toString()
	{
		String str = "";
		for(Note n : notes)
		{
			str += n.toString();
			str+="/n";
		}
		return str;
	}
}
