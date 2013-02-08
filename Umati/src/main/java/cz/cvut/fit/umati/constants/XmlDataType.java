/**
 * 
 */
package cz.cvut.fit.umati.constants;

/**
 * @author davy
 *
 */
public enum XmlDataType {
	AnyURI("URI (Uniform Resource Identifier)"),
	Base64Binary("Binary content coded as \"base64\""),
	Boolean("Boolean (true or false)"),
	Byte("Signed value of 8 bits"),
	date("Gregorian calendar date"),
	dateTime("Instant of time (Gregorian calendar)"),
	decimal("Decimal numbers"),
	Double("IEEE 64-bit floating-point"),
	duration("Time durations"),
	ENTITIES("Whitespace-separated list of unparsed entity references"),
	ENTITY("Reference to an unparsed entity"),
	Float("IEEE 32-bit floating-point"),
	gDay("Recurring period of time: monthly day"),
	gMonth("Recurring period of time: yearly month"),
	gMonthDay("Recurring period of time: yearly day"),
	gYear("Period of one year"),
	gYearMonth("Period of one month"),
	hexBinary("Binary contents coded in hexadecimal"),
	ID("Definition of unique identifiers"),
	IDREF("Definition of references to unique identifiers"),
	IDREFS("Definition of lists of references to unique identifiers"),
	Int("32-bit signed integers"),
	integer("Signed integers of arbitrary length"),
	language("RFC 1766 language codes"),
	Long("64-bit signed integers"),
	Name("XML 1.O name"),
	NCName("Unqualified names"),
	negativeInteger("Strictly negative integers of arbitrary length"),
	NMTOKEN("XML 1.0 name token (NMTOKEN)"),
	NMTOKENS("List of XML 1.0 name tokens (NMTOKEN)"),
	nonNegativeInteger("Integers of arbitrary length positive or equal to zero"),
	nonPositiveInteger("Integers of arbitrary length negative or equal to zero"),
	normalizedString("Whitespace-replaced strings"),
	NOTATION("Emulation of the XML 1.0 feature"),
	positiveInteger("Strictly positive integers of arbitrary length"),
	QName("Namespaces in XML-qualified names"),
	Short("32-bit signed integers"),
	string("Any string"),
	time("Point in time recurring each day"),
	token("Whitespace-replaced and collapsed strings"),
	unsignedByte("Unsigned value of 8 bits"),
	unsignedInt("Unsigned integer of 32 bits"),
	unsignedLong("Unsigned integer of 64 bits"),
	unsignedShort("Unsigned integer of 16 bits");
	
	private final String description;

	private XmlDataType(String description) {
		this.description = description;
	}

	/*
	 * Getters
	 */
	public String getDescription() {
		return description;
	}

	public String getCombinedDescription() {
		return toString() + description;
	}
}
