package org.ncb.completion;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import org.ncb.language.CeylonLanguage;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.openide.filesystems.FileObject;

/**
 *
 */
public class CeylonElementHandle implements ElementHandle {

    private final String name;
    private final OffsetRange offsetRange;
    private final ElementKind kind;
    private final Set<Modifier> modifiers;
    private final FileObject fileObject;

    public CeylonElementHandle(String name, OffsetRange offsetRange, ElementKind kind, Set<Modifier> modifiers, FileObject fileObject) {
        this.name = name;
        this.offsetRange = offsetRange;
        this.kind = kind;
        this.modifiers = modifiers == null || modifiers.isEmpty() ? Collections.<Modifier>emptySet() : EnumSet.copyOf(modifiers);
        this.fileObject = fileObject;
    }

    @Override
    public FileObject getFileObject() {
        return fileObject;
    }

    @Override
    public String getMimeType() {
        return CeylonLanguage.MIMETYPE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIn() {
        return fileObject.getNameExt();
    }

    @Override
    public ElementKind getKind() {
        return kind;
    }

    @Override
    public Set<Modifier> getModifiers() {
        return Collections.unmodifiableSet(modifiers);
    }

    @Override
    public boolean signatureEquals(ElementHandle handle) {
        return name.equals(handle.getName());
    }

    @Override
    public OffsetRange getOffsetRange(ParserResult result) {
        return offsetRange;
    }

    public String getDocumentationHtml() {
        return "No documentation";
    }

    public static Builder with(String name, OffsetRange offsetRange, ElementKind kind) {
        return new Builder(name, offsetRange, kind);
    }

    public static class Builder {

        private final String name;
        private final OffsetRange offsetRange;
        private final ElementKind kind;
        private final Set<Modifier> modifiers = EnumSet.noneOf(Modifier.class);
        private FileObject fileObject;

        private Builder(String name, OffsetRange offsetRange, ElementKind kind) {
            this.name = name;
            this.offsetRange = offsetRange;
            this.kind = kind;
        }

        public Builder withModifiers(Set<Modifier> modifiers) {
            this.modifiers.addAll(modifiers);
            return this;
        }

        public Builder withModifier(Modifier modifier) {
            this.modifiers.add(modifier);
            return this;
        }

        public Builder withFileObject(FileObject fileObject) {
            this.fileObject = fileObject;
            return this;
        }

        public CeylonElementHandle build() {
            return new CeylonElementHandle(name, offsetRange, kind, modifiers, fileObject);
        }
    }
}