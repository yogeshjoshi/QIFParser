package com.github.qifparser.parser;

import java.util.ArrayList;
import java.util.List;

public class Transaction implements TransactionInterface{

    private int count = 0;
    private List<Character> identifiers = new ArrayList<>();
    private List<String> values =  new ArrayList<>();
    private static final String EMPTY_STRING = "";
    
    private String get(char identifier) {
        for (int i = 0; i < count; i++) {
            if (identifiers.get(i) == identifier) {
                return values.get(i);
            }
        }
        return EMPTY_STRING;
    }
     
	@Override
	public String getDate() {
		  return get('D');
	}

	@Override
	public String getAmount() {
        String amount = get('T');
        return (amount.length() > 0) ? amount : get('U');
	}

	@Override
	public String getCleared() {
        return get('C');
	}

	@Override
	public String getNumber() {
	       return get('N');
	}

	@Override
	public String getDescription() {
        String desc = get('P');
        return (desc.length() > 0) ? desc : get('M');
	}

	@Override
	public String getCategory() {
	      return get('L');
	}
	
	/**
     * Returns the number of lines in the entry.
     */
    public int getNumberOfLines() {
        return identifiers.size();
    }

    /**
     * Returns the identifier at the specified index.
     */
    public char getIdentifier(int index) {
        return identifiers.get(index);
    }
    /**
     * Returns the value at the specified index.
     */
    public String getValue(int index) {
        return values.get(index);
    }
    
    /**
     * Returns the string representation of the entry.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(identifiers.get(i));
            stringBuilder.append("=\"");
            stringBuilder.append(values.get(i));
            stringBuilder.append("\"");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    /**
     * Adds a line to the entry.
     */
    public void addLine(char identifier, String value) {
        identifiers.add(identifier);
        values.add(value);
    }


	
}
