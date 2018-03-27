package org.app.portofolio.common.menu.dropdown;

import java.io.Serializable;

import org.springframework.util.StringUtils;
import org.zkoss.zk.ui.ComponentNotFoundException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

import org.app.portofolio.common.menu.util.ILabelElement;

/**
*
* @author tekosulaiman@yahoo.com
*/
@SuppressWarnings("rawtypes")
public class DefaultDropDownMenuItem extends Menuitem implements EventListener, Serializable, ILabelElement{
	
	private static final long serialVersionUID = 1L;
	private String zulNavigation;

	public DefaultDropDownMenuItem(){
		/*Test GetFellow*/
		final Borderlayout bl = (Borderlayout) Path.getComponent("/mainMenuWindow/borderlayoutMain");
		final Center center = bl.getCenter();

		final Tabs tabs = (Tabs) center.getFellow("tabbox").getFellow("tabs");
		/*System.out.println("Get Fellow Tabs ->>>"+tabs);*/
	}
	
	@Override
	public void onEvent(Event event) throws Exception {

		try {
			// params
			final int workWithTabs = 1;

			if (workWithTabs == 1) {

				/* get an instance of the borderlayout defined in the zul-file */
				final Borderlayout bl = (Borderlayout) Path.getComponent("/mainMenuWindow/borderlayoutMain");
				/* get an instance of the searched CENTER layout area */
				final Center center = bl.getCenter();

				final Tabs tabs = (Tabs) center.getFellow("tabbox").getFellow("tabs");

				// Check if the tab is already open, if not than create them
				Tab checkTab = null;
				try {
					checkTab = (Tab) tabs.getFellow("tab_" + this.getId());
					checkTab.setSelected(true);
				} catch (final ComponentNotFoundException ex) {
					// Ignore if can not get tab.
				}

				if (checkTab == null) {
					final Tab tab = new Tab();
					tab.setId("tab_" + this.getId());
					tab.setLabel(this.getLabel().trim());
					tab.setClosable(true);

					tab.setParent(tabs);

					final Tabpanels tabpanels = (Tabpanels) center.getFellow("tabpanels");
					final Tabpanel tabpanel = new Tabpanel();
					tabpanel.setHeight("100%");
					tabpanel.setStyle("padding: 0px;");
					tabpanel.setParent(tabpanels);

					Executions.createComponents(getZulNavigation(), tabpanel, null);
					tab.setSelected(true);
				}
			}
		} catch (final Exception e) {
			System.out.println("Error Menuitem->>>"+e.toString());
			Messagebox.show(e.toString());
		}
	}

	private String getZulNavigation() {
		return this.zulNavigation;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void setZulNavigation(String zulNavigation) {
		this.zulNavigation = zulNavigation;
		if (!StringUtils.isEmpty(zulNavigation)) {
			addEventListener("onClick", this);
		}
	}
}