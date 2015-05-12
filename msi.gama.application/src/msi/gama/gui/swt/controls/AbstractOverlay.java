/*********************************************************************************************
 * 
 * 
 * 'AbstractOverlay.java', in plugin 'msi.gama.application', is part of the source code of the
 * GAMA modeling and simulation platform.
 * (c) 2007-2014 UMI 209 UMMISCO IRD/UPMC & Partners
 * 
 * Visit https://code.google.com/p/gama-platform/ for license information and developers contact.
 * 
 * 
 **********************************************************************************************/
package msi.gama.gui.swt.controls;

import msi.gama.common.util.GuiUtils;
import msi.gama.gui.swt.IGamaColors;
import msi.gama.gui.views.LayeredDisplayView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.*;

/**
 * The class AbstractOverlay
 * 
 * 26 Aug: took the decision to hide the overlays when the view is detached, as to avoid nasty problems of z-position,
 * non-existing Move and Resize events, etc. on detached views. This is a workaround for Issue 548.
 * 
 * @author drogoul
 * @since 19 aug. 2013
 * 
 */
public abstract class AbstractOverlay {

	private final Shell popup;
	private boolean isHidden = true;
	private final LayeredDisplayView view;
	protected final Composite referenceComposite;
	private final Shell parentShell;
	final boolean createExtraInfo;

	// ACTIONS ON THE POPUP

	Runnable doHide = new Runnable() {

		@Override
		public void run() {
			hide();
		}
	};

	Runnable doDisplay = new Runnable() {

		@Override
		public void run() {
			display();
		}
	};

	// Runnable doResize = new Runnable() {
	//
	// @Override
	// public void run() {
	// relocate();
	// resize();
	// }
	// };

	protected void run(final Runnable r) {
		GuiUtils.run(r);
	}

	// PART LISTENER

	private final IPartListener2 pl2 = new IPartListener2() {

		@Override
		public void partActivated(final IWorkbenchPartReference partRef) {

			IWorkbenchPart part = partRef.getPart(false);
			if ( view.equals(part) ) {
				// GuiUtils.debug("Part " + partRef.getTitle() + " activated -> should display overlay");
				run(doDisplay);
			}
			// else run(doHide)
			;
		}

		@Override
		public void partBroughtToTop(final IWorkbenchPartReference partRef) {
			// GuiUtils.debug("Part " + partRef.getTitle() + " brought to top -> nothing");
		}

		@Override
		public void partClosed(final IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);
			if ( view.equals(part) ) {
				// GuiUtils.debug("Part " + partRef.getTitle() + " closed -> should close overlay");
				close();
			}
		}

