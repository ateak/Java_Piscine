package edu.day02.ex00;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileSignature {

    private static final String SIGNATURES = "signatures.txt";

    public static void main(String[] args){
        try {
            SignatureParser signatureParser = new SignatureParser();
            Map<String, String> signatures = signatureParser.retrieveSignatures(new File(SIGNATURES));
            signatureParser.retrieveFiles(signatures);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}