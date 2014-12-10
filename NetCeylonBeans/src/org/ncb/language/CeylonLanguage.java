package org.ncb.language;

import org.ncb.completion.CeylonCompletionHandler;
import org.ncb.lexer.CeylonTokenId;
import org.ncb.parser.NBCeylonParser;
import org.ncb.structure.CeylonStructureScanner;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;

@LanguageRegistration(mimeType = "text/x-ceylon")
public class CeylonLanguage extends DefaultLanguageConfig {

    public static final String MIMETYPE = "text/x-ceylon";

    @Override
    public Language<CeylonTokenId> getLexerLanguage() {
        return CeylonTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "Ceylon";
    }

    @Override
    public Parser getParser() {
        return new NBCeylonParser();
    }
    @Override
    public StructureScanner getStructureScanner() {
        return new CeylonStructureScanner();
    }
    @Override
    public boolean hasStructureScanner() {
        return true;
    }

    @Override
    public CodeCompletionHandler getCompletionHandler() {
        return new CeylonCompletionHandler();
    }

    @Override
    public boolean isIdentifierChar(char c) {
        return isCeylonIdentifierChar(c);
    }

    public static boolean isCeylonIdentifierChar(char c) {
        return Character.isJavaIdentifierPart(c);
    }
}
