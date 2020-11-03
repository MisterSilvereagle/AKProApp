package net.raupi;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;

public class Browser extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Create the shell.
	 * @param display
	 */
	
	public static void setTitle(String s) {
		
		setTitle(s);
		
	}
	
	public Browser(Display display, String url) {
		super(display, SWT.CLOSE | SWT.MAX | SWT.RESIZE | SWT.TITLE);
		setImage(SWTResourceManager.getImage(Browser.class, "/net/raupi/AK_Pro_Bubbles_16_cut.png"));
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		org.eclipse.swt.browser.Browser browser = new org.eclipse.swt.browser.Browser(this, SWT.WEBKIT);
		browser.setJavascriptEnabled(true);
		browser.setUrl(url);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Webbrowser (AKPro)");
		setSize(803, 513);

	}
	
	public static void open(String url) {
		try {
			Display display = Display.getDefault();
			Browser shell = new Browser(display, url);
			Rectangle bounds = shell.getBounds();
			Rectangle dbounds = Display.getDefault().getBounds();
			shell.setBounds((dbounds.width-bounds.width)/2, (dbounds.height-bounds.height)/2, bounds.width, bounds.height);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
