package com.googlecode.icefusion.ui.commons.extra;


import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.icefusion.ui.commons.BackingBeanForm;
import com.googlecode.icefusion.ui.commons.constant.Context;
import com.googlecode.icefusion.ui.commons.constant.ICEfusionConsts;
import com.googlecode.icefusion.ui.commons.constant.Locale;
import com.googlecode.icefusion.ui.commons.constant.Skin;


/**
 * Settings management.
 * 
 * @author Rainer Eschen
 * 
 */
public class Settings extends BackingBeanForm {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(Settings.class);

    private static final long serialVersionUID = -8179827382227177435L;

    @Autowired
    private ICEfusionConsts consts;

    @Autowired
    private Context context;

    /**
     * Available Languages
     */
    public SelectItem[] getLocales() {

        SelectItem[] locales = new SelectItem[this.context.getLocales().size()];
        int i = 0;
        for (Locale locale : this.context.getLocales()) {
            locales[i++] = new SelectItem(locale.getCode(), consts.getLocalized(locale.getLabel(), "icefusion"));
        }
        return locales;
    }

    public String getLocale() {
        return this.context.getLocaleCode();
    }

    public void setLocale(String locale) {
        this.context.setLocale(locale);
    }

    /**
     * Available Skins
     */
    public SelectItem[] getSkins() {

        SelectItem[] skins = new SelectItem[this.context.getSkins().size()];
        int i = 0;
        for (Skin skin : this.context.getSkins()) {
            skins[i++] = new SelectItem(skin.getCode(), consts.getLocalized(skin.getLabel(), "icefusion"));
        }
        return skins;
    }

    public String getSkin() {
        return this.context.getSkin();
    }

    public void setSkin(String skin) {
        if (logger.isDebugEnabled()) {
            logger.debug("setSkin(String) - start: " + skin); //$NON-NLS-1$
        }

        this.context.setSkin(skin);

        if (logger.isDebugEnabled()) {
            logger.debug("setSkin(String) - end"); //$NON-NLS-1$
        }
    }

    /**
     * All settings are saved to the persistent settings object.
     * 
     * @return
     */
    public String change() {

        return null;
    }
}
