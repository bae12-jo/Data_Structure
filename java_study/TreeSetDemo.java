// https://www.youtube.com/watch?v=MbUzYzxjZmk

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetDemo{
	public static void main(String[] args){
		String phrase = "the quick brown fox jumps over the lazy dog";
		String[] phraseList = phrase.split(" ");
		
		TreeSet<String> words = new TreeSet<>();
		words.addAll(Arrays.asList(phraseList));
		
		for (String w: words){
			System.out.println(w);
		}
	}
}

/*
1. TreeSet puts items inorder
2. TreeSet puts items in alphabet order
*/
