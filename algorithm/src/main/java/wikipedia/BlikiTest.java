package wikipedia;

import info.bliki.api.Connector;
import info.bliki.api.Page;
import info.bliki.api.PageInfo;
import info.bliki.api.User;
import info.bliki.api.XMLCategoryMembersParser;
import info.bliki.wiki.model.WikiModel;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;

public class BlikiTest {
  
    public static void testQueryCategoryMembers() {
    	String[] listOfTitleStrings = { "Web service" };
    	User user = new User("", "", "http://en.wikipedia.org/w/api.php");
    	user.login();
    	List<Page> listOfPages = user.queryContent(listOfTitleStrings);
    	for (Page page : listOfPages) {
    	  WikiModel wikiModel = new WikiModel("${image}", "${title}");
    	  String html = wikiModel.render(page.toString());
    	  System.out.println(page.toString());
    	}
    }

    public static void testQueryCategoryMembersPages() {
        User user = new User("", "", "http://en.wikipedia.org/w/api.php");
        user.login();
        String[] valuePairs = { "list", "categorymembers", "cmtitle", "Category:Design companies" };
        String[] valuePairsContinue = new String[6];
        String cmContinue = "||";
        for (int i = 0; i < valuePairs.length; i++) {
            valuePairsContinue[i] = valuePairs[i];
        }
        valuePairsContinue[4] = "cmcontinue";
        valuePairsContinue[5] = "";
        Connector connector = new Connector();
        List<PageInfo> resultCategoryMembers = new ArrayList<PageInfo>(1024);
        XMLCategoryMembersParser parser;
        try {
            // get all categorymembers
            String responseBody = connector.queryXML(user, valuePairs);
            while (responseBody != null) {
                parser = new XMLCategoryMembersParser(responseBody);
                parser.parse();
                cmContinue = parser.getCmContinue();
                System.out.println(">>>>> " + cmContinue);
                List<PageInfo> listOfPages = parser.getPagesList();
                resultCategoryMembers.addAll(listOfPages);
                for (PageInfo categoryMember : listOfPages) {
                    // print page information
                    System.out.println(categoryMember.toString());
                }
                if (cmContinue.length() > 0) {
                    // use the cmcontinue from the last query to get the next block of
                    // category members
                    valuePairsContinue[5] = cmContinue;
                    responseBody = connector.queryXML(user, valuePairsContinue);
                } else {
                    break;
                }
            }
            // get the content of the category members with namespace==0
            int count = 0;
            List<String> strList = new ArrayList<String>();
            for (PageInfo categoryMember : resultCategoryMembers) {
                if (categoryMember.getNs().equals("0")) {
                    // namespace "0" - all titles without a namespace prefix
                    strList.add(categoryMember.getTitle());
                    if (++count == 10) {
                        List<Page> listOfPages = user.queryContent(strList);
                        for (Page page : listOfPages) {
                            // System.out.println(page.getTitle());
                            // print the raw content of the wiki page:
                            System.out.println(page.getCurrentContent());
                        }
                        count = 0;
                        strList = new ArrayList<String>();
                    }
                }
            }
            if (count != 0) {
                List<Page> listOfPages = user.queryContent(strList);
                for (Page page : listOfPages) {
                    // System.out.println(page.getTitle());
                    // print the raw content of the wiki page:
                    System.out.println(page.getCurrentContent());
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    public static void main(String[] args) {
       // testQueryCategoryMembers();
        
        testQueryCategoryMembersPages();
    }
}