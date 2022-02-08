package com.sx.icecap.sss.search;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.sx.icecap.sss.constants.IcecapSSSTermAttributes;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.sss.model.Term",
        service = KeywordQueryContributor.class
)
public class TermKeywordContributor implements KeywordQueryContributor {
	
	@Reference
	protected QueryHelper queryHelper;

	@Override
	public void contribute(String keywords, BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {
//		System.out.println("TermKeywordContributor: contribute");
		
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchTerm(booleanQuery, searchContext, IcecapSSSTermAttributes.TERM_NAME, true);
		queryHelper.addSearchLocalizedTerm( booleanQuery, searchContext, IcecapSSSTermAttributes.DISPLAY_NAME, false);
		queryHelper.addSearchLocalizedTerm( booleanQuery, searchContext, IcecapSSSTermAttributes.DEFINITION, false);
		queryHelper.addSearchTerm( booleanQuery, searchContext, IcecapSSSTermAttributes.SYNONYMS, false);
		queryHelper.addSearchTerm( booleanQuery, searchContext, IcecapSSSTermAttributes.STATUS, false);
		queryHelper.addSearchTerm( booleanQuery, searchContext, Field.MODIFIED_DATE, false);
  
	}

}
