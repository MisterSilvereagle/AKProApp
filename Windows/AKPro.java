package net.raupi;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TabFolder;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.browser.Browser;

public class AKPro {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlAkproDownload = new Shell();
		shlAkproDownload.setImage(SWTResourceManager.getImage(AKPro.class, "/net/raupi/AK_Pro_Bubbles_45_cut.png"));
		shlAkproDownload.setSize(790, 514);
		shlAkproDownload.setText("AKPro Download");
		shlAkproDownload.setLayout(new FormLayout());
		
		TabFolder tabFolder = new TabFolder(shlAkproDownload, SWT.NONE);
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.bottom = new FormAttachment(100, -10);
		fd_tabFolder.right = new FormAttachment(100, -10);
		fd_tabFolder.top = new FormAttachment(0, 10);
		fd_tabFolder.left = new FormAttachment(0, 10);
		tabFolder.setLayoutData(fd_tabFolder);
		
		TabItem tbtmNews = new TabItem(tabFolder, SWT.NONE);
		tbtmNews.setImage(SWTResourceManager.getImage(AKPro.class, "/net/raupi/AK_Pro_Bubbles_16_cut.png"));
		tbtmNews.setText("News");
		
		Browser browser = new Browser(tabFolder, SWT.NONE);
		tbtmNews.setControl(browser);
		browser.setUrl("http://raupi.net/news/");
		
		TabItem tbtmAnfnger = new TabItem(tabFolder, SWT.NONE);
		tbtmAnfnger.setText("Anf\u00E4nger");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmAnfnger.setControl(composite);
		composite.setLayout(new FormLayout());
		
		IDEContainer container = new IDEContainer(composite, SWT.NONE, SWTResourceManager.getImage(AKPro.class, "/net/raupi/scratch.png"), "Perfekt für Anfänger. Probier es mal aus.", "Scratch starten", new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					Desktop.getDesktop().browse(new URL("https://scratch.mit.edu/projects/editor/?tutorial=getStarted").toURI());
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		FormData fd_container = new FormData();
		fd_container.top = new FormAttachment(0, 10);
		fd_container.left = new FormAttachment(0, 10);
		fd_container.right = new FormAttachment(0, 410);
		container.setLayoutData(fd_container);
		
		TabItem tbtmFortgeschrittene = new TabItem(tabFolder, SWT.NONE);
		tbtmFortgeschrittene.setText("Fortgeschrittene");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmFortgeschrittene.setControl(composite_1);
		composite_1.setLayout(new FormLayout());
		
		Label lblFeatureInEntwicklung = new Label(composite_1, SWT.NONE);
		FormData fd_lblFeatureInEntwicklung = new FormData();
		fd_lblFeatureInEntwicklung.top = new FormAttachment(0, 10);
		fd_lblFeatureInEntwicklung.left = new FormAttachment(0, 10);
		lblFeatureInEntwicklung.setLayoutData(fd_lblFeatureInEntwicklung);
		lblFeatureInEntwicklung.setText("Feature in Entwicklung.");
		
		TabItem tbtmErfahrene = new TabItem(tabFolder, SWT.NONE);
		tbtmErfahrene.setText("Erfahrene");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmErfahrene.setControl(composite_2);
		composite_2.setLayout(new FormLayout());
		
		IDEContainer container_1 = new IDEContainer(composite_2, SWT.NONE, SWTResourceManager.getImage(AKPro.class, "/net/raupi/Codeblocks_logo.png"), "Open Source C/C++ IDE", "Code::Blocks installieren.", new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				net.raupi.Browser.open("http://www.codeblocks.org/downloads/26");
				
			}
			
		});
		FormData fd_container_1 = new FormData();
		fd_container_1.top = new FormAttachment(0, 10);
		fd_container_1.left = new FormAttachment(0, 10);
		container_1.setLayoutData(fd_container_1);
		Rectangle bounds = shlAkproDownload.getBounds();
		Rectangle dbounds = Display.getDefault().getBounds();
		shlAkproDownload.setBounds((dbounds.width-bounds.width)/2, (dbounds.height-bounds.height)/2, bounds.width, bounds.height);
		shlAkproDownload.open();
		shlAkproDownload.layout();
		while (!shlAkproDownload.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
