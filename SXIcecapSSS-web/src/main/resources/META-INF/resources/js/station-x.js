(function (root, factory) {
    if (typeof Liferay.Loader.define === 'function' && Liferay.Loader.define.amd) {
        Liferay.Loader.define('StationX', [], factory);
    } else if (typeof module === 'object' && module.exports) {
        module.exports = factory();
    } else {
        root.StationX = factory();
  }
}(this, function () {

	class StationX {
		constructor( namespace ){
			this.namespace = namespace;
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

		}
	}

	class SXIceacpSSSTermTypes{
		static STRING = 'String';
		static NUMERIC = 'Numeric';
		static BOOLEAN = 'Boolean';
		static LIST = 'List';
		static LIST_ARRAY = 'ListArray';
		static MATRIX = 'Matrix';
		static FILE = 'File';
		static FILE_ARRAY = 'FileArray';
		static OBJECT = 'Object';
		static OBJECT_ARRAY = 'ObjectArray';
		static ARRAY = 'Array';
		static DATA_LINK = 'DataLink';
		static DATA_LINK_ARRAY = 'DataLinkArray';
		static DATE = 'Date';
		static PHONE = 'Phone';
		static EMAIL = 'EMail';
		static GROUP = 'Group';
		static COMMENT = 'Comment';
		
		constructor(){
		}
		

		static TERM_TYPES(){
			return [ 
				SXIceacpSSSTermTypes.STRING,
				SXIceacpSSSTermTypes.NUMERIC,
				SXIceacpSSSTermTypes.BOOLEAN,
				SXIceacpSSSTermTypes.LIST,
				SXIceacpSSSTermTypes.LIST_ARRAY,
				SXIceacpSSSTermTypes.MATRIX,
				SXIceacpSSSTermTypes.FILE,
				SXIceacpSSSTermTypes.FILE_ARRAY,
				SXIceacpSSSTermTypes.OBJECT,
				SXIceacpSSSTermTypes.OBJECT_ARRAY,
				SXIceacpSSSTermTypes.ARRAY,
				SXIceacpSSSTermTypes.DATA_LINK,
				SXIceacpSSSTermTypes.DATA_LINK_ARRAY,
				SXIceacpSSSTermTypes.DATE,
				SXIceacpSSSTermTypes.PHONE,
				SXIceacpSSSTermTypes.EMAIL,
				SXIceacpSSSTermTypes.GROUP,
				SXIceacpSSSTermTypes.COMMENT
			]
		}
	}

	class SXIceacpSSSTermAttributes{
		constructor(){
		}
		
		static.ACTIVE = 'active';
		static.AVAILABLE_LANGUAGE_IDS = 'availableLanguageIds';
		static.COUNTRY_CODE = 'countryCode';
		static.DATATYPE_NAME = 'dataTypeName';
		static.DATATYPE_VERSION = 'dataTypeVersion';
		static.DEFINITION = 'definition';
		static.DEFAULT_LANGUAGE_ID = 'defaultLanguageId';
		static.DEFAULT_LOCALE = 'defaultLocale';
		static.DEPENDENT_TERMS = 'dependentTerms';
		static.DIMENSION_X = 'dimensionX';
		static.DIMENSION_Y = 'dimensionY';
		static.DISABLED = 'disabled';
		static.DISPLAY_NAME = 'displayName';
		static.DISPLAY_STYLE = 'displayStyle';
		static.ELEMENT_TYPE = 'elementType';
		static.FILE_ID = 'fileId';
		static.FORMAT = 'format';
		static.ID = 'id';
		static.LIST_ITEM = 'listItem';
		static.LIST_ITEM_VALUE = 'listItemValue';
		static.LIST_ITEMS = 'listItems';
		static.LOWER_BOUNDARY = 'lowerBoundary';
		static.LOWER_OPERAND = 'lowerOperand';
		static.MANDATORY = 'mandatory';
		static.NAME = 'name';
		static.MAX_LENGTH ="maxLength_";
		static.MAX_VALUE ="maxValue_";
		static.MIN_LENGTH ="minLength_";
		static.MIN_VALUE ="minValue_";
		static.NAME_TEXT = 'nameText';
		static.NEW_LINE ="newLine_";
		static.OPERAND = 'operand';
		static.ORDER = 'order';
		static.PATH = 'path';
		static.PATH_TYPE = 'pathType';
		static.RANGE = 'range';
		static.REF_DATATYPES = 'refDataTypes';
		static.REF_DATABASES = 'refDatabases';
		static.SWEEPABLE = 'sweepable';
		static.SYNONYMS = 'synonyms';
		static.TERM_NAME = 'termName';
		static.TEXT = 'text';
		static.TOOLTIP = 'tooltip';
		static.TTYPE = 'type';
		static.UNCERTAINTY = 'uncertainty';
		static.UNCERTAINTY_VALUE = 'uncertaintyValue';
		static.UNIT = 'unit';
		static.UPPER_BOUNDARY = 'upperBoundary';
		static.UPPER_OPERAND = 'upperOperand';
		static.URI = 'uri';
		static.URI_TYPE = 'uriType';
		static.URL = 'url';
		static.VALIDATION_RULE  = 'validationRule';
		static.VALUE = 'value';
		static.VALUE_DELIMITER = 'valueDelimiter';
		static.VERSION = 'version';

	}

	class SSSTerm {
		constructor( ns ){
			this.namespace = ns;
		}
		
	}

	
    return {
    	
    };
}));


