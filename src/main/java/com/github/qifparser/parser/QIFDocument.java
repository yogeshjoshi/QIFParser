package com.github.qifparser.parser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QIFDocument implements QIFDocumentInterface {
	
    /**
     * Creates a QIF document from the specified input stream.
     */
	private String accountType;
	
	private List<Transaction> entries = new ArrayList<>();
	
	public QIFDocument(InputStream in) throws java.io.IOException {
        parse(in);
    }
	private void parse(InputStream in) throws java.io.IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        Transaction entry = new Transaction();
        boolean accountTypeReaceived = false;
        while((line=reader.readLine()) != null){
        	if(!accountTypeReaceived){
        		accountType = line;
        		accountTypeReaceived = true;
        		continue;
        	}
            if (line.trim().length() == 0)
                continue;
            char identifier = line.charAt(0);
            if (identifier == '^') {
                entries.add(entry);
                entry = new Transaction();
                continue;
            }
            String value = line.substring(1).trim();
            entry.addLine(identifier, value);    
        }
        
    }
	
    /**
     * Returns the account type. It is the same as the first line of
     * the QIF file.
     */
    public String getAccountType() {
        return accountType.substring(1);
    }
    
    /**
     * Returns the number of QIF entries (transactions) in the QIF (Quicken Interchange Format)
     * document.
     */
	@Override
	public int getNumberOfEntries() {
        return entries.size();
	}
	  /**
     * Returns the number of QIF entries (transactions) in the QIF
     * document.
     */
	@Override
	public TransactionInterface getEntry(int index) {
        return entries.get(index);
	}
	
	/**
     * Returns the string representation of the document.Used When you need all document as String Format
     */
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("{type=\"");
        buf.append(accountType);
        buf.append("\", [");
        int size = entries.size();
        for (int i = 0; i < size; i++) {
            buf.append(entries.get(i).toString());
        }
        buf.append("]}");
        return buf.toString();
    }

}
