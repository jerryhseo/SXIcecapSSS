package com.sx.icecap.sss.constants;

public class IcecapSSSTermAttributes {
	public static final String ACTIVE_TERMS = "activeTerms";
	public static final String COUNTRY_CODE = "countryCode";
	public static final String DATA_TYPE_NAME = "dataTypeName";
	public static final String DATA_TYPE_VERSION = "dataTypeVersion";
	public static final String DEFINITION = "definition";
	public static final String DEPENDENT_TERMS = "dependentTerms";
	public static final String DIMENSION_X = "dimensionX";
	public static final String DIMENSION_Y = "dimensionY";
	public static final String DISPLAY_FORMAT = "displayFormat";
	public static final String DISPLAY_NAME = "displayName";
	public static final String DISPLAY_STYLE = "displayStyle";
	public static final String ELEMENT_TYPE = "elementType";
	public static final String LABEL = "label";
	public static final String LIST_ITEMS = "listItems";
	public static final String MAX_BOUNDARY = "maxBoundary";
	public static final String MAX_LENGTH = "maxLength";
	public static final String MAX_VALUE = "maxValue";
	public static final String MIN_BOUNDARY = "minBoundary";
	public static final String MIN_LENGTH = "minLength";
	public static final String MIN_VALUE = "minValue";
	public static final String MULTI_LINE = "multiLine";
	public static final String OPTIONS = "options";
	public static final String OPTION_LABEL = "optionLabel";
	public static final String OPTION_VALUE = "optionValue";
	public static final String OPTION_SELECTED = "optionSelected";
	public static final String OPTION_ACTIVE_TERMS = "optionActiveTerms";
	public static final String PARAMETERS = "parameters";
	public static final String PLACE_HOLDER = "placeHolder";
	public static final String REF_DATABASES = "refDatabases";
	public static final String REF_DATABASE = "refDatabase";
	public static final String REF_DATABASE_VERSION = "refDatabaseVersion";
	public static final String REF_DATATYPES = "refDataTypes";
	public static final String SELECTED = "selected";
	public static final String STANDARDIZED = "standardized";
	public static final String STATE = "state";
	public static final String STATUS = "status";
	public static final String SYNONYMS = "synonyms";
	public static final String SWEEPABLE = "sweepable";
	public static final String TERM_NAME = "termName";
	public static final String TERM_TYPE = "termType";
	public static final String TERM_VERSION = "termVersion";
	public static final String TOOLTIP = "tooltip";
	public static final String VALUE = "value";
	public static final String UNCERTAINTY = "uncertainty";
	public static final String UNCERTAINTY_VALUE = "uncertaintyValue";
	public static final String UNIT = "unit";
	public static final String URL_TYPE = "urlType";
	public static final String VALIDATION_RULE = "validationRule";
	
	public static String toJsonAttr( final String attr) {
		return attr + "_";
	}
}
