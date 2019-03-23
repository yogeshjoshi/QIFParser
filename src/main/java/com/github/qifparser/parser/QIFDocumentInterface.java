package com.github.qifparser.parser;

/**
 * 
 * Provides interface to a QIF (Quicken Interchange Format)
 * document. A QIF document consists of a list of entries. Each entry
 * represents a transaction for a user's account.
 * @see TransactionInterface
 * 
 * for more information regarding QIF - https://en.wikipedia.org/wiki/Quicken_Interchange_Format
 */
public interface QIFDocumentInterface {
	
	 /**
	  * Returns the number of entries (transactions) in the QIF document.
	  */
	  public int getNumberOfEntries();
	  
	  /**
	   * Returns the entry (transaction) at the specified index.
	   */
	  public TransactionInterface getEntry(int index);

}
