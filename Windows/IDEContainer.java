package net.raupi;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class IDEContainer extends Composite{

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public IDEContainer(Composite parent, int style, Image img, String description, String name, SelectionAdapter s) {
		super(parent, SWT.BORDER);
		setLayout(new FormLayout());
		
		Label lblIco = new Label(this, SWT.NONE);
		FormData fd_lblIco = new FormData();
		fd_lblIco.bottom = new FormAttachment(0, 115);
		fd_lblIco.right = new FormAttachment(0, 111);
		fd_lblIco.top = new FormAttachment(0, 10);
		fd_lblIco.left = new FormAttachment(0, 10);
		lblIco.setLayoutData(fd_lblIco);
		if(img != null) {
			lblIco.setImage(img);
		}
		
		Button btnStart = new Button(this, SWT.NONE);
		FormData fd_btnStart = new FormData();
		fd_btnStart.bottom = new FormAttachment(0, 90);
		fd_btnStart.right = new FormAttachment(0, 386);
		fd_btnStart.top = new FormAttachment(0, 10);
		fd_btnStart.left = new FormAttachment(0, 117);
		btnStart.setLayoutData(fd_btnStart);
		btnStart.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_HAND));
		btnStart.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnStart.addSelectionListener(s);
		if(name != null) {
			btnStart.setText(name);
		}
		
		Label lblBeschreibung = new Label(this, SWT.NONE);
		FormData fd_lblBeschreibung = new FormData();
		fd_lblBeschreibung.right = new FormAttachment(btnStart, 0, SWT.RIGHT);
		fd_lblBeschreibung.bottom = new FormAttachment(0, 115);
		fd_lblBeschreibung.top = new FormAttachment(0, 96);
		fd_lblBeschreibung.left = new FormAttachment(0, 117);
		lblBeschreibung.setLayoutData(fd_lblBeschreibung);
		lblBeschreibung.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		if(description != null) {
			lblBeschreibung.setText(description);
		}

	}
}
