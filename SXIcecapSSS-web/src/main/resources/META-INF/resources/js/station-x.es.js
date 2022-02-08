
class StationX {
	constructor( namespace ){
		this.namespace = namespace;
	}

	get namespace(){
		return this.namespace;
	}

	set namespace( namespace ){
		this.namespace = ns;
	}
}

class SXIcecap extends StationX {
	constructor( namespace ){
		super( namespace );
	}
}

class SXIcecapSSS extends SXIcecap{
	constructor( namespace ){
		super( namespace );

		this.TermTypes = new SXIceacpSSSTermTypes();
		this.termAttributes = new SXIceacpSSSTermAttributes();
	}
}

class SXIceacpSSSTermTypes{
	constructor(){
		this.STRING = 'String',
		this.NUMERIC = 'Numeric',
		this.BOOLEAN = 'Boolean',
		this.LIST = 'List',
		this.LIST_ARRAY = 'ListArray',
		this.MATRIX = 'Matrix',
		this.FILE = 'File',
		this.FILE_ARRAY = 'FileArray',
		this.OBJECT = 'Object',
		this.OBJECT_ARRAY = 'ObjectArray',
		this.ARRAY = 'Array',
		this.DATA_LINK = 'DataLink',
		this.DATA_LINK_ARRAY = 'DataLinkArray',
		this.DATE = 'Date',
		this.PHONE = 'Phone',
		this.EMAIL = 'EMail',
		this.GROUP = 'Group',
		this.COMMENT = 'Comment';
	}

	get TERM_TYPES(){
		return [ 
			this.STRING,
			this.NUMERIC,
			this.BOOLEAN,
			this.LIST,
			this.LIST_ARRAY,
			this.MATRIX,
			this.FILE,
			this.FILE_ARRAY,
			this.OBJECT,
			this.OBJECT_ARRAY,
			this.ARRAY,
			this.DATA_LINK,
			this.DATA_LINK_ARRAY,
			this.DATE,
			this.PHONE,
			this.EMAIL,
			this.GROUP,
			this.COMMENT
		]
	}
}

class SXIceacpSSSTermAttributes{
	constructor(){
		this.ACTIVE = 'active',
		this.AVAILABLE_LANGUAGE_IDS = 'availableLanguageIds',
		this.COUNTRY_CODE = 'countryCode',
		this.DATATYPE_NAME = 'dataTypeName',
		this.DATATYPE_VERSION = 'dataTypeVersion',
		this.DEFINITION = 'definition',
		this.DEFAULT_LANGUAGE_ID = 'defaultLanguageId',
		this.DEFAULT_LOCALE = 'defaultLocale',
		this.DEPENDENT_TERMS = 'dependentTerms',
		this.DIMENSION_X = 'dimensionX',
		this.DIMENSION_Y = 'dimensionY',
		this.DISABLED = 'disabled',
		this.DISPLAY_NAME = 'displayName',
		this.DISPLAY_STYLE = 'displayStyle',
		this.ELEMENT_TYPE = 'elementType',
		this.FILE_ID = 'fileId',
		this.FORMAT = 'format',
		this.ID = 'id',
		this.LIST_ITEM = 'listItem',
		this.LIST_ITEM_VALUE = 'listItemValue',
		this.LIST_ITEMS = 'listItems',
		this.LOWER_BOUNDARY = 'lowerBoundary',
		this.LOWER_OPERAND = 'lowerOperand',
		this.MANDATORY = 'mandatory',
		this.NAME = 'name',
		this.MAX_LENGTH ="maxLength_",
		this.MAX_VALUE ="maxValue_",
		this.MIN_LENGTH ="minLength_",
		this.MIN_VALUE ="minValue_",
		this.NAME_TEXT = 'nameText',
		this.NEW_LINE ="newLine_",
		this.OPERAND = 'operand',
		this.ORDER = 'order',
		this.PATH = 'path',
		this.PATH_TYPE = 'pathType',
		this.RANGE = 'range',
		this.REF_DATATYPES = 'refDataTypes',
		this.REF_DATABASES = 'refDatabases',
		this.SWEEPABLE = 'sweepable',
		this.SYNONYMS = 'synonyms',
		this.TERM_NAME = 'termName',
		this.TEXT = 'text',
		this.TOOLTIP = 'tooltip',
		this.TTYPE = 'type',
		this.UNCERTAINTY = 'uncertainty',
		this.UNCERTAINTY_VALUE = 'uncertaintyValue',
		this.UNIT = 'unit',
		this.UPPER_BOUNDARY = 'upperBoundary',
		this.UPPER_OPERAND = 'upperOperand',
		this.URI = 'uri',
		this.URI_TYPE = 'uriType',
		this.URL = 'url',
		this.VALIDATION_RULE  = 'validationRule',
		this.VALUE = 'value',
		this.VALUE_DELIMITER = 'valueDelimiter',
		this.VERSION = 'version';
	}
}