package org.eclipse.scout.apps.contacts.client;

import java.beans.PropertyChangeEvent;
import java.security.AccessController;
import java.security.Principal;
import java.util.List;

import org.eclipse.scout.rt.client.ui.action.keystroke.IKeyStroke;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenu;
import org.eclipse.scout.rt.client.ui.desktop.AbstractDesktop;
import org.eclipse.scout.rt.client.ui.desktop.notification.NativeNotificationDefaults;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutlineViewButton;
import org.eclipse.scout.rt.client.ui.desktop.outline.IOutline;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.CollectionUtility;

//import org.eclipse.scout.apps.contacts.client.Desktop.UserProfileMenu.ThemeMenu.DarkThemeMenu;
//import org.eclipse.scout.apps.contacts.client.Desktop.UserProfileMenu.ThemeMenu.DefaultThemeMenu;
import org.eclipse.scout.apps.contacts.client.search.SearchOutline;
//import org.eclipse.scout.apps.contacts.client.settings.SettingsOutline;
import org.eclipse.scout.apps.contacts.client.contact.ContactOutline;
import org.eclipse.scout.apps.contacts.shared.Icons;
import org.eclipse.scout.rt.platform.util.StringUtility;

import javax.security.auth.Subject;

/**
 * @author mega2
 */
public class Desktop extends AbstractDesktop {

  public Desktop() {
//    addPropertyChangeListener(PROP_THEME, this::onThemeChanged);
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("ApplicationTitle");
  }

  @Override
  protected String getConfiguredLogoId() {
    return Icons.AppLogo;
  }

  @Override
  protected NativeNotificationDefaults getConfiguredNativeNotificationDefaults() {
    return super.getConfiguredNativeNotificationDefaults().withIconId("application_logo.png");
  }

  @Override
  protected List<Class<? extends IOutline>> getConfiguredOutlines() {
    return CollectionUtility.<Class<? extends IOutline>>arrayList(ContactOutline.class, SearchOutline.class);
  }

  @Override
  protected void execDefaultView() {
    selectFirstVisibleOutline();
  }

  protected void selectFirstVisibleOutline() {
    for (IOutline outline : getAvailableOutlines()) {
      if (outline.isEnabled() && outline.isVisible()) {
        setOutline(outline.getClass());
        return;
      }
    }
  }


  @Order(1000)
  public class ContactOutlineViewButton extends AbstractOutlineViewButton {

    public ContactOutlineViewButton() {
      this(ContactOutline.class);
    }

    protected ContactOutlineViewButton(Class<? extends ContactOutline> outlineClass) {
      super(Desktop.this, outlineClass);
    }

    @Override
    protected String getConfiguredKeyStroke() {
      return IKeyStroke.F2;
    }
  }

  @Order(2000)
  public class SearchOutlineViewButton extends AbstractOutlineViewButton {

    public SearchOutlineViewButton() {
      this(SearchOutline.class);
    }

    protected SearchOutlineViewButton(Class<? extends SearchOutline> outlineClass) {
      super(Desktop.this, outlineClass);
    }

    @Override
    protected DisplayStyle getConfiguredDisplayStyle() {
      return DisplayStyle.TAB;
    }

    @Override
    protected String getConfiguredKeyStroke() {
      return IKeyStroke.F3;
    }
  }

  @Order(1000)
  public class QuickAccessMenu extends AbstractMenu {
    @Override
    protected String getConfiguredText() {
      return TEXTS.get("QuickAccessMenu");
    }

    @Override
    protected void execAction() {

    }
  }

  @Order(2000)
  public class OptionsMenu extends AbstractMenu {
    @Override
    protected String getConfiguredText() {
      return TEXTS.get("OptionsMenu");
    }
    @Override
    protected String getConfiguredIconId() {
      return Icons.Gear;
    }


    @Override
    protected void execAction() {

    }
  }

  @Order(3000)
  public class UserMenu extends AbstractMenu {
    @Override
    protected String getConfiguredText() {
      Subject subject = Subject.getSubject(AccessController.getContext());
      Principal firstPrincipal = CollectionUtility.firstElement(subject.getPrincipals());
      return StringUtility.uppercaseFirst(firstPrincipal.getName());
    }

    @Override
    protected void execAction() {

    }

    @Override
    protected String getConfiguredIconId() {
      return Icons.PersonSolid;
    }

    @Override
    protected String getConfiguredCssClass() {
      return "profile-menu";
    }
  }



//  @Order(3000)
//  public class SettingsOutlineViewButton extends AbstractOutlineViewButton {
//
//    public SettingsOutlineViewButton() {
//      this(SettingsOutline.class);
//    }
//
//    protected SettingsOutlineViewButton(Class<? extends SettingsOutline> outlineClass) {
//      super(Desktop.this, outlineClass);
//    }
//
//    @Override
//    protected DisplayStyle getConfiguredDisplayStyle() {
//      return DisplayStyle.TAB;
//    }
//
//    @Override
//    protected String getConfiguredKeyStroke() {
//      return IKeyStroke.F10;
//    }
//  }
}
