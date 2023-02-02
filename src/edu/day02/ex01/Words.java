package edu.day02.ex01;

import java.io.*;
import java.util.*;

public class Words {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println("Not enough arguments");
            System.exit(1);
        }
        List<String> wordsList1;
        List<String> wordsList2;
        Set<String> dictionary;
        double similarity;

        try {
            wordsList1 = retrieveWordsFromFile(args[0]);
            wordsList2 = retrieveWordsFromFile(args[1]);
            dictionary = retrieveDictionaryFromLists(wordsList1, wordsList2);
            writeDictionaryToFile(dictionary);
            similarity = calculateSimilarity(wordsList1, wordsList2, dictionary);
            printSimilarity(similarity);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static List<String> retrieveWordsFromFile(String fileName) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        List<String> wordsList = new ArrayList<>();
        String line;
        String[] words;
        int j;

        while ((line = file.readLine()) != null) {
            words = line.split("\\s");
            j = 0;
            while (j < words.length) {
                wordsList.add(words[j]);
                j++;
            }
        }
        file.close();
        return wordsList;
    }

    private static Set<String> retrieveDictionaryFromLists(List<String> wordsList1, List<String> wordsList2) {
        TreeSet<String> dictionary= new TreeSet<>();
        if (wordsList1 != null) {
            dictionary.addAll(wordsList1);
        }
        if (wordsList2 != null) {
            dictionary.addAll(wordsList2);
        }

        return dictionary;
    }

    private static void writeDictionaryToFile(Set<String> dictionarySet) throws IOException {
        BufferedWriter outFile = new BufferedWriter(new FileWriter("dictionary.txt"));

        for (String words : dictionarySet) {
            outFile.write(words + " ");
        }
        outFile.close();
    }

    private static double calculateSimilarity(List<String> words1, List<String> words2, Set<String> dictionary) {
        try {
            int[] entryWords1 = retrieveWordsEntry(dictionary, words1);
            int[] entryWords2 = retrieveWordsEntry(dictionary, words2);
            double numerator = calculateNumerator(entryWords1, entryWords2, dictionary.size());
            double denominator = calculateDenominator(entryWords1, entryWords2, dictionary.size());
            return numerator / denominator;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    private static int[] retrieveWordsEntry(Set<String> dictionary, List<String> words) throws NullPointerException {
        int count;
        int i = 0;
        int[] entryWords = new int[dictionary.size()];

        for (String wordInDictionary : dictionary) {
            count = 0;
            for (String wordInList : words) {
                if (wordInList.equals(wordInDictionary)) {
                    count++;
                }
            }
            entryWords[i] = count;
            i++;
        }
        return entryWords;
    }

    private static int calculateNumerator(int[] entryWords1, int[] entryWords2, int size) {
        int returnNumerator = 0;

        for (int i = 0; i < size; i++) {
            returnNumerator += entryWords1[i] * entryWords2[i];
        }
        return returnNumerator;
    }

    private static double calculateDenominator(int[] entryWords1, int[] entryWords2, int size) {
        int sqrt1 = 0;
        int sqrt2 = 0;

        for (int i = 0; i < size; i++) {
            sqrt1 += entryWords1[i] * entryWords1[i];
            sqrt2 += entryWords2[i] * entryWords2[i];
        }
        return Math.sqrt(sqrt1) * Math.sqrt(sqrt2);
    }

    private static void printSimilarity (Double similarity) {
        if (similarity.isNaN()) {
            System.out.printf("Similarity = %.2f", 0f);
        } else {
            System.out.printf("Similarity = %.2f", similarity);
        }
    }
}