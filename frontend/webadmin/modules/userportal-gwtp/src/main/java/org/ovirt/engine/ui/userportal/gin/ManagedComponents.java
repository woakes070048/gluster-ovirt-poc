package org.ovirt.engine.ui.userportal.gin;

import org.ovirt.engine.ui.common.system.ClientStorage;
import org.ovirt.engine.ui.userportal.ApplicationConstants;
import org.ovirt.engine.ui.userportal.ApplicationMessages;
import org.ovirt.engine.ui.userportal.ApplicationResources;
import org.ovirt.engine.ui.userportal.ApplicationTemplates;
import org.ovirt.engine.ui.userportal.section.login.presenter.LoginSectionPresenter;
import org.ovirt.engine.ui.userportal.section.main.presenter.MainSectionPresenter;
import org.ovirt.engine.ui.userportal.section.main.presenter.MainTabPanelPresenter;
import org.ovirt.engine.ui.userportal.section.main.presenter.tab.MainTabBasicPresenter;
import org.ovirt.engine.ui.userportal.section.main.presenter.tab.MainTabExtendedPresenter;
import org.ovirt.engine.ui.userportal.section.main.presenter.tab.extended.SideTabExtendedResourcePresenter;
import org.ovirt.engine.ui.userportal.section.main.presenter.tab.extended.SideTabExtendedTemplatePresenter;
import org.ovirt.engine.ui.userportal.section.main.presenter.tab.extended.SideTabExtendedVirtualMachinePresenter;

import com.google.gwt.inject.client.AsyncProvider;
import com.google.inject.Provider;

/**
 * Contains methods for accessing managed components that participate in dependency injection.
 * <p>
 * There should be a method for each {@link com.gwtplatform.mvp.client.Presenter Presenter} (excluding
 * {@link com.gwtplatform.mvp.clientcom.gwtplatform.mvp.client.PresenterWidget PresenterWidget} classes, unless they are
 * referenced through {@link ClientGinjector} directly). This is necessary due to the current limitation of GWTP-GIN
 * integration.
 */
public interface ManagedComponents {

    ApplicationConstants getApplicationConstants();

    ApplicationResources getApplicationResources();

    ApplicationTemplates getApplicationTemplates();

    ApplicationMessages getApplicationMessages();

    ClientStorage getClientStorage();

    // Presenters: Login section

    Provider<LoginSectionPresenter> getLoginSectionPresenter();

    // Presenters: Main section: common stuff

    AsyncProvider<MainSectionPresenter> getMainSectionPresenter();

    // Presenters: Main section: main tabs

    AsyncProvider<MainTabPanelPresenter> getMainTabPanelPresenter();

    AsyncProvider<MainTabBasicPresenter> getMainTabBasicPresenter();

    AsyncProvider<MainTabExtendedPresenter> getMainTabExtendedPresenter();

    // Presenters: Main section: side tabs

    AsyncProvider<SideTabExtendedVirtualMachinePresenter> getSideTabExtendedVirtualMachinePresenter();

    AsyncProvider<SideTabExtendedTemplatePresenter> getSideTabExtendedTemplatePresenter();

    AsyncProvider<SideTabExtendedResourcePresenter> getSideTabExtendedResourcePresenter();

}