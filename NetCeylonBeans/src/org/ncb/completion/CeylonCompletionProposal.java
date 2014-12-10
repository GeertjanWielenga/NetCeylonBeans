package org.ncb.completion;

import java.util.Collections;
import java.util.Set;
import javax.swing.ImageIcon;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.spi.DefaultCompletionProposal;
import org.openide.util.ImageUtilities;

public class CeylonCompletionProposal extends DefaultCompletionProposal {

    @StaticResource
    private static final String CEYLON_ICON_PATH = "org/ncb/resources/ceylon_icon.png";

    public static CeylonCompletionProposal forElement(ElementHandle element) {
        return new CeylonCompletionProposal(element);
    }
    private final ElementHandle element;
    private final Set<Modifier> modifiers;

    public CeylonCompletionProposal(ElementHandle element) {
        this.element = element;
        this.elementKind = element.getKind();
        this.modifiers = element.getModifiers();
    }

    @Override
    public ImageIcon getIcon() {
        if (element.getKind() == ElementKind.KEYWORD) {
            return ImageUtilities.loadImageIcon(CEYLON_ICON_PATH, false);
        } else {
            return null;
        }
    }

    @Override
    public String getName() {
        return element.getName();
    }

    @Override
    public ElementHandle getElement() {
        return element;
    }

    @Override
    public Set<Modifier> getModifiers() {
        return Collections.unmodifiableSet(modifiers);
    }
}