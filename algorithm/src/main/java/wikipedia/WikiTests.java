package wikipedia;

public class WikiTests
{
    public static void main(String[] args) throws Exception
    {
    	Wiki wiki = new Wiki("en.wikipedia.org");
    	wiki.setMaxLag(-1);
    	
    	String page = wiki.getNSentInPage("Kong Dan",1);
    	System.out.println(page);
    	String[] titles = wiki.whatTranscludesHere("Template:Infobox food", Wiki.MAIN_NAMESPACE);
    	
    	for(String str : titles) {
    		//System.out.println(str);
    	}
    }
}
