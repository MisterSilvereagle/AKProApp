package net.raupi;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.ProgressBar;

public class AKProUpdater {

	protected Shell shlAkproUpdater;
	private String version;
	private String version_n;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AKProUpdater window = new AKProUpdater();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAkproUpdater.setBounds((Display.getDefault().getBounds().width-shlAkproUpdater.getBounds().width)/2, (Display.getDefault().getBounds().height-shlAkproUpdater.getBounds().height)/2, shlAkproUpdater.getBounds().width, shlAkproUpdater.getBounds().height);
		shlAkproUpdater.open();
		shlAkproUpdater.layout();
		
		update();
		
		while (!shlAkproUpdater.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void update() {
		
		File ver = new File(System.getProperty("user.dir") + File.separator + "VersionInfo.dat");
		
		try {
			
			BufferedReader bfr = new BufferedReader(new FileReader(ver));
			
			ArrayList<String> br = new ArrayList<String>();
			
			String str = bfr.readLine();
						
			while(str != "") {
				
				br.add(str);
				
				str = bfr.readLine();
				
				System.out.println(str + "1");
				
				if(str == null) {
					break;
				}
				
			}
			
			System.out.println(br);
			
			for(int i = 0; i < br.size(); i++) {
				
				if(br.get(i).contains("Version:")) {
					
					version = br.get(i).split(":")[1];
					
				}
				
			}
			
			bfr.close();
			
			Files.copy(new URL("http://raupi.net/info/VersionInfo.dat").openStream(), Paths.get(new File(System.getProperty("user.dir") + File.separator + "VersionInfo.dat").toURI()), StandardCopyOption.REPLACE_EXISTING);
			
			BufferedReader bfr2 = new BufferedReader(new FileReader(ver));
			
			ArrayList<String> br2 = new ArrayList<String>();
			
			String str2 = bfr2.readLine();
						
			while(str2 != "" || str2 != null) {
				
				br2.add(str2);
				
				str2 = bfr2.readLine();
				
				System.out.println(str2 + "2");
				
				if(str2 == null) {
					break;
				}
				
			}
			
			for(int i = 0; i < br2.size(); i++) {
				
				if(br2.get(i).contains("Version:")) {
					
					version_n = br2.get(i).split(":")[1];
					
				}
				
			}
			
			if(Integer.parseInt(version_n) > Integer.parseInt(version)) {
				MessageDialog update = new MessageDialog(shlAkproUpdater, "Aktualisierung", SWTResourceManager.getImage(AKProUpdater.class, "/net/raupi/AK_Pro_Bubbles_45_cut.png"), "Es ist eine Aktualisierung der App verfügbar (Version " + version_n + ").\nWollen Sie diese installieren?", SWT.None, new String[] {"Ja", "Nein"}, 0);
				int i = update.open();
				System.out.println(i);
				if(i == 0) {
					Files.copy(new URL("http://raupi.net/info/AKPro.jar").openStream(), Paths.get(new File(System.getProperty("user.dir") + File.separator + "AKPro.jar").toURI()), StandardCopyOption.REPLACE_EXISTING);
				}
			}
			
			bfr2.close();
			
		} catch (IOException e) {
			MessageBox msg = new MessageBox(shlAkproUpdater, SWT.ERROR);
			msg.setText("Fehler beim Aktualisieren");
			msg.setMessage("Es ist ein Fehler aufgetreten.\nBitte überpfrüfen Sie ihre Internetverbindung.\nFalls das Problem bestehen bleibt, entfernen/reparieren Sie die App. (Windows Apps und Features hinzufügen/entfernen)");
			msg.open();
			e.printStackTrace();
		}
		
		shlAkproUpdater.dispose();
		
		try {
			Runtime.getRuntime().exec("java -jar AKPro.jar");
		} catch (IOException e) {
			MessageBox msg = new MessageBox(shlAkproUpdater, SWT.ERROR);
			msg.setText("Fehler beim Starten");
			msg.setMessage("Es ist ein Fehler aufgetreten.\nBitte überpfrüfen Sie ihren Java Pfad.\nFalls das Problem bestehen bleibt, entfernen/reparieren Sie die App. (Windows Apps und Features hinzufügen/entfernen)");
			msg.open();
			e.printStackTrace();
		}
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAkproUpdater = new Shell();
		shlAkproUpdater.setModified(true);
		shlAkproUpdater.setImage(SWTResourceManager.getImage(AKProUpdater.class, "/net/raupi/AK_Pro_Bubbles_45_cut.png"));
		shlAkproUpdater.setSize(287, 145);
		shlAkproUpdater.setText("AKPro Updater");
		shlAkproUpdater.setLayout(new FormLayout());
		
		Label lblberprfeAufUpdates = new Label(shlAkproUpdater, SWT.NONE);
		FormData fd_lblberprfeAufUpdates = new FormData();
		fd_lblberprfeAufUpdates.bottom = new FormAttachment(0, 42);
		fd_lblberprfeAufUpdates.right = new FormAttachment(0, 258);
		fd_lblberprfeAufUpdates.top = new FormAttachment(0, 10);
		fd_lblberprfeAufUpdates.left = new FormAttachment(0, 10);
		lblberprfeAufUpdates.setLayoutData(fd_lblberprfeAufUpdates);
		lblberprfeAufUpdates.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblberprfeAufUpdates.setText("\u00DCberpr\u00FCfe auf Updates ...");
		
		ProgressBar progressBar = new ProgressBar(shlAkproUpdater, SWT.INDETERMINATE);
		progressBar.setForeground(SWTResourceManager.getColor(0, 0, 0));
		progressBar.setBackground(SWTResourceManager.getColor(255, 255, 255));
		FormData fd_progressBar = new FormData();
		fd_progressBar.right = new FormAttachment(lblberprfeAufUpdates, 0, SWT.RIGHT);
		fd_progressBar.bottom = new FormAttachment(lblberprfeAufUpdates, 54, SWT.BOTTOM);
		fd_progressBar.top = new FormAttachment(lblberprfeAufUpdates, 6);
		fd_progressBar.left = new FormAttachment(0, 10);
		progressBar.setLayoutData(fd_progressBar);
		
	}
}
