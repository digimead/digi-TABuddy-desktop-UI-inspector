/**
 * This file is part of the TA Buddy project.
 * Copyright (c) 2014 Alexey Aksenov ezh@ezh.msk.ru
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Global License version 3
 * as published by the Free Software Foundation with the addition of the
 * following permission added to Section 15 as permitted in Section 7(a):
 * FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED
 * BY Limited Liability Company «MEZHGALAKTICHESKIJ TORGOVYJ ALIANS»,
 * Limited Liability Company «MEZHGALAKTICHESKIJ TORGOVYJ ALIANS» DISCLAIMS
 * THE WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Global License for more details.
 * You should have received a copy of the GNU Affero General Global License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA, 02110-1301 USA, or download the license from the following URL:
 * http://www.gnu.org/licenses/agpl.html
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Global License.
 *
 * In accordance with Section 7(b) of the GNU Affero General Global License,
 * you must retain the producer line in every report, form or document
 * that is created or manipulated using TA Buddy.
 *
 * You can be released from the requirements of the license by purchasing
 * a commercial license. Buying such a license is mandatory as soon as you
 * develop commercial activities involving the TA Buddy software without
 * disclosing the source code of your own applications.
 * These activities include: offering paid services to customers,
 * serving files in a web or/and network application,
 * shipping TA Buddy with a closed source product.
 *
 * For more information, please contact Digimead Team at this
 * address: ezh@ezh.msk.ru
 */

package org.digimead.tabuddy.desktop.core.ui.inspector.dialog;

import java.util.ResourceBundle;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;

/**
 * This file is autogenerated by Google WindowBuilder Pro
 *
 * @author ezh
 */
public class InspectorDialogSkel extends TitleAreaDialog {
	private static final ResourceBundle BUNDLE = getResourceBundle();
	private Table table;
	private Button btnRefresh;
	private TreeViewer treeViewer;
	private TableViewer tableViewer;
	private Text textMargin;
	private Button btnReset;

	/**
	 * Get ResourceBundle from Scala environment.
	 *
	 * @return ResourceBundle interface of NLS singleton.
	 */
	private static ResourceBundle getResourceBundle() {
		try {
			return (ResourceBundle) Class.forName("org.digimead.tabuddy.desktop.core.ui.inspector.Messages").newInstance();
		} catch (ClassNotFoundException e) {
			return ResourceBundle.getBundle("org.digimead.tabuddy.desktop.core.ui.inspector.dialog.messages");
		} catch (IllegalAccessException e) {
			return ResourceBundle.getBundle("org.digimead.tabuddy.desktop.core.ui.inspector.dialog.messages");
		} catch (InstantiationException e) {
			return ResourceBundle.getBundle("org.digimead.tabuddy.desktop.core.ui.inspector.dialog.messages");
		}
	}

	/**
	 * Create the dialog.
	 *
	 * @param parentShell
	 */
	public InspectorDialogSkel(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE);
	}

	/**
	 * Create contents of the dialog.
	 *
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage(BUNDLE.getString("inspectorDialogDescription_text"));
		setTitle(BUNDLE.getString("inspectorDialogTitle_text"));
		Composite area = (Composite) super.createDialogArea(parent);
		SashForm container = new SashForm(area, SWT.VERTICAL);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		btnRefresh = new Button(composite, SWT.NONE);
		btnRefresh.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		btnRefresh.setText("Refresh");

		treeViewer = new TreeViewer(composite, SWT.BORDER);
		treeViewer.setUseHashlookup(true);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));

		btnReset = new Button(composite, SWT.NONE);
		btnReset.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, true, 1, 1));
		btnReset.setText("Reset");

		Label lblMargin = new Label(composite, SWT.NONE);
		lblMargin.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblMargin.setText("Margin");

		textMargin = new Text(composite, SWT.BORDER | SWT.CENTER);
		textMargin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		textMargin.setTextLimit(2);

		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		TableColumn tblclmnProperty = new TableColumn(table, SWT.NONE);
		tblclmnProperty.setWidth(100);
		tblclmnProperty.setText("Property");

		TableColumn tblclmnValue = new TableColumn(table, SWT.NONE);
		tblclmnValue.setWidth(100);
		tblclmnValue.setText("Value");

		return area;
	}

	/**
	 * Create contents of the button bar.
	 *
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 480);
	}

	protected Button getBtnRefresh() {
		return btnRefresh;
	}

	protected TreeViewer getTreeViewer() {
		return treeViewer;
	}

	protected TableViewer getTableViewer() {
		return tableViewer;
	}

	protected Text getTextMargin() {
		return textMargin;
	}
	protected Button getBtnReset() {
		return btnReset;
	}
}
