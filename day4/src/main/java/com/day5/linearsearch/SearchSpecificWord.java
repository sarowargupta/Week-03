package com.day5.linearsearch;

public class SearchSpecificWord {
        //method to find specific word in a list of sentence
        public static String findSentenceWithWord(String[] sentences, String word) {
            for (String sentence : sentences) {
                if (sentence.toLowerCase().contains(word.toLowerCase())) {

                    // Return the first sentence containing the word
                    return sentence;
                }
            }
            // Return "Not Found" if the word is not in any sentence
            return "Not Found";
        }

        public static void main(String[] args) {
            //Array of sentence
            String[] sentences ={"Hello everyone.",
                                 "Welcome to the world of programming.",
                                  "As we no know that java is programming language.",
                                  "There are four pillar in oops."};

            //create a scanner object
            String word = "java";

            //call the method linear search for the word in the list of sentences
            String result = findSentenceWithWord(sentences,word);

            //print the result
            System.out.println(result);
        }

}
