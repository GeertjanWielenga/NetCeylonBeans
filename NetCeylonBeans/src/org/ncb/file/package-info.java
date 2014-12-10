@TemplateRegistrations({
    @TemplateRegistration(iconBase = "org/ncb/resources/ceylon_icon.png",
            folder = "Ceylon",
            requireProject = false,
            displayName = "#CeylonObjecttemplate_displayName",
            content = "Object.ceylon"),
    @TemplateRegistration(iconBase = "org/ncb/resources/ceylon_icon.png",
            folder = "Ceylon",
            requireProject = false,
            displayName = "#CeylonTabletemplate_displayName",
            content = "Table.ceylon")
})
@Messages({
    "CeylonObjecttemplate_displayName=Object",
    "CeylonTabletemplate_displayName=Table",
})
package org.ncb.file;

import org.netbeans.api.templates.TemplateRegistration;
import org.netbeans.api.templates.TemplateRegistrations;
import org.openide.util.NbBundle.Messages;