		@Override
		public void partDeactivated(final IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);
			if ( view.equals(part) && !referenceComposite.isVisible() ) {
				// GuiUtils.debug(view.getPartName() +
				// " disactivated && component is not visible -> should hide overlay");
				run(doHide);
			}
		}

		@Override
		public void partOpened(final IWorkbenchPartReference partRef) {}

		@Override
		public void partHidden(final IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);
			if ( view.equals(part) ) {
				// GuiUtils.debug("Part " + partRef.getTitle() + " hidden -> should hide overlay");
				run(doHide);
			}
		}

		@Override
		public void partVisible(final IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);
			if ( view.equals(part) ) {
				// GuiUtils.debug("Part " + partRef.getTitle() + " visible -> should display overlay");
				run(doDisplay);
			}
			// else {
			// run(doHide);
			// }
		}

		@Override
		public void partInputChanged(final IWorkbenchPartReference partRef) {}
	};

	OverlayListener listener = new OverlayListener();
	protected final MouseListener toggleListener = new MouseAdapter() {

		@Override
		public void mouseUp(final MouseEvent e) {
			setHidden(true);
		}

	};

	class OverlayListener implements ShellListener, ControlListener {

		/**
		 * Method controlMoved()
		 * @see org.eclipse.swt.events.ControlListener#controlMoved(org.eclipse.swt.events.ControlEvent)
		 */
		@Override
		public void controlMoved(final ControlEvent e) {
			relocate();
			resize();
		}

		/**
		 * Method controlResized()
		 * @see org.eclipse.swt.events.ControlListener#controlResized(org.eclipse.swt.events.ControlEvent)
		 */
		@Override
		public void controlResized(final ControlEvent e) {
			relocate();
			resize();
		}

		/**
		 * Method shellActivated()
		 * @see org.eclipse.swt.events.ShellListener#shellActivated(org.eclipse.swt.events.ShellEvent)
		 */
		@Override
		public void shellActivated(final ShellEvent e) {}

		/**
		 * Method shellClosed()
		 * @see org.eclipse.swt.events.ShellListener#shellClosed(org.eclipse.swt.events.ShellEvent)
		 */
		@Override
		public void shellClosed(final ShellEvent e) {
			close();
		}

		/**
		 * Method shellDeactivated()
		 * @see org.eclipse.swt.events.ShellListener#shellDeactivated(org.eclipse.swt.events.ShellEvent)
		 */
		@Override
		public void shellDeactivated(final ShellEvent e) {}

		/**
		 * Method shellDeiconified()
		 * @see org.eclipse.swt.events.ShellListener#shellDeiconified(org.eclipse.swt.events.ShellEvent)
		 */
		@Override
		public void shellDeiconified(final ShellEvent e) {}

		/**
		 * Method shellIconified()
		 * @see org.eclipse.swt.events.ShellListener#shellIconified(org.eclipse.swt.events.ShellEvent)
		 */
		@Override
		public void shellIconified(final ShellEvent e) {}
	}

	public AbstractOverlay(final LayeredDisplayView view, final Composite c, final boolean createExtraInfo) {
		this.createExtraInfo = createExtraInfo;
		this.view = view;
		IPartService ps = (IPartService) ((IWorkbenchPart) view).getSite().getService(IPartService.class);
		ps.addPartListener(pl2);
		referenceComposite = c;
		parentShell = c.getShell();
		popup = new Shell(parentShell, SWT.NO_TRIM | SWT.NO_FOCUS);

		popup.setAlpha(140);
		FillLayout layout = new FillLayout();
		layout.type = SWT.VERTICAL;
		layout.spacing = 10;
		popup.setLayout(layout);
		popup.setBackground(IGamaColors.BLACK.color());
		createPopupControl();
		// Control control = createControl();
		// control.setLayoutData(null);
		popup.setAlpha(140);
		popup.layout();
		parentShell.addShellListener(listener);
		parentShell.addControlListener(listener);
		c.addControlListener(listener);
	}

	protected void createPopupControl() {};

	protected abstract Point getLocation();

	protected abstract Point getSize();

	public Shell getPopup() {
		return popup;
	}

	protected LayeredDisplayView getView() {
		return view;
	}

	public void update() {}

	public void display() {
		if ( isHidden() ) { return; }
		// We first verify that the popup is still ok
		if ( popup.isDisposed() ) { return; }
		update();
		relocate();
		resize();
		if ( !popup.isVisible() ) {
			popup.setVisible(true);
		}
	}

	public void relocate() {
		if ( isHidden() ) { return; }
		if ( !popup.isDisposed() ) {
			popup.setLocation(getLocation());
		}

		// GuiUtils.debug("Overlay relocated to " + popup.getLocation());
	}

	public void resize() {
		if ( isHidden() ) { return; }
		if ( !popup.isDisposed() ) {
			final Point size = getSize();
			popup.setSize(popup.computeSize(size.x, size.y));
		}
	}

	public void hide() {
		if ( !popup.isDisposed() && popup.isVisible() ) {
			// GuiUtils.debug("set visible(false) sent to popup of " + getClass().getSimpleName());
			// slide(false);
			popup.setSize(0, 0);
			popup.update();
			popup.setVisible(false);
			// GuiUtils.debug("Is the popup visible ? " + popup.isVisible());
		}
	}

	public boolean isDisposed() {
		return popup.isDisposed() || viewIsDetached();
	}

	public void close() {
		if ( !popup.isDisposed() ) {
			// Composite c = view.getComponent();
			if ( referenceComposite != null && !referenceComposite.isDisposed() ) {
				referenceComposite.removeControlListener(listener);
			}
			IPartService ps = (IPartService) ((IWorkbenchPart) view).getSite().getService(IPartService.class);
			if ( ps != null ) {
				ps.removePartListener(pl2);
			}
			if ( !parentShell.isDisposed() ) {
				parentShell.removeControlListener(listener);
				parentShell.removeShellListener(listener);
			}
			popup.dispose();
		}
	}

	public boolean isHidden() {
		// AD: Temporary fix for Issue 548. When a view is detached, the overlays are not displayed
		return isHidden || isDisposed();
	}

	public boolean isVisible() {
		return !isHidden;
	}

	private boolean viewIsDetached() {
		// Uses the trick from http://eclipsesource.com/blogs/2010/06/23/tip-how-to-detect-that-a-view-was-detached/
		final boolean[] result = new boolean[] { false };
		GuiUtils.run(new Runnable() {

			@Override
			public void run() {
				IWorkbenchPartSite site = view.getSite();
				if ( site == null ) { return; }
				Shell shell = site.getShell();
				if ( shell == null ) { return; }
				String text = shell.getText();
				result[0] = text == null || text.isEmpty();
			}
		});
		return result[0];

	}

	public final void toggle() {
		setHidden(!isHidden);
	}

	public final void setHidden(final boolean hidden) {
		isHidden = hidden;
		if ( isHidden ) {
			hide();
		} else if ( !viewIsDetached() ) {
			// No need to compute these if the view is detached
			// relocate();
			// resize();
			display();
		}
	}

}
