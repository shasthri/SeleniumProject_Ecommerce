package base;

import pages.PageObjectManager;

public class PicoTestContainer 
{
	//Plan Old Java Object
	private BrowserFactory browserFactory;
	private PageObjectManager pageObjectManager;
	
	public PicoTestContainer()
	{
		browserFactory = new BrowserFactory();
		pageObjectManager = new PageObjectManager(browserFactory.launchBrowser());	
	}
	
	public BrowserFactory getBrowserfactory()
	{
		return browserFactory;
	}
	
	public PageObjectManager getPageObjectManager()
	{
		return pageObjectManager;
	}
	

}
