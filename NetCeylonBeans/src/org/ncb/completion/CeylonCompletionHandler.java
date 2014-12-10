package org.ncb.completion;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.ncb.language.CeylonLanguage;
import org.netbeans.modules.csl.api.CodeCompletionContext;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.api.CodeCompletionResult;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.api.ParameterInfo;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.Snapshot;

public class CeylonCompletionHandler implements CodeCompletionHandler {

    private static final List<String> KEYWORDS = Arrays.asList("import", "assert",
            "alias", "class", "interface", "object", "given", "value", "assign", "void", "function",
            "assembly", "module", "package", "of", "extends", "satisfies", "abstracts", "in", "out",
            "return", "break", "continue", "throw", "if", "else", "switch", "case", "for", "while",
            "try", "catch", "finally", "this", "outer", "super", "is", "exists", "nonempty", "then",
            "dynamic", "new", "let");

    @Override
    public CodeCompletionResult complete(CodeCompletionContext context) {
        List<CompletionProposal> proposals = new LinkedList<CompletionProposal>();
        for (String word : KEYWORDS) {
            CeylonElementHandle element
                    = CeylonElementHandle.with(word, new OffsetRange(2, 10), ElementKind.METHOD)
                    .withModifier(Modifier.STATIC)
                    .build();
            proposals.add(CeylonCompletionProposal.forElement(element));
        }
        return new CeylonCodeCompletionResult(proposals);
    }

    @Override
    public String document(ParserResult pr, ElementHandle eh) {
        return "No documentation";
    }

    @Override
    public ElementHandle resolveLink(String string, ElementHandle eh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrefix(ParserResult info, int caretOffset, boolean upToOffset) {
        Snapshot snapshot = info.getSnapshot();
        CharSequence text = snapshot.getText();
        int startOfWord = startOfWordAt(caretOffset, text);
        return text.subSequence(startOfWord, caretOffset).toString();
    }

    private int startOfWordAt(int offset, CharSequence text) {
        int startOfWord = offset;
        while (startOfWord > 0 && CeylonLanguage.isCeylonIdentifierChar(text.charAt(startOfWord - 1))) {
            startOfWord--;
        }
        return startOfWord;
    }

    @Override
    public QueryType getAutoQuery(JTextComponent jtc, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String resolveTemplateVariable(String string, ParserResult pr, int i, String string1, Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getApplicableTemplates(Document dcmnt, int i, int i1) {
        return new LinkedHashSet<String>();
    }

    @Override
    public ParameterInfo parameters(ParserResult pr, int i, CompletionProposal cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
