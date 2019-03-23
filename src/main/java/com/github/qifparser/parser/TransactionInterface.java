package com.github.qifparser.parser;


/**
 * Provides interface to a QIF (Quicken Interchange Format)
 * entry. Each entry represents a transaction for a user's
 * account. The methods of this interface return an empty string if
 * that field cannot be found in the entry. The methods never return null.
 *
 * @see QIFDocumentInterface
 * 
 * for more information regarding QIF - https://en.wikipedia.org/wiki/Quicken_Interchange_Format
 */
public interface TransactionInterface {
    /**
     * Returns the date of the transaction in as mentioned in QIF Documents's format.
     */
    public String getDate();

    /**
     * Returns the amount of the transaction.
     */
    public String getAmount();

    /**
     * Returns the cleared status.
     */
    public String getCleared();

    /**
     * Returns the check/reference number of the transaction.
     */
    public String getNumber();

    /**
     * Returns the description of the transaction.
     */
    public String getDescription();

    /**
     * Returns the category of the transaction.
     */
    public String getCategory();

}
