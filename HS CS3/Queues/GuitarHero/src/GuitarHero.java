import java.awt.*;

import javax.swing.JFrame;

/*****************************************************************************
 *  Compilation:  javac GuitarHero.java
 *  Execution:    java  GuitarHero
 *  Dependencies: StdAudio.java StdDraw.java GuitarString.java
 *
 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ****************************************************************************/

public class GuitarHero { 

    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C
        //double CONCERT_A = 440.0;
        //double CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);
        //GuitarString stringA = new GuitarString(CONCERT_A);
        //GuitarString stringC = new GuitarString(CONCERT_C);

 
        
        GuitarString strings[] = new GuitarString[37];
        for(int i=0; i< 37; i++)
        {
        	strings[i] = new GuitarString(440 * (Math.pow(2, (i-24)/12)));
        }
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; 
        //String[] testSong = "i p z v b z p b n z p n d [ i d z p i p z p i u i i".split(" ");
        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                // pluck the corresponding string
                for(int i=0; i<keyboard.length(); i++)
                {
                	if(key == keyboard.charAt(i))
                		strings[i].pluck();
                }
                //if (key == 'a') { stringA.pluck(); }
                //if (key == 'c') { stringC.pluck(); }

            }

            // compute the superposition of all the samples
            //double sample = stringA.sample() + stringC.sample();
            double sample = 0.0;
            for(GuitarString s : strings)
            	sample += s.sample();
            //System.out.println(sample);
            // send the result to standard audio
            StdAudio.play(sample);
            
            // advance the simulation of each guitar string by one step
            //stringA.tic();
            //stringC.tic();
            for(GuitarString s : strings)
            {
            	s.tic();
            }
        }
    }

}