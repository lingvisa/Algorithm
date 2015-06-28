package wikipedia;

import de.tudarmstadt.ukp.wikipedia.api.DatabaseConfiguration;
import de.tudarmstadt.ukp.wikipedia.api.Page;
import de.tudarmstadt.ukp.wikipedia.api.WikiConstants.Language;
import de.tudarmstadt.ukp.wikipedia.api.Wikipedia;
import de.tudarmstadt.ukp.wikipedia.api.exception.WikiApiException;

public class JWPLTest {

	public static void main(String[] args) throws WikiApiException {

		
		DatabaseConfiguration dbConfig = new DatabaseConfiguration();
		dbConfig.setHost("localhost");
		dbConfig.setDatabase("wikipedia");
		dbConfig.setUser("bword");
		dbConfig.setPassword("bword");
		dbConfig.setLanguage(Language.english);

		// Create the Wikipedia object
		Wikipedia wiki = new Wikipedia(dbConfig);

		String title = "Albert Einstein";
		Page page = wiki.getPage(title);

		// the title of the page
		System.out.println("Queried string       : " + title);
		System.out.println("Title                : " + page.getTitle());

		
		// whether the page is a disambiguation page
		System.out.println("IsDisambiguationPage : " + page.isDisambiguation());

		// whether the page is a redirect
		// If a page is a redirect, we can use it like a normal page.
		// The other infos in this example are transparently served by the page that the redirect points to. 
		System.out.println("redirect page query  : " + page.isRedirect());

		// the number of links pointing to this page
		System.out.println("# of ingoing links   : " + page.getNumberOfInlinks());

		// the number of links in this page pointing to other pages
		System.out.println("# of outgoing links  : " + page.getNumberOfOutlinks());

		// the number of categories that are assigned to this page
		System.out.println("# of categories      : " + page.getNumberOfCategories());

		// the number of categories that are assigned to this page
		System.out.println("\n\nArticle from here\n      : " + page.getPlainText());
	}
}
